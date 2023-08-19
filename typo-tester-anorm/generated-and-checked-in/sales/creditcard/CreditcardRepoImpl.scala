/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
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

object CreditcardRepoImpl extends CreditcardRepo {
  override def delete(creditcardid: CreditcardId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.creditcard where creditcardid = ${ParameterValue(creditcardid, null, CreditcardId.toStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[CreditcardFields, CreditcardRow] = {
    DeleteBuilder("sales.creditcard", CreditcardFields)
  }
  override def insert(unsaved: CreditcardRow)(implicit c: Connection): CreditcardRow = {
    SQL"""insert into sales.creditcard(creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate)
          values (${ParameterValue(unsaved.creditcardid, null, CreditcardId.toStatement)}::int4, ${ParameterValue(unsaved.cardtype, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.cardnumber, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.expmonth, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.expyear, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
       """
      .executeInsert(CreditcardRow.rowParser(1).single)
    
  }
  override def insert(unsaved: CreditcardRowUnsaved)(implicit c: Connection): CreditcardRow = {
    val namedParameters = List(
      Some((NamedParameter("cardtype", ParameterValue(unsaved.cardtype, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("cardnumber", ParameterValue(unsaved.cardnumber, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("expmonth", ParameterValue(unsaved.expmonth, null, ToStatement.intToStatement)), "::int2")),
      Some((NamedParameter("expyear", ParameterValue(unsaved.expyear, null, ToStatement.intToStatement)), "::int2")),
      unsaved.creditcardid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("creditcardid", ParameterValue(value, null, CreditcardId.toStatement)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.creditcard default values
            returning creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
         """
        .executeInsert(CreditcardRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.creditcard(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(CreditcardRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[CreditcardFields, CreditcardRow] = {
    SelectBuilderSql("sales.creditcard", CreditcardFields, CreditcardRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CreditcardRow] = {
    SQL"""select creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
          from sales.creditcard
       """.as(CreditcardRow.rowParser(1).*)
  }
  override def selectById(creditcardid: CreditcardId)(implicit c: Connection): Option[CreditcardRow] = {
    SQL"""select creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
          from sales.creditcard
          where creditcardid = ${ParameterValue(creditcardid, null, CreditcardId.toStatement)}
       """.as(CreditcardRow.rowParser(1).singleOpt)
  }
  override def selectByIds(creditcardids: Array[CreditcardId])(implicit c: Connection): List[CreditcardRow] = {
    SQL"""select creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
          from sales.creditcard
          where creditcardid = ANY(${creditcardids})
       """.as(CreditcardRow.rowParser(1).*)
    
  }
  override def update(row: CreditcardRow)(implicit c: Connection): Boolean = {
    val creditcardid = row.creditcardid
    SQL"""update sales.creditcard
          set cardtype = ${ParameterValue(row.cardtype, null, ToStatement.stringToStatement)},
              cardnumber = ${ParameterValue(row.cardnumber, null, ToStatement.stringToStatement)},
              expmonth = ${ParameterValue(row.expmonth, null, ToStatement.intToStatement)}::int2,
              expyear = ${ParameterValue(row.expyear, null, ToStatement.intToStatement)}::int2,
              modifieddate = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where creditcardid = ${ParameterValue(creditcardid, null, CreditcardId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[CreditcardFields, CreditcardRow] = {
    UpdateBuilder("sales.creditcard", CreditcardFields, CreditcardRow.rowParser)
  }
  override def upsert(unsaved: CreditcardRow)(implicit c: Connection): CreditcardRow = {
    SQL"""insert into sales.creditcard(creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate)
          values (
            ${ParameterValue(unsaved.creditcardid, null, CreditcardId.toStatement)}::int4,
            ${ParameterValue(unsaved.cardtype, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.cardnumber, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.expmonth, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.expyear, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict (creditcardid)
          do update set
            cardtype = EXCLUDED.cardtype,
            cardnumber = EXCLUDED.cardnumber,
            expmonth = EXCLUDED.expmonth,
            expyear = EXCLUDED.expyear,
            modifieddate = EXCLUDED.modifieddate
          returning creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
       """
      .executeInsert(CreditcardRow.rowParser(1).single)
    
  }
}
