/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import adventureworks.streamingInsert
import anorm.NamedParameter
import anorm.ParameterMetaData
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

class SalespersonRepoImpl extends SalespersonRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.salesperson where "businessentityid" = ${ParameterValue(businessentityid, null, BusinessentityId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[SalespersonFields, SalespersonRow] = {
    DeleteBuilder("sales.salesperson", SalespersonFields)
  }
  override def insert(unsaved: SalespersonRow)(implicit c: Connection): SalespersonRow = {
    SQL"""insert into sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))}::int4, ${ParameterValue(unsaved.salesquota, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric, ${ParameterValue(unsaved.bonus, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.commissionpct, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.salesytd, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.saleslastyear, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalespersonRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[SalespersonRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalespersonRow.text, c)
  }
  override def insert(unsaved: SalespersonRowUnsaved)(implicit c: Connection): SalespersonRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("territoryid", ParameterValue(unsaved.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))), "::int4")),
      Some((NamedParameter("salesquota", ParameterValue(unsaved.salesquota, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))), "::numeric")),
      unsaved.bonus match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("bonus", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.commissionpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("commissionpct", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.salesytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("salesytd", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.saleslastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("saleslastyear", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
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
      SQL"""insert into sales.salesperson default values
            returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
         """
        .executeInsert(SalespersonRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salesperson(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SalespersonRow.rowParser(1).single)
    }
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SalespersonRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalespersonRowUnsaved.text, c)
  }
  override def select: SelectBuilder[SalespersonFields, SalespersonRow] = {
    SelectBuilderSql("sales.salesperson", SalespersonFields, SalespersonRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalespersonRow] = {
    SQL"""select "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
          from sales.salesperson
       """.as(SalespersonRow.rowParser(1).*)
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[SalespersonRow] = {
    SQL"""select "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
          from sales.salesperson
          where "businessentityid" = ${ParameterValue(businessentityid, null, BusinessentityId.toStatement)}
       """.as(SalespersonRow.rowParser(1).singleOpt)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[SalespersonRow] = {
    SQL"""select "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
          from sales.salesperson
          where "businessentityid" = ANY(${businessentityids})
       """.as(SalespersonRow.rowParser(1).*)
    
  }
  override def update(row: SalespersonRow)(implicit c: Connection): Boolean = {
    val businessentityid = row.businessentityid
    SQL"""update sales.salesperson
          set "territoryid" = ${ParameterValue(row.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))}::int4,
              "salesquota" = ${ParameterValue(row.salesquota, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
              "bonus" = ${ParameterValue(row.bonus, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "commissionpct" = ${ParameterValue(row.commissionpct, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "salesytd" = ${ParameterValue(row.salesytd, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "saleslastyear" = ${ParameterValue(row.saleslastyear, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(businessentityid, null, BusinessentityId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[SalespersonFields, SalespersonRow] = {
    UpdateBuilder("sales.salesperson", SalespersonFields, SalespersonRow.rowParser)
  }
  override def upsert(unsaved: SalespersonRow)(implicit c: Connection): SalespersonRow = {
    SQL"""insert into sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.salesquota, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
            ${ParameterValue(unsaved.bonus, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.commissionpct, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.salesytd, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.saleslastyear, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "territoryid" = EXCLUDED."territoryid",
            "salesquota" = EXCLUDED."salesquota",
            "bonus" = EXCLUDED."bonus",
            "commissionpct" = EXCLUDED."commissionpct",
            "salesytd" = EXCLUDED."salesytd",
            "saleslastyear" = EXCLUDED."saleslastyear",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalespersonRow.rowParser(1).single)
    
  }
}
