/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.Defaulted
import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object CountryregioncurrencyRepoImpl extends CountryregioncurrencyRepo {
  override def delete(compositeId: CountryregioncurrencyId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.countryregioncurrency where countryregioncode = ${compositeId.countryregioncode} AND currencycode = ${compositeId.currencycode}".executeUpdate() > 0
  }
  override def insert(unsaved: CountryregioncurrencyRow)(implicit c: Connection): CountryregioncurrencyRow = {
    SQL"""insert into sales.countryregioncurrency(countryregioncode, currencycode, modifieddate)
          values (${unsaved.countryregioncode}, ${unsaved.currencycode}::bpchar, ${unsaved.modifieddate}::timestamp)
          returning countryregioncode, currencycode, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  override def insert(unsaved: CountryregioncurrencyRowUnsaved)(implicit c: Connection): CountryregioncurrencyRow = {
    val namedParameters = List(
      Some((NamedParameter("countryregioncode", ParameterValue.from(unsaved.countryregioncode)), "")),
      Some((NamedParameter("currencycode", ParameterValue.from(unsaved.currencycode)), "::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.countryregioncurrency default values
            returning countryregioncode, currencycode, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into sales.countryregioncurrency(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning countryregioncode, currencycode, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[CountryregioncurrencyRow] = {
    SQL"""select countryregioncode, currencycode, modifieddate
          from sales.countryregioncurrency
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CountryregioncurrencyFieldOrIdValue[_]])(implicit c: Connection): List[CountryregioncurrencyRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CountryregioncurrencyFieldValue.countryregioncode(value) => NamedParameter("countryregioncode", ParameterValue.from(value))
          case CountryregioncurrencyFieldValue.currencycode(value) => NamedParameter("currencycode", ParameterValue.from(value))
          case CountryregioncurrencyFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select countryregioncode, currencycode, modifieddate
                    from sales.countryregioncurrency
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: CountryregioncurrencyId)(implicit c: Connection): Option[CountryregioncurrencyRow] = {
    SQL"""select countryregioncode, currencycode, modifieddate
          from sales.countryregioncurrency
          where countryregioncode = ${compositeId.countryregioncode} AND currencycode = ${compositeId.currencycode}
       """.as(rowParser.singleOpt)
  }
  override def update(row: CountryregioncurrencyRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.countryregioncurrency
          set modifieddate = ${row.modifieddate}::timestamp
          where countryregioncode = ${compositeId.countryregioncode} AND currencycode = ${compositeId.currencycode}
       """.executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: CountryregioncurrencyId, fieldValues: List[CountryregioncurrencyFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CountryregioncurrencyFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update sales.countryregioncurrency
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where countryregioncode = {countryregioncode} AND currencycode = {currencycode}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("countryregioncode", ParameterValue.from(compositeId.countryregioncode)), NamedParameter("currencycode", ParameterValue.from(compositeId.currencycode)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: CountryregioncurrencyRow)(implicit c: Connection): CountryregioncurrencyRow = {
    SQL"""insert into sales.countryregioncurrency(countryregioncode, currencycode, modifieddate)
          values (
            ${unsaved.countryregioncode},
            ${unsaved.currencycode}::bpchar,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (countryregioncode, currencycode)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning countryregioncode, currencycode, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  val rowParser: RowParser[CountryregioncurrencyRow] =
    RowParser[CountryregioncurrencyRow] { row =>
      Success(
        CountryregioncurrencyRow(
          countryregioncode = row[CountryregionId]("countryregioncode"),
          currencycode = row[CurrencyId]("currencycode"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
