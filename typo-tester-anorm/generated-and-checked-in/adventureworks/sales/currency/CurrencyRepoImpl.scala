/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
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

class CurrencyRepoImpl extends CurrencyRepo {
  override def delete: DeleteBuilder[CurrencyFields, CurrencyRow] = {
    DeleteBuilder("sales.currency", CurrencyFields.structure)
  }
  override def deleteById(currencycode: CurrencyId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.currency where "currencycode" = ${ParameterValue(currencycode, null, CurrencyId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(currencycodes: Array[CurrencyId])(implicit c: Connection): Int = {
    SQL"""delete
          from sales.currency
          where "currencycode" = ANY(${currencycodes})
       """.executeUpdate()
    
  }
  override def insert(unsaved: CurrencyRow)(implicit c: Connection): CurrencyRow = {
    SQL"""insert into sales.currency("currencycode", "name", "modifieddate")
          values (${ParameterValue(unsaved.currencycode, null, CurrencyId.toStatement)}::bpchar, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "currencycode", "name", "modifieddate"::text
       """
      .executeInsert(CurrencyRow.rowParser(1).single)
    
  }
  override def insert(unsaved: CurrencyRowUnsaved)(implicit c: Connection): CurrencyRow = {
    val namedParameters = List(
      Some((NamedParameter("currencycode", ParameterValue(unsaved.currencycode, null, CurrencyId.toStatement)), "::bpchar")),
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.currency default values
            returning "currencycode", "name", "modifieddate"::text
         """
        .executeInsert(CurrencyRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.currency(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "currencycode", "name", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(CurrencyRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[CurrencyRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.currency("currencycode", "name", "modifieddate") FROM STDIN""", batchSize, unsaved)(CurrencyRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[CurrencyRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.currency("currencycode", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(CurrencyRowUnsaved.text, c)
  }
  override def select: SelectBuilder[CurrencyFields, CurrencyRow] = {
    SelectBuilderSql("sales.currency", CurrencyFields.structure, CurrencyRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CurrencyRow] = {
    SQL"""select "currencycode", "name", "modifieddate"::text
          from sales.currency
       """.as(CurrencyRow.rowParser(1).*)
  }
  override def selectById(currencycode: CurrencyId)(implicit c: Connection): Option[CurrencyRow] = {
    SQL"""select "currencycode", "name", "modifieddate"::text
          from sales.currency
          where "currencycode" = ${ParameterValue(currencycode, null, CurrencyId.toStatement)}
       """.as(CurrencyRow.rowParser(1).singleOpt)
  }
  override def selectByIds(currencycodes: Array[CurrencyId])(implicit c: Connection): List[CurrencyRow] = {
    SQL"""select "currencycode", "name", "modifieddate"::text
          from sales.currency
          where "currencycode" = ANY(${currencycodes})
       """.as(CurrencyRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(currencycodes: Array[CurrencyId])(implicit c: Connection): Map[CurrencyId, CurrencyRow] = {
    val byId = selectByIds(currencycodes).view.map(x => (x.currencycode, x)).toMap
    currencycodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[CurrencyFields, CurrencyRow] = {
    UpdateBuilder("sales.currency", CurrencyFields.structure, CurrencyRow.rowParser)
  }
  override def update(row: CurrencyRow)(implicit c: Connection): Boolean = {
    val currencycode = row.currencycode
    SQL"""update sales.currency
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "currencycode" = ${ParameterValue(currencycode, null, CurrencyId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: CurrencyRow)(implicit c: Connection): CurrencyRow = {
    SQL"""insert into sales.currency("currencycode", "name", "modifieddate")
          values (
            ${ParameterValue(unsaved.currencycode, null, CurrencyId.toStatement)}::bpchar,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("currencycode")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "currencycode", "name", "modifieddate"::text
       """
      .executeInsert(CurrencyRow.rowParser(1).single)
    
  }
}
