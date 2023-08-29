/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object BillofmaterialsRepoImpl extends BillofmaterialsRepo {
  override def delete(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.billofmaterials where "billofmaterialsid" = ${ParameterValue(billofmaterialsid, null, BillofmaterialsId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    DeleteBuilder("production.billofmaterials", BillofmaterialsFields)
  }
  override def insert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow = {
    SQL"""insert into production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")
          values (${ParameterValue(unsaved.billofmaterialsid, null, BillofmaterialsId.toStatement)}::int4, ${ParameterValue(unsaved.productassemblyid, null, ToStatement.optionToStatement(ProductId.toStatement, ProductId.parameterMetadata))}::int4, ${ParameterValue(unsaved.componentid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.unitmeasurecode, null, UnitmeasureId.toStatement)}::bpchar, ${ParameterValue(unsaved.bomlevel, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.perassemblyqty, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
       """
      .executeInsert(BillofmaterialsRow.rowParser(1).single)
    
  }
  override def insert(unsaved: BillofmaterialsRowUnsaved)(implicit c: Connection): BillofmaterialsRow = {
    val namedParameters = List(
      Some((NamedParameter("productassemblyid", ParameterValue(unsaved.productassemblyid, null, ToStatement.optionToStatement(ProductId.toStatement, ProductId.parameterMetadata))), "::int4")),
      Some((NamedParameter("componentid", ParameterValue(unsaved.componentid, null, ProductId.toStatement)), "::int4")),
      Some((NamedParameter("enddate", ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
      Some((NamedParameter("unitmeasurecode", ParameterValue(unsaved.unitmeasurecode, null, UnitmeasureId.toStatement)), "::bpchar")),
      Some((NamedParameter("bomlevel", ParameterValue(unsaved.bomlevel, null, ToStatement.intToStatement)), "::int2")),
      unsaved.billofmaterialsid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("billofmaterialsid", ParameterValue(value, null, BillofmaterialsId.toStatement)), "::int4"))
      },
      unsaved.startdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("startdate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      },
      unsaved.perassemblyqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("perassemblyqty", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.billofmaterials default values
            returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
         """
        .executeInsert(BillofmaterialsRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.billofmaterials(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(BillofmaterialsRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    SelectBuilderSql("production.billofmaterials", BillofmaterialsFields, BillofmaterialsRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[BillofmaterialsRow] = {
    SQL"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
          from production.billofmaterials
       """.as(BillofmaterialsRow.rowParser(1).*)
  }
  override def selectById(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Option[BillofmaterialsRow] = {
    SQL"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
          from production.billofmaterials
          where "billofmaterialsid" = ${ParameterValue(billofmaterialsid, null, BillofmaterialsId.toStatement)}
       """.as(BillofmaterialsRow.rowParser(1).singleOpt)
  }
  override def selectByIds(billofmaterialsids: Array[BillofmaterialsId])(implicit c: Connection): List[BillofmaterialsRow] = {
    SQL"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
          from production.billofmaterials
          where "billofmaterialsid" = ANY(${billofmaterialsids})
       """.as(BillofmaterialsRow.rowParser(1).*)
    
  }
  override def update(row: BillofmaterialsRow)(implicit c: Connection): Boolean = {
    val billofmaterialsid = row.billofmaterialsid
    SQL"""update production.billofmaterials
          set "productassemblyid" = ${ParameterValue(row.productassemblyid, null, ToStatement.optionToStatement(ProductId.toStatement, ProductId.parameterMetadata))}::int4,
              "componentid" = ${ParameterValue(row.componentid, null, ProductId.toStatement)}::int4,
              "startdate" = ${ParameterValue(row.startdate, null, TypoLocalDateTime.toStatement)}::timestamp,
              "enddate" = ${ParameterValue(row.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              "unitmeasurecode" = ${ParameterValue(row.unitmeasurecode, null, UnitmeasureId.toStatement)}::bpchar,
              "bomlevel" = ${ParameterValue(row.bomlevel, null, ToStatement.intToStatement)}::int2,
              "perassemblyqty" = ${ParameterValue(row.perassemblyqty, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "billofmaterialsid" = ${ParameterValue(billofmaterialsid, null, BillofmaterialsId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    UpdateBuilder("production.billofmaterials", BillofmaterialsFields, BillofmaterialsRow.rowParser)
  }
  override def upsert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow = {
    SQL"""insert into production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")
          values (
            ${ParameterValue(unsaved.billofmaterialsid, null, BillofmaterialsId.toStatement)}::int4,
            ${ParameterValue(unsaved.productassemblyid, null, ToStatement.optionToStatement(ProductId.toStatement, ProductId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.componentid, null, ProductId.toStatement)}::int4,
            ${ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.unitmeasurecode, null, UnitmeasureId.toStatement)}::bpchar,
            ${ParameterValue(unsaved.bomlevel, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.perassemblyqty, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("billofmaterialsid")
          do update set
            "productassemblyid" = EXCLUDED."productassemblyid",
            "componentid" = EXCLUDED."componentid",
            "startdate" = EXCLUDED."startdate",
            "enddate" = EXCLUDED."enddate",
            "unitmeasurecode" = EXCLUDED."unitmeasurecode",
            "bomlevel" = EXCLUDED."bomlevel",
            "perassemblyqty" = EXCLUDED."perassemblyqty",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
       """
      .executeInsert(BillofmaterialsRow.rowParser(1).single)
    
  }
}
