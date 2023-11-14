/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ScrapreasonRepoImpl extends ScrapreasonRepo {
  override def delete(scrapreasonid: ScrapreasonId): ConnectionIO[Boolean] = {
    sql"""delete from production.scrapreason where "scrapreasonid" = ${fromWrite(scrapreasonid)(Write.fromPut(ScrapreasonId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ScrapreasonFields, ScrapreasonRow] = {
    DeleteBuilder("production.scrapreason", ScrapreasonFields)
  }
  override def insert(unsaved: ScrapreasonRow): ConnectionIO[ScrapreasonRow] = {
    sql"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
          values (${fromWrite(unsaved.scrapreasonid)(Write.fromPut(ScrapreasonId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "scrapreasonid", "name", "modifieddate"::text
       """.query(ScrapreasonRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ScrapreasonRow], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY production.scrapreason("scrapreasonid", "name", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(ScrapreasonRow.text)
  }
  override def insert(unsaved: ScrapreasonRowUnsaved): ConnectionIO[ScrapreasonRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.scrapreasonid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""scrapreasonid""""), fr"${fromWrite(value: ScrapreasonId)(Write.fromPut(ScrapreasonId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.scrapreason default values
            returning "scrapreasonid", "name", "modifieddate"::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.scrapreason(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning "scrapreasonid", "name", "modifieddate"::text
         """
    }
    q.query(ScrapreasonRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ScrapreasonRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY production.scrapreason("name", "scrapreasonid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(ScrapreasonRowUnsaved.text)
  }
  override def select: SelectBuilder[ScrapreasonFields, ScrapreasonRow] = {
    SelectBuilderSql("production.scrapreason", ScrapreasonFields, ScrapreasonRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ScrapreasonRow] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason""".query(ScrapreasonRow.read).stream
  }
  override def selectById(scrapreasonid: ScrapreasonId): ConnectionIO[Option[ScrapreasonRow]] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason where "scrapreasonid" = ${fromWrite(scrapreasonid)(Write.fromPut(ScrapreasonId.put))}""".query(ScrapreasonRow.read).option
  }
  override def selectByIds(scrapreasonids: Array[ScrapreasonId]): Stream[ConnectionIO, ScrapreasonRow] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason where "scrapreasonid" = ANY(${scrapreasonids})""".query(ScrapreasonRow.read).stream
  }
  override def update(row: ScrapreasonRow): ConnectionIO[Boolean] = {
    val scrapreasonid = row.scrapreasonid
    sql"""update production.scrapreason
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "scrapreasonid" = ${fromWrite(scrapreasonid)(Write.fromPut(ScrapreasonId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ScrapreasonFields, ScrapreasonRow] = {
    UpdateBuilder("production.scrapreason", ScrapreasonFields, ScrapreasonRow.read)
  }
  override def upsert(unsaved: ScrapreasonRow): ConnectionIO[ScrapreasonRow] = {
    sql"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
          values (
            ${fromWrite(unsaved.scrapreasonid)(Write.fromPut(ScrapreasonId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("scrapreasonid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "scrapreasonid", "name", "modifieddate"::text
       """.query(ScrapreasonRow.read).unique
  }
}
