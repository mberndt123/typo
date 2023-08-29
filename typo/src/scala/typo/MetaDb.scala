package typo

import typo.generated.custom.comments.{CommentsSqlRepoImpl, CommentsSqlRow}
import typo.generated.custom.domains.{DomainsSqlRepoImpl, DomainsSqlRow}
import typo.generated.custom.enums.{EnumsSqlRepoImpl, EnumsSqlRow}
import typo.generated.custom.view_find_all.*
import typo.generated.information_schema.columns.{ColumnsViewRepoImpl, ColumnsViewRow}
import typo.generated.information_schema.key_column_usage.{KeyColumnUsageViewRepoImpl, KeyColumnUsageViewRow}
import typo.generated.information_schema.referential_constraints.{ReferentialConstraintsViewRepoImpl, ReferentialConstraintsViewRow}
import typo.generated.information_schema.table_constraints.{TableConstraintsViewRepoImpl, TableConstraintsViewRow}
import typo.generated.information_schema.tables.{TablesViewRepoImpl, TablesViewRow}
import typo.internal.analysis.{DecomposedSql, JdbcMetadata, NullabilityFromExplain}
import typo.internal.metadb.{Enums, ForeignKeys, PrimaryKeys, UniqueKeys}
import typo.internal.{DebugJson, TypeMapperDb}

import java.sql.Connection

case class MetaDb(
    relations: List[db.Relation],
    enums: List[db.StringEnum],
    domains: List[db.Domain],
    typeMapperDb: TypeMapperDb
)

object MetaDb {
  case class Input(
      tableConstraints: List[TableConstraintsViewRow],
      keyColumnUsage: List[KeyColumnUsageViewRow],
      referentialConstraints: List[ReferentialConstraintsViewRow],
      pgEnums: List[EnumsSqlRow],
      tables: List[TablesViewRow],
      columns: List[ColumnsViewRow],
      views: List[ViewFindAllSqlRow],
      domains: List[DomainsSqlRow],
      columnComments: List[CommentsSqlRow]
  )

  object Input {
    def fromDb(implicit c: Connection): Input = {
      def timed[T](name: String)(f: => T): T = {
        val start = System.currentTimeMillis()
        val result = f
        val end = System.currentTimeMillis()
        println(s"fetched $name from PG in ${end - start}ms")
        result
      }

      Input(
        tableConstraints = timed("tableConstraints")(TableConstraintsViewRepoImpl.selectAll),
        keyColumnUsage = timed("keyColumnUsage")(KeyColumnUsageViewRepoImpl.selectAll),
        referentialConstraints = timed("referentialConstraints")(ReferentialConstraintsViewRepoImpl.selectAll),
        pgEnums = timed("pgEnums")(EnumsSqlRepoImpl()),
        tables = timed("tables")(TablesViewRepoImpl.selectAll),
        columns = timed("columns")(ColumnsViewRepoImpl.selectAll),
        views = timed("views")(ViewFindAllSqlRepoImpl()),
        domains = timed("domains")(DomainsSqlRepoImpl()),
        columnComments = timed("columnComments")(CommentsSqlRepoImpl())
      )
    }
  }

  def fromDb(implicit c: Connection): MetaDb = {
    val input = Input.fromDb

    val foreignKeys = ForeignKeys(input.tableConstraints, input.keyColumnUsage, input.referentialConstraints)
    val primaryKeys = PrimaryKeys(input.tableConstraints, input.keyColumnUsage)
    val uniqueKeys = UniqueKeys(input.tableConstraints, input.keyColumnUsage)
    val enums = Enums(input.pgEnums)

    val domains = input.domains.map { d =>
      val tpe = TypeMapperDb(enums, Nil)
        .dbTypeFrom(
          d.`type`,
          characterMaximumLength = None // todo: this can likely be set
        )
        .getOrElse {
          System.err.println(s"Couldn't translate type from domain $d")
          db.Type.Text
        }

      db.Domain(
        name = db.RelationName(Some(d.schema), d.name),
        tpe = tpe,
        isNotNull = if (d.isNotNull) Nullability.NoNulls else Nullability.Nullable,
        hasDefault = d.default.isDefined,
        constraintDefinition = d.constraintDefinition
      )
    }

    val typeMapperDb = TypeMapperDb(enums, domains)

    val comments: Map[(db.RelationName, db.ColName), String] =
      input.columnComments.collect { case CommentsSqlRow(maybeSchema, Some(table), Some(column), description) =>
        (db.RelationName(maybeSchema, table), db.ColName(column)) -> description
      }.toMap

    val columnsByTable: Map[db.RelationName, List[ColumnsViewRow]] =
      input.columns.groupBy(c => db.RelationName(c.tableSchema, c.tableName.get))

    val views: Map[db.RelationName, db.View] =
      input.views.flatMap { viewRow =>
        val relationName = db.RelationName(viewRow.tableSchema, viewRow.tableName.get)
        viewRow.viewDefinition.map { sqlContent =>
          val decomposedSql = DecomposedSql.parse(sqlContent)
          val Right(jdbcMetadata) = JdbcMetadata.from(sqlContent): @unchecked
          val nullabilityInfo = NullabilityFromExplain.from(decomposedSql, Nil).nullableIndices
          (relationName, db.View(relationName, decomposedSql, jdbcMetadata, nullabilityInfo, isMaterialized = viewRow.relkind == "m"))
        }
      }.toMap

    val tables: List[db.Relation] =
      input.tables.flatMap { relation =>
        val relationName = db.RelationName(schema = relation.tableSchema, name = relation.tableName.get)

        if (views.contains(relationName)) None
        else {
          val columns = columnsByTable(relationName).sortBy(_.ordinalPosition)

          val mappedCols: List[db.Col] =
            columns.map { c =>
              val jsonDescription = DebugJson(c)

              val colName = db.ColName(c.columnName.get)
              val nullability =
                c.isNullable match {
                  case Some("YES") => Nullability.Nullable
                  case Some("NO")  => Nullability.NoNulls
                  case None        => Nullability.NullableUnknown
                  case other       => throw new Exception(s"Unknown nullability: $other")
                }
              val tpe = typeMapperDb.col(c).getOrElse {
                System.err.println(s"Couldn't translate type from relation ${relationName.value} column ${colName.value} with type ${colName.value}. Falling back to text")
                db.Type.Text
              }
              db.Col(
                name = colName,
                columnDefault = c.columnDefault,
                nullability = nullability,
                tpe = tpe,
                udtName = c.udtName,
                comment = comments.get((relationName, colName)),
                jsonDescription = jsonDescription
              )
            }

          for {
            mappedCols <- NonEmptyList.fromList(mappedCols)
          } yield db.Table(
            name = relationName,
            cols = mappedCols,
            primaryKey = primaryKeys.get(relationName),
            uniqueKeys = uniqueKeys.getOrElse(relationName, List.empty),
            foreignKeys = foreignKeys.getOrElse(relationName, List.empty)
          )
        }
      }

    MetaDb(tables ++ views.values, enums, domains, typeMapperDb)
  }
}
