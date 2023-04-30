/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

import adventureworks.Defaulted
import adventureworks.sales.currency.CurrencyId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object CurrencyrateRepoImpl extends CurrencyrateRepo {
  override def delete(currencyrateid: CurrencyrateId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.currencyrate where currencyrateid = $currencyrateid".executeUpdate() > 0
  }
  override def insert(unsaved: CurrencyrateRow)(implicit c: Connection): CurrencyrateRow = {
    SQL"""insert into sales.currencyrate(currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate)
          values (${unsaved.currencyrateid}::int4, ${unsaved.currencyratedate}::timestamp, ${unsaved.fromcurrencycode}::bpchar, ${unsaved.tocurrencycode}::bpchar, ${unsaved.averagerate}::numeric, ${unsaved.endofdayrate}::numeric, ${unsaved.modifieddate}::timestamp)
          returning currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  override def insert(unsaved: CurrencyrateRowUnsaved)(implicit c: Connection): CurrencyrateRow = {
    val namedParameters = List(
      Some((NamedParameter("currencyratedate", ParameterValue.from(unsaved.currencyratedate)), "::timestamp")),
      Some((NamedParameter("fromcurrencycode", ParameterValue.from(unsaved.fromcurrencycode)), "::bpchar")),
      Some((NamedParameter("tocurrencycode", ParameterValue.from(unsaved.tocurrencycode)), "::bpchar")),
      Some((NamedParameter("averagerate", ParameterValue.from(unsaved.averagerate)), "::numeric")),
      Some((NamedParameter("endofdayrate", ParameterValue.from(unsaved.endofdayrate)), "::numeric")),
      unsaved.currencyrateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("currencyrateid", ParameterValue.from[CurrencyrateId](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.currencyrate default values
            returning currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into sales.currencyrate(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[CurrencyrateRow] = {
    SQL"""select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
          from sales.currencyrate
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CurrencyrateFieldOrIdValue[_]])(implicit c: Connection): List[CurrencyrateRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CurrencyrateFieldValue.currencyrateid(value) => NamedParameter("currencyrateid", ParameterValue.from(value))
          case CurrencyrateFieldValue.currencyratedate(value) => NamedParameter("currencyratedate", ParameterValue.from(value))
          case CurrencyrateFieldValue.fromcurrencycode(value) => NamedParameter("fromcurrencycode", ParameterValue.from(value))
          case CurrencyrateFieldValue.tocurrencycode(value) => NamedParameter("tocurrencycode", ParameterValue.from(value))
          case CurrencyrateFieldValue.averagerate(value) => NamedParameter("averagerate", ParameterValue.from(value))
          case CurrencyrateFieldValue.endofdayrate(value) => NamedParameter("endofdayrate", ParameterValue.from(value))
          case CurrencyrateFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
                    from sales.currencyrate
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(currencyrateid: CurrencyrateId)(implicit c: Connection): Option[CurrencyrateRow] = {
    SQL"""select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
          from sales.currencyrate
          where currencyrateid = $currencyrateid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(currencyrateids: Array[CurrencyrateId])(implicit c: Connection): List[CurrencyrateRow] = {
    implicit val toStatement: ToStatement[Array[CurrencyrateId]] =
      (s: PreparedStatement, index: Int, v: Array[CurrencyrateId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
          from sales.currencyrate
          where currencyrateid = ANY($currencyrateids)
       """.as(rowParser.*)
  
  }
  override def update(row: CurrencyrateRow)(implicit c: Connection): Boolean = {
    val currencyrateid = row.currencyrateid
    SQL"""update sales.currencyrate
          set currencyratedate = ${row.currencyratedate}::timestamp,
              fromcurrencycode = ${row.fromcurrencycode}::bpchar,
              tocurrencycode = ${row.tocurrencycode}::bpchar,
              averagerate = ${row.averagerate}::numeric,
              endofdayrate = ${row.endofdayrate}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where currencyrateid = $currencyrateid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(currencyrateid: CurrencyrateId, fieldValues: List[CurrencyrateFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CurrencyrateFieldValue.currencyratedate(value) => NamedParameter("currencyratedate", ParameterValue.from(value))
          case CurrencyrateFieldValue.fromcurrencycode(value) => NamedParameter("fromcurrencycode", ParameterValue.from(value))
          case CurrencyrateFieldValue.tocurrencycode(value) => NamedParameter("tocurrencycode", ParameterValue.from(value))
          case CurrencyrateFieldValue.averagerate(value) => NamedParameter("averagerate", ParameterValue.from(value))
          case CurrencyrateFieldValue.endofdayrate(value) => NamedParameter("endofdayrate", ParameterValue.from(value))
          case CurrencyrateFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update sales.currencyrate
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where currencyrateid = {currencyrateid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("currencyrateid", ParameterValue.from(currencyrateid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: CurrencyrateRow)(implicit c: Connection): CurrencyrateRow = {
    SQL"""insert into sales.currencyrate(currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate)
          values (
            ${unsaved.currencyrateid}::int4,
            ${unsaved.currencyratedate}::timestamp,
            ${unsaved.fromcurrencycode}::bpchar,
            ${unsaved.tocurrencycode}::bpchar,
            ${unsaved.averagerate}::numeric,
            ${unsaved.endofdayrate}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (currencyrateid)
          do update set
            currencyratedate = EXCLUDED.currencyratedate,
            fromcurrencycode = EXCLUDED.fromcurrencycode,
            tocurrencycode = EXCLUDED.tocurrencycode,
            averagerate = EXCLUDED.averagerate,
            endofdayrate = EXCLUDED.endofdayrate,
            modifieddate = EXCLUDED.modifieddate
          returning currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  val rowParser: RowParser[CurrencyrateRow] =
    RowParser[CurrencyrateRow] { row =>
      Success(
        CurrencyrateRow(
          currencyrateid = row[CurrencyrateId]("currencyrateid"),
          currencyratedate = row[LocalDateTime]("currencyratedate"),
          fromcurrencycode = row[CurrencyId]("fromcurrencycode"),
          tocurrencycode = row[CurrencyId]("tocurrencycode"),
          averagerate = row[BigDecimal]("averagerate"),
          endofdayrate = row[BigDecimal]("endofdayrate"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
