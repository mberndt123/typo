package typo
package internal
package codegen

import play.api.libs.json.Json
import typo.internal.codegen.DbLib.RowType

case class FilesTable(table: ComputedTable, fkAnalysis: FkAnalysis, options: InternalOptions, domainsByName: Map[db.RelationName, ComputedDomain]) {
  val relation = FilesRelation(table.naming, table.names, Some(table.cols), Some(fkAnalysis), options, table.dbTable.foreignKeys)
  val RowFile = relation.RowFile(RowType.ReadWriteable, table.dbTable.comment, maybeUnsavedRow = table.maybeUnsavedRow.map(u => (u, table.default)))

  val UnsavedRowFile: Option[sc.File] =
    for {
      unsaved <- table.maybeUnsavedRow
    } yield {
      val comments = scaladoc(s"This class corresponds to a row in table `${table.dbTable.name.value}` which has not been persisted yet")(Nil)

      val toRow: sc.Code = {
        def mkDefaultParamName(col: ComputedColumn): sc.Ident =
          sc.Ident(col.name.value).appended("Default")

        val params: NonEmptyList[sc.Param] =
          unsaved.defaultCols.map { case ComputedRowUnsaved.DefaultedCol(col, originalType) => sc.Param(mkDefaultParamName(col), sc.Type.ByName(originalType), None) } ++
            unsaved.alwaysGeneratedCols.map(col => sc.Param(mkDefaultParamName(col), sc.Type.ByName(col.tpe), None))

        val keyValues = unsaved.categorizedColumnsOriginalOrder.map {
          case ComputedRowUnsaved.DefaultedCol(col, defaultType) =>
            val defaultParamName = mkDefaultParamName(col)
            val impl = code"""|${col.name} match {
                   |  case ${table.default.Defaulted}.${table.default.UseDefault} => $defaultParamName
                   |  case ${table.default.Defaulted}.${table.default.Provided}(value) => value
                   |}""".stripMargin
            (col.name, impl)
          case ComputedRowUnsaved.AlwaysGeneratedCol(col) =>
            val defaultParamName = mkDefaultParamName(col)
            (col.name, defaultParamName.code)
          case ComputedRowUnsaved.NormalCol(col) =>
            (col.name, sc.QIdent.of(col.name).code)
        }

        code"""|def toRow(${params.map(_.code).mkCode(", ")}): ${table.names.RowName} =
             |  ${table.names.RowName}(
             |    ${keyValues.map { case (k, v) => code"$k = $v" }.mkCode(",\n")}
             |  )""".stripMargin
      }

      val formattedCols = unsaved.allCols.map { col =>
        val commentPieces = List[Iterable[String]](
          col.dbCol.columnDefault.map(x => s"Default: $x"),
          col.dbCol.identity.map(_.asString),
          col.dbCol.comment,
          col.pointsTo map { case (relationName, columnName) =>
            val rowName = table.naming.rowName(relationName)
            s"Points to [[${rowName.dotName}.${table.naming.field(columnName).value}]]"
          },
          col.dbCol.constraints.map(c => s"Constraint ${c.name} affecting columns ${c.columns.map(_.value).mkString(", ")}:  ${c.checkClause}"),
          if (options.debugTypes)
            col.dbCol.jsonDescription.maybeJson.map(other => s"debug: ${Json.stringify(other)}")
          else None
        ).flatten

        val comment = commentPieces match {
          case Nil => sc.Code.Empty
          case nonEmpty =>
            val lines = nonEmpty.flatMap(_.linesIterator).map(_.code)
            code"""|/** ${lines.mkCode("\n")} */
                 |""".stripMargin
        }

        val default = col.dbCol.columnDefault match {
          case Some(_) => code" = ${table.default.Defaulted}.${table.default.UseDefault}"
          case None    => sc.Code.Empty
        }
        code"$comment${col.param.code}$default"
      }

      val instances =
        options.jsonLibs.flatMap(_.instances(unsaved.tpe, unsaved.allCols)) ++
          options.dbLib.toList.flatMap(_.rowInstances(unsaved.tpe, unsaved.allCols, rowType = DbLib.RowType.Writable))

      sc.File(
        unsaved.tpe,
        code"""|$comments
             |case class ${unsaved.tpe.name}(
             |  ${formattedCols.mkCode(",\n")}
             |) {
             |  $toRow
             |}
             |${genObject(unsaved.tpe.value, instances)}
             |""".stripMargin,
        secondaryTypes = Nil,
        scope = Scope.Main
      )
    }

  val IdFile: Option[sc.File] = {
    table.maybeId.flatMap {
      case id: IdComputed.UnaryNormal =>
        val value = sc.Ident("value")
        val comments = scaladoc(s"Type for the primary key of table `${table.dbTable.name.value}`")(Nil)
        val bijection =
          if (options.enableDsl)
            Some {
              val thisBijection = sc.Type.dsl.Bijection.of(id.tpe, id.underlying)
              sc.Given(Nil, sc.Ident("bijection"), Nil, thisBijection, code"$thisBijection(_.$value)(${id.tpe}.apply)")
            }
          else None

        // shortcut for id files wrapping a domain
        val maybeFromString: Option[sc.Value] =
          id.col.dbCol.tpe match {
            case db.Type.DomainRef(name, _, _) =>
              domainsByName.get(name).map { domain =>
                val name = domain.underlying.constraintDefinition match {
                  case Some(_) => domain.tpe.name.map(Naming.camelCase)
                  case None    => sc.Ident("apply")
                }
                sc.Value(Nil, name, List(sc.Param(value, domain.underlyingType, None)), Nil, id.tpe, code"${id.tpe}(${domain.tpe}($value))")
              }
            case _ => None
          }

        val instances = List(
          bijection.toList,
          options.jsonLibs.flatMap(_.wrapperTypeInstances(wrapperType = id.tpe, fieldName = value, underlying = id.underlying)),
          options.dbLib.toList.flatMap(_.wrapperTypeInstances(wrapperType = id.tpe, underlying = id.underlying, overrideDbType = None))
        ).flatten
        Some(
          sc.File(
            id.tpe,
            code"""|$comments
                   |case class ${id.tpe.name}($value: ${id.underlying}) extends AnyVal
                   |${genObject(id.tpe.value, instances ++ maybeFromString)}
                   |""".stripMargin,
            secondaryTypes = Nil,
            scope = Scope.Main
          )
        )

      case _: IdComputed.UnaryUserSpecified | _: IdComputed.UnaryNoIdType | _: IdComputed.UnaryInherited =>
        None
      case id @ IdComputed.Composite(cols, tpe, _) =>
        val constructorMethod = fkAnalysis.createWithFkIdsId.map { colsFromFks =>
          val body =
            code"""|${tpe.name}(
                   |  ${colsFromFks.allExpr.map { case (colName, expr) => code"$colName = $expr" }.mkCode(",\n")}
                   |)""".stripMargin

          sc.Value(Nil, sc.Ident("from"), colsFromFks.allParams, Nil, tpe, body)
        }
        val instanceMethods: List[sc.Value] =
          fkAnalysis.extractFksIdsFromId.map { colsToFk =>
            val args = colsToFk.colPairs.map { case (inComposite, inId) => code"${inComposite.name} = ${inId.name}" }

            val body =
              code"""|${colsToFk.otherCompositeIdType}(
                       |  ${args.mkCode(",\n")}
                      |)""".stripMargin

            sc.Value(Nil, colsToFk.name.prepended("extract"), Nil, Nil, colsToFk.otherCompositeIdType, body)
          }
        val renderedInstanceMethods = instanceMethods match {
          case Nil => sc.Code.Empty
          case nonEmpty =>
            code"""|{
                   |${nonEmpty.map(_.code).mkCode("\n")}
                   |}""".stripMargin
        }

        val comments = scaladoc(s"Type for the composite primary key of table `${table.dbTable.name.value}`")(Nil)
        val instances = options.jsonLibs.flatMap(_.instances(tpe = id.tpe, cols = cols))
        Some(
          sc.File(
            id.tpe,
            code"""|$comments
                   |case class ${tpe.name}(
                   |  ${cols.map(_.param.code).mkCode(",\n")}
                   |)$renderedInstanceMethods
                   |${genObject(tpe.value, instances ++ constructorMethod)}
                   |""".stripMargin,
            secondaryTypes = Nil,
            scope = Scope.Main
          )
        )
    }
  }

  private val maybeMockRepo: Option[sc.File] =
    if (options.generateMockRepos.include(table.dbTable.name))
      for {
        id <- table.maybeId
        repoMethods <- table.repoMethods
        dbLib <- options.dbLib
      } yield relation.RepoMockFile(dbLib, id, repoMethods)
    else None

  val all: List[sc.File] = List(
    RowFile,
    relation.FieldsFile,
    UnsavedRowFile,
    for {
      repoMethods <- table.repoMethods
      dbLib <- options.dbLib
    } yield relation.RepoTraitFile(dbLib, repoMethods),
    for {
      repoMethods <- table.repoMethods
      dbLib <- options.dbLib
    } yield relation.RepoImplFile(dbLib, repoMethods),
    relation.FieldValueFile,
    maybeMockRepo,
    IdFile
  ).flatten
}
