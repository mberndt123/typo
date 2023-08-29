/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
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

object SalesterritoryRepoImpl extends SalesterritoryRepo {
  override def delete(territoryid: SalesterritoryId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.salesterritory where "territoryid" = ${ParameterValue(territoryid, null, SalesterritoryId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[SalesterritoryFields, SalesterritoryRow] = {
    DeleteBuilder("sales.salesterritory", SalesterritoryFields)
  }
  override def insert(unsaved: SalesterritoryRow)(implicit c: Connection): SalesterritoryRow = {
    SQL"""insert into sales.salesterritory("territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.territoryid, null, SalesterritoryId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.countryregioncode, null, CountryregionId.toStatement)}, ${ParameterValue(unsaved.group, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.salesytd, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.saleslastyear, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.costytd, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.costlastyear, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.rowguid, null, ToStatement.uuidToStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalesterritoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalesterritoryRowUnsaved)(implicit c: Connection): SalesterritoryRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      Some((NamedParameter("countryregioncode", ParameterValue(unsaved.countryregioncode, null, CountryregionId.toStatement)), "")),
      Some((NamedParameter("group", ParameterValue(unsaved.group, null, ToStatement.stringToStatement)), "")),
      unsaved.territoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("territoryid", ParameterValue(value, null, SalesterritoryId.toStatement)), "::int4"))
      },
      unsaved.salesytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("salesytd", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.saleslastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("saleslastyear", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.costytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("costytd", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.costlastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("costlastyear", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, ToStatement.uuidToStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.salesterritory default values
            returning "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
         """
        .executeInsert(SalesterritoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salesterritory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SalesterritoryRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[SalesterritoryFields, SalesterritoryRow] = {
    SelectBuilderSql("sales.salesterritory", SalesterritoryFields, SalesterritoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalesterritoryRow] = {
    SQL"""select "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
          from sales.salesterritory
       """.as(SalesterritoryRow.rowParser(1).*)
  }
  override def selectById(territoryid: SalesterritoryId)(implicit c: Connection): Option[SalesterritoryRow] = {
    SQL"""select "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
          from sales.salesterritory
          where "territoryid" = ${ParameterValue(territoryid, null, SalesterritoryId.toStatement)}
       """.as(SalesterritoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(territoryids: Array[SalesterritoryId])(implicit c: Connection): List[SalesterritoryRow] = {
    SQL"""select "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
          from sales.salesterritory
          where "territoryid" = ANY(${territoryids})
       """.as(SalesterritoryRow.rowParser(1).*)
    
  }
  override def update(row: SalesterritoryRow)(implicit c: Connection): Boolean = {
    val territoryid = row.territoryid
    SQL"""update sales.salesterritory
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "countryregioncode" = ${ParameterValue(row.countryregioncode, null, CountryregionId.toStatement)},
              "group" = ${ParameterValue(row.group, null, ToStatement.stringToStatement)},
              "salesytd" = ${ParameterValue(row.salesytd, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "saleslastyear" = ${ParameterValue(row.saleslastyear, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "costytd" = ${ParameterValue(row.costytd, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "costlastyear" = ${ParameterValue(row.costlastyear, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "rowguid" = ${ParameterValue(row.rowguid, null, ToStatement.uuidToStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "territoryid" = ${ParameterValue(territoryid, null, SalesterritoryId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[SalesterritoryFields, SalesterritoryRow] = {
    UpdateBuilder("sales.salesterritory", SalesterritoryFields, SalesterritoryRow.rowParser)
  }
  override def upsert(unsaved: SalesterritoryRow)(implicit c: Connection): SalesterritoryRow = {
    SQL"""insert into sales.salesterritory("territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.territoryid, null, SalesterritoryId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.countryregioncode, null, CountryregionId.toStatement)},
            ${ParameterValue(unsaved.group, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.salesytd, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.saleslastyear, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.costytd, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.costlastyear, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.rowguid, null, ToStatement.uuidToStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("territoryid")
          do update set
            "name" = EXCLUDED."name",
            "countryregioncode" = EXCLUDED."countryregioncode",
            "group" = EXCLUDED."group",
            "salesytd" = EXCLUDED."salesytd",
            "saleslastyear" = EXCLUDED."saleslastyear",
            "costytd" = EXCLUDED."costytd",
            "costlastyear" = EXCLUDED."costlastyear",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalesterritoryRow.rowParser(1).single)
    
  }
}
