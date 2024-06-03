/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class CountryregioncurrencyRepoImpl extends CountryregioncurrencyRepo {
  override def delete: DeleteBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    DeleteBuilder("sales.countryregioncurrency", CountryregioncurrencyFields.structure)
  }
  override def deleteById(compositeId: CountryregioncurrencyId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.countryregioncurrency where "countryregioncode" = ${ParameterValue(compositeId.countryregioncode, null, CountryregionId.toStatement)} AND "currencycode" = ${ParameterValue(compositeId.currencycode, null, CurrencyId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[CountryregioncurrencyId])(implicit c: Connection): Int = {
    val countryregioncode = compositeIds.map(_.countryregioncode)
    val currencycode = compositeIds.map(_.currencycode)
    SQL"""delete
          from sales.countryregioncurrency
          where ("countryregioncode", "currencycode")
          in (select unnest(${countryregioncode}), unnest(${currencycode}))
       """.executeUpdate()
    
  }
  override def insert(unsaved: CountryregioncurrencyRow)(implicit c: Connection): CountryregioncurrencyRow = {
    SQL"""insert into sales.countryregioncurrency("countryregioncode", "currencycode", "modifieddate")
          values (${ParameterValue(unsaved.countryregioncode, null, CountryregionId.toStatement)}, ${ParameterValue(unsaved.currencycode, null, CurrencyId.toStatement)}::bpchar, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "countryregioncode", "currencycode", "modifieddate"::text
       """
      .executeInsert(CountryregioncurrencyRow.rowParser(1).single)
    
  }
  override def insert(unsaved: CountryregioncurrencyRowUnsaved)(implicit c: Connection): CountryregioncurrencyRow = {
    val namedParameters = List(
      Some((NamedParameter("countryregioncode", ParameterValue(unsaved.countryregioncode, null, CountryregionId.toStatement)), "")),
      Some((NamedParameter("currencycode", ParameterValue(unsaved.currencycode, null, CurrencyId.toStatement)), "::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.countryregioncurrency default values
            returning "countryregioncode", "currencycode", "modifieddate"::text
         """
        .executeInsert(CountryregioncurrencyRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.countryregioncurrency(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "countryregioncode", "currencycode", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(CountryregioncurrencyRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[CountryregioncurrencyRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.countryregioncurrency("countryregioncode", "currencycode", "modifieddate") FROM STDIN""", batchSize, unsaved)(CountryregioncurrencyRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[CountryregioncurrencyRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.countryregioncurrency("countryregioncode", "currencycode", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(CountryregioncurrencyRowUnsaved.text, c)
  }
  override def select: SelectBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    SelectBuilderSql("sales.countryregioncurrency", CountryregioncurrencyFields.structure, CountryregioncurrencyRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CountryregioncurrencyRow] = {
    SQL"""select "countryregioncode", "currencycode", "modifieddate"::text
          from sales.countryregioncurrency
       """.as(CountryregioncurrencyRow.rowParser(1).*)
  }
  override def selectById(compositeId: CountryregioncurrencyId)(implicit c: Connection): Option[CountryregioncurrencyRow] = {
    SQL"""select "countryregioncode", "currencycode", "modifieddate"::text
          from sales.countryregioncurrency
          where "countryregioncode" = ${ParameterValue(compositeId.countryregioncode, null, CountryregionId.toStatement)} AND "currencycode" = ${ParameterValue(compositeId.currencycode, null, CurrencyId.toStatement)}
       """.as(CountryregioncurrencyRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[CountryregioncurrencyId])(implicit c: Connection): List[CountryregioncurrencyRow] = {
    val countryregioncode = compositeIds.map(_.countryregioncode)
    val currencycode = compositeIds.map(_.currencycode)
    SQL"""select "countryregioncode", "currencycode", "modifieddate"::text
          from sales.countryregioncurrency
          where ("countryregioncode", "currencycode") 
          in (select unnest(${countryregioncode}), unnest(${currencycode}))
       """.as(CountryregioncurrencyRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(compositeIds: Array[CountryregioncurrencyId])(implicit c: Connection): Map[CountryregioncurrencyId, CountryregioncurrencyRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    UpdateBuilder("sales.countryregioncurrency", CountryregioncurrencyFields.structure, CountryregioncurrencyRow.rowParser)
  }
  override def update(row: CountryregioncurrencyRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.countryregioncurrency
          set "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "countryregioncode" = ${ParameterValue(compositeId.countryregioncode, null, CountryregionId.toStatement)} AND "currencycode" = ${ParameterValue(compositeId.currencycode, null, CurrencyId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: CountryregioncurrencyRow)(implicit c: Connection): CountryregioncurrencyRow = {
    SQL"""insert into sales.countryregioncurrency("countryregioncode", "currencycode", "modifieddate")
          values (
            ${ParameterValue(unsaved.countryregioncode, null, CountryregionId.toStatement)},
            ${ParameterValue(unsaved.currencycode, null, CurrencyId.toStatement)}::bpchar,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("countryregioncode", "currencycode")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "countryregioncode", "currencycode", "modifieddate"::text
       """
      .executeInsert(CountryregioncurrencyRow.rowParser(1).single)
    
  }
}
