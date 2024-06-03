/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.userdefined.CustomCreditcardId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class CreditcardRepoImpl extends CreditcardRepo {
  override def delete: DeleteBuilder[CreditcardFields, CreditcardRow] = {
    DeleteBuilder("sales.creditcard", CreditcardFields.structure)
  }
  override def deleteById(creditcardid: /* user-picked */ CustomCreditcardId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.creditcard where "creditcardid" = ${Segment.paramSegment(creditcardid)(/* user-picked */ CustomCreditcardId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from sales.creditcard where "creditcardid" = ANY(${creditcardids})""".delete
  }
  override def insert(unsaved: CreditcardRow): ZIO[ZConnection, Throwable, CreditcardRow] = {
    sql"""insert into sales.creditcard("creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate")
          values (${Segment.paramSegment(unsaved.creditcardid)(/* user-picked */ CustomCreditcardId.setter)}::int4, ${Segment.paramSegment(unsaved.cardtype)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.cardnumber)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.expmonth)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.expyear)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate"::text
       """.insertReturning(using CreditcardRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: CreditcardRowUnsaved): ZIO[ZConnection, Throwable, CreditcardRow] = {
    val fs = List(
      Some((sql""""cardtype"""", sql"${Segment.paramSegment(unsaved.cardtype)(Setter.stringSetter)}")),
      Some((sql""""cardnumber"""", sql"${Segment.paramSegment(unsaved.cardnumber)(Setter.stringSetter)}")),
      Some((sql""""expmonth"""", sql"${Segment.paramSegment(unsaved.expmonth)(TypoShort.setter)}::int2")),
      Some((sql""""expyear"""", sql"${Segment.paramSegment(unsaved.expyear)(TypoShort.setter)}::int2")),
      unsaved.creditcardid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""creditcardid"""", sql"${Segment.paramSegment(value: /* user-picked */ CustomCreditcardId)(/* user-picked */ CustomCreditcardId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.creditcard default values
            returning "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.creditcard($names) values ($values) returning "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate"::text"""
    }
    q.insertReturning(using CreditcardRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CreditcardRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.creditcard("creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate") FROM STDIN""", batchSize, unsaved)(CreditcardRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CreditcardRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.creditcard("cardtype", "cardnumber", "expmonth", "expyear", "creditcardid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(CreditcardRowUnsaved.text)
  }
  override def select: SelectBuilder[CreditcardFields, CreditcardRow] = {
    SelectBuilderSql("sales.creditcard", CreditcardFields.structure, CreditcardRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CreditcardRow] = {
    sql"""select "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate"::text from sales.creditcard""".query(using CreditcardRow.jdbcDecoder).selectStream()
  }
  override def selectById(creditcardid: /* user-picked */ CustomCreditcardId): ZIO[ZConnection, Throwable, Option[CreditcardRow]] = {
    sql"""select "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate"::text from sales.creditcard where "creditcardid" = ${Segment.paramSegment(creditcardid)(/* user-picked */ CustomCreditcardId.setter)}""".query(using CreditcardRow.jdbcDecoder).selectOne
  }
  override def selectByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZStream[ZConnection, Throwable, CreditcardRow] = {
    sql"""select "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate"::text from sales.creditcard where "creditcardid" = ANY(${Segment.paramSegment(creditcardids)(CustomCreditcardId.arraySetter)})""".query(using CreditcardRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZIO[ZConnection, Throwable, Map[/* user-picked */ CustomCreditcardId, CreditcardRow]] = {
    selectByIds(creditcardids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.creditcardid, x)).toMap
      creditcardids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[CreditcardFields, CreditcardRow] = {
    UpdateBuilder("sales.creditcard", CreditcardFields.structure, CreditcardRow.jdbcDecoder)
  }
  override def update(row: CreditcardRow): ZIO[ZConnection, Throwable, Boolean] = {
    val creditcardid = row.creditcardid
    sql"""update sales.creditcard
          set "cardtype" = ${Segment.paramSegment(row.cardtype)(Setter.stringSetter)},
              "cardnumber" = ${Segment.paramSegment(row.cardnumber)(Setter.stringSetter)},
              "expmonth" = ${Segment.paramSegment(row.expmonth)(TypoShort.setter)}::int2,
              "expyear" = ${Segment.paramSegment(row.expyear)(TypoShort.setter)}::int2,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "creditcardid" = ${Segment.paramSegment(creditcardid)(/* user-picked */ CustomCreditcardId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: CreditcardRow): ZIO[ZConnection, Throwable, UpdateResult[CreditcardRow]] = {
    sql"""insert into sales.creditcard("creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.creditcardid)(/* user-picked */ CustomCreditcardId.setter)}::int4,
            ${Segment.paramSegment(unsaved.cardtype)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.cardnumber)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.expmonth)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.expyear)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("creditcardid")
          do update set
            "cardtype" = EXCLUDED."cardtype",
            "cardnumber" = EXCLUDED."cardnumber",
            "expmonth" = EXCLUDED."expmonth",
            "expyear" = EXCLUDED."expyear",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate"::text""".insertReturning(using CreditcardRow.jdbcDecoder)
  }
}
