package typo.internal.sqlfiles

import anorm.*
import org.postgresql.core.SqlCommandType
import org.postgresql.jdbc.PgConnection
import org.postgresql.util.PSQLException
import typo.generated.custom.view_column_dependencies.ViewColumnDependenciesSqlRepoImpl
import typo.internal.{DebugJson, TypeMapperDb}
import typo.{RelPath, db}

import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.{FileVisitResult, Files, Path, SimpleFileVisitor}
import java.sql.Connection

object Load {
  def apply(scriptsPath: Path, typeMapperDb: TypeMapperDb)(implicit c: Connection): List[SqlFile] =
    findSqlFilesUnder(scriptsPath).flatMap { sqlFile =>
      val sqlContent = Files.readString(sqlFile)
      val decomposedSql = DecomposedSql.parse(sqlContent)
      val relativePath = RelPath.relativeTo(scriptsPath, sqlFile)

      val deps: Map[db.ColName, (db.RelationName, db.ColName)] =
        if (isSelect(decomposedSql, c))
          fetchDepsViaTemporaryView(sqlFile, decomposedSql, relativePath)
        else
          Map.empty

      try {
        val jdbcMetadata = JdbcMetadata.from(decomposedSql.sqlWithQuestionMarks)
        Some(
          parseSqlFile(
            typeMapperDb,
            RelPath.relativeTo(scriptsPath, sqlFile),
            decomposedSql,
            jdbcMetadata,
            deps
          )
        )

      } catch {
        case e: PSQLException =>
          System.err.println(s"Error while parsing $sqlFile : ${e.getMessage}. Will ignore the file. SQL: ${decomposedSql.sqlWithQuestionMarks}")
          None
      }
    }

  def isSelect(decomposedSql: DecomposedSql, c: Connection) = {
    val pc = c.unwrap(classOf[PgConnection])
    val q = pc.createQuery(decomposedSql.sqlWithNulls, true, false)
    val isSelect = q.query.getSqlCommand.getType match {
      case SqlCommandType.SELECT => true
      case _                     => false
    }
    isSelect
  }

  /** believe it or not the dependency information we get through prepared statements and for views are not the same. It's too valuable information to leave out, so let's try to read it from a
    * temporary view.
    */
  def fetchDepsViaTemporaryView(sqlFile: Path, decomposedSql: DecomposedSql, relativePath: RelPath)(implicit c: Connection): Map[db.ColName, (db.RelationName, db.ColName)] = {
    val viewName = relativePath.segments.mkString("_").replace(".sql", "")
    val sql = s"""create temporary view $viewName as (${decomposedSql.sqlWithNulls})"""
    try {
      SQL(sql).execute()
      val ret = ViewColumnDependenciesSqlRepoImpl(Some(viewName)).map { row =>
        val table = db.RelationName(row.tableSchema.map(_.value), row.tableName)
        (db.ColName(row.columnName), (table, db.ColName(row.columnName)))
      }.toMap
      SQL(s"drop view $viewName").execute()
      ret
    } catch {
      case e: PSQLException =>
        if (e.getMessage.contains("syntax error")) {
          System.err.println(s"Couldn't read dependencies for $sqlFile through a temporary view: ${e.getMessage}. SQL: $sql")
        }
        System.err.println(s"Couldn't read dependencies for $sqlFile through a temporary view: ${e.getMessage}. SQL: $sql")
        Map.empty
    }
  }

  def findSqlFilesUnder(scriptsPath: Path): List[Path] = {
    val found = List.newBuilder[Path]
    Files.walkFileTree(
      scriptsPath,
      new SimpleFileVisitor[Path] {
        override def visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult = {
          if (file.toString.endsWith(".sql")) found += file
          FileVisitResult.CONTINUE
        }
      }
    )
    found.result()
  }

  def parseSqlFile(
      typeMapperDb: TypeMapperDb,
      relativePath: RelPath,
      decomposedSql: DecomposedSql,
      jdbcMetadata: JdbcMetadata,
      depsFromView: Map[db.ColName, (db.RelationName, db.ColName)]
  ): SqlFile = {
    val cols = jdbcMetadata.columns.map { cols =>
      cols.map { col =>
        val jsonDescription = DebugJson(col)
        db.Col(
          name = col.name,
          tpe = typeMapperDb.dbTypeFrom(col.columnTypeName, Some(col.precision)).getOrElse {
            System.err.println(s"Couldn't translate type from file $relativePath column ${col.name.value} with type ${col.columnTypeName}. Falling back to text")
            db.Type.Text
          },
          udtName = None,
          columnDefault = if (col.isAutoIncrement) Some("auto-increment") else None,
          comment = None,
          jsonDescription = jsonDescription,
          nullability = col.isNullable.toNullability
        )
      }
    }

    val deps: Map[db.ColName, (db.RelationName, db.ColName)] = {
      val fromCols = jdbcMetadata.columns match {
        case MaybeReturnsRows.Query(columns) =>
          columns.toList.flatMap { col =>
            col.baseRelationName.zip(col.baseColumnName).map(col.name -> _)
          }
        case MaybeReturnsRows.Update => Nil

      }
      depsFromView ++ fromCols
    }

    val params = decomposedSql.paramNamesWithIndices.map { case (maybeName, indices) =>
      val jdbcParam = jdbcMetadata.params(indices.head)
      val tpe = typeMapperDb.dbTypeFrom(jdbcParam.parameterTypeName, Some(jdbcParam.precision)).getOrElse {
        System.err.println(s"$relativePath: Couldn't translate type from param $maybeName")
        db.Type.Text
      }
      SqlFile.Param(maybeName, indices, jdbcParam.parameterTypeName, tpe)
    }

    SqlFile(relativePath, decomposedSql, params, cols, deps)
  }
}
