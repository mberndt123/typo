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
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object CreditcardRepoImpl extends CreditcardRepo {
  override def delete(creditcardid: CreditcardId): ConnectionIO[Boolean] = {
    sql"delete from sales.creditcard where creditcardid = ${fromWrite(creditcardid)(Write.fromPut(CreditcardId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[CreditcardFields, CreditcardRow] = {
    DeleteBuilder("sales.creditcard", CreditcardFields)
  }
  override def insert(unsaved: CreditcardRow): ConnectionIO[CreditcardRow] = {
    sql"""insert into sales.creditcard(creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate)
          values (${fromWrite(unsaved.creditcardid)(Write.fromPut(CreditcardId.put))}::int4, ${fromWrite(unsaved.cardtype)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.cardnumber)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.expmonth)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.expyear)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
       """.query(CreditcardRow.read).unique
  }
  override def insert(unsaved: CreditcardRowUnsaved): ConnectionIO[CreditcardRow] = {
    val fs = List(
      Some((Fragment.const(s"cardtype"), fr"${fromWrite(unsaved.cardtype)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"cardnumber"), fr"${fromWrite(unsaved.cardnumber)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"expmonth"), fr"${fromWrite(unsaved.expmonth)(Write.fromPut(Meta.IntMeta.put))}::int2")),
      Some((Fragment.const(s"expyear"), fr"${fromWrite(unsaved.expyear)(Write.fromPut(Meta.IntMeta.put))}::int2")),
      unsaved.creditcardid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"creditcardid"), fr"${fromWrite(value: CreditcardId)(Write.fromPut(CreditcardId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.creditcard default values
            returning creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.creditcard(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
         """
    }
    q.query(CreditcardRow.read).unique
    
  }
  override def select: SelectBuilder[CreditcardFields, CreditcardRow] = {
    SelectBuilderSql("sales.creditcard", CreditcardFields, CreditcardRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CreditcardRow] = {
    sql"select creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text from sales.creditcard".query(CreditcardRow.read).stream
  }
  override def selectById(creditcardid: CreditcardId): ConnectionIO[Option[CreditcardRow]] = {
    sql"select creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text from sales.creditcard where creditcardid = ${fromWrite(creditcardid)(Write.fromPut(CreditcardId.put))}".query(CreditcardRow.read).option
  }
  override def selectByIds(creditcardids: Array[CreditcardId]): Stream[ConnectionIO, CreditcardRow] = {
    sql"select creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text from sales.creditcard where creditcardid = ANY(${creditcardids})".query(CreditcardRow.read).stream
  }
  override def update(row: CreditcardRow): ConnectionIO[Boolean] = {
    val creditcardid = row.creditcardid
    sql"""update sales.creditcard
          set cardtype = ${fromWrite(row.cardtype)(Write.fromPut(Meta.StringMeta.put))},
              cardnumber = ${fromWrite(row.cardnumber)(Write.fromPut(Meta.StringMeta.put))},
              expmonth = ${fromWrite(row.expmonth)(Write.fromPut(Meta.IntMeta.put))}::int2,
              expyear = ${fromWrite(row.expyear)(Write.fromPut(Meta.IntMeta.put))}::int2,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where creditcardid = ${fromWrite(creditcardid)(Write.fromPut(CreditcardId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[CreditcardFields, CreditcardRow] = {
    UpdateBuilder("sales.creditcard", CreditcardFields, CreditcardRow.read)
  }
  override def upsert(unsaved: CreditcardRow): ConnectionIO[CreditcardRow] = {
    sql"""insert into sales.creditcard(creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate)
          values (
            ${fromWrite(unsaved.creditcardid)(Write.fromPut(CreditcardId.put))}::int4,
            ${fromWrite(unsaved.cardtype)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.cardnumber)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.expmonth)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.expyear)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (creditcardid)
          do update set
            cardtype = EXCLUDED.cardtype,
            cardnumber = EXCLUDED.cardnumber,
            expmonth = EXCLUDED.expmonth,
            expyear = EXCLUDED.expyear,
            modifieddate = EXCLUDED.modifieddate
          returning creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate::text
       """.query(CreditcardRow.read).unique
  }
}
