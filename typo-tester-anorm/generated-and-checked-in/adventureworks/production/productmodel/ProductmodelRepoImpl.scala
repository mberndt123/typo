/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodel

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.public.Name
import adventureworks.streamingInsert
import anorm.BatchSql
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ProductmodelRepoImpl extends ProductmodelRepo {
  override def delete: DeleteBuilder[ProductmodelFields, ProductmodelRow] = {
    DeleteBuilder("production.productmodel", ProductmodelFields.structure)
  }
  override def deleteById(productmodelid: ProductmodelId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.productmodel where "productmodelid" = ${ParameterValue(productmodelid, null, ProductmodelId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(productmodelids: Array[ProductmodelId])(implicit c: Connection): Int = {
    SQL"""delete
          from production.productmodel
          where "productmodelid" = ANY(${ParameterValue(productmodelids, null, ProductmodelId.arrayToStatement)})
       """.executeUpdate()
    
  }
  override def insert(unsaved: ProductmodelRow)(implicit c: Connection): ProductmodelRow = {
    SQL"""insert into production.productmodel("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.productmodelid, null, ProductmodelId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.catalogdescription, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml, ${ParameterValue(unsaved.instructions, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
       """
      .executeInsert(ProductmodelRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductmodelRowUnsaved)(implicit c: Connection): ProductmodelRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      Some((NamedParameter("catalogdescription", ParameterValue(unsaved.catalogdescription, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))), "::xml")),
      Some((NamedParameter("instructions", ParameterValue(unsaved.instructions, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))), "::xml")),
      unsaved.productmodelid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("productmodelid", ParameterValue(value, null, ProductmodelId.toStatement)), "::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, TypoUUID.toStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productmodel default values
            returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
         """
        .executeInsert(ProductmodelRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productmodel(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductmodelRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[ProductmodelRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY production.productmodel("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductmodelRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductmodelRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY production.productmodel("name", "catalogdescription", "instructions", "productmodelid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductmodelRowUnsaved.text, c)
  }
  override def select: SelectBuilder[ProductmodelFields, ProductmodelRow] = {
    SelectBuilderSql("production.productmodel", ProductmodelFields.structure, ProductmodelRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductmodelRow] = {
    SQL"""select "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
          from production.productmodel
       """.as(ProductmodelRow.rowParser(1).*)
  }
  override def selectById(productmodelid: ProductmodelId)(implicit c: Connection): Option[ProductmodelRow] = {
    SQL"""select "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
          from production.productmodel
          where "productmodelid" = ${ParameterValue(productmodelid, null, ProductmodelId.toStatement)}
       """.as(ProductmodelRow.rowParser(1).singleOpt)
  }
  override def selectByIds(productmodelids: Array[ProductmodelId])(implicit c: Connection): List[ProductmodelRow] = {
    SQL"""select "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
          from production.productmodel
          where "productmodelid" = ANY(${ParameterValue(productmodelids, null, ProductmodelId.arrayToStatement)})
       """.as(ProductmodelRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(productmodelids: Array[ProductmodelId])(implicit c: Connection): Map[ProductmodelId, ProductmodelRow] = {
    val byId = selectByIds(productmodelids).view.map(x => (x.productmodelid, x)).toMap
    productmodelids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ProductmodelFields, ProductmodelRow] = {
    UpdateBuilder("production.productmodel", ProductmodelFields.structure, ProductmodelRow.rowParser)
  }
  override def update(row: ProductmodelRow)(implicit c: Connection): Boolean = {
    val productmodelid = row.productmodelid
    SQL"""update production.productmodel
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "catalogdescription" = ${ParameterValue(row.catalogdescription, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
              "instructions" = ${ParameterValue(row.instructions, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "productmodelid" = ${ParameterValue(productmodelid, null, ProductmodelId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: ProductmodelRow)(implicit c: Connection): ProductmodelRow = {
    SQL"""insert into production.productmodel("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.productmodelid, null, ProductmodelId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.catalogdescription, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
            ${ParameterValue(unsaved.instructions, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("productmodelid")
          do update set
            "name" = EXCLUDED."name",
            "catalogdescription" = EXCLUDED."catalogdescription",
            "instructions" = EXCLUDED."instructions",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
       """
      .executeInsert(ProductmodelRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[ProductmodelRow])(implicit c: Connection): List[ProductmodelRow] = {
    def toNamedParameter(row: ProductmodelRow): List[NamedParameter] = List(
      NamedParameter("productmodelid", ParameterValue(row.productmodelid, null, ProductmodelId.toStatement)),
      NamedParameter("name", ParameterValue(row.name, null, Name.toStatement)),
      NamedParameter("catalogdescription", ParameterValue(row.catalogdescription, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))),
      NamedParameter("instructions", ParameterValue(row.instructions, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))),
      NamedParameter("rowguid", ParameterValue(row.rowguid, null, TypoUUID.toStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into production.productmodel("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")
                values ({productmodelid}::int4, {name}::varchar, {catalogdescription}::xml, {instructions}::xml, {rowguid}::uuid, {modifieddate}::timestamp)
                on conflict ("productmodelid")
                do update set
                  "name" = EXCLUDED."name",
                  "catalogdescription" = EXCLUDED."catalogdescription",
                  "instructions" = EXCLUDED."instructions",
                  "rowguid" = EXCLUDED."rowguid",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(ProductmodelRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[ProductmodelRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"create temporary table productmodel_TEMP (like production.productmodel) on commit drop".execute(): @nowarn
    streamingInsert(s"""copy productmodel_TEMP("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(ProductmodelRow.text, c): @nowarn
    SQL"""insert into production.productmodel("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")
          select * from productmodel_TEMP
          on conflict ("productmodelid")
          do update set
            "name" = EXCLUDED."name",
            "catalogdescription" = EXCLUDED."catalogdescription",
            "instructions" = EXCLUDED."instructions",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table productmodel_TEMP;""".executeUpdate()
  }
}
