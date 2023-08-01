/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_range

import adventureworks.TypoRegproc
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgRangeRepoImpl extends PgRangeRepo {
  override def delete(rngtypid: PgRangeId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_range where rngtypid = ${fromWrite(rngtypid)(Write.fromPut(PgRangeId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgRangeFields, PgRangeRow] = {
    DeleteBuilder("pg_catalog.pg_range", PgRangeFields)
  }
  override def insert(unsaved: PgRangeRow): ConnectionIO[PgRangeRow] = {
    sql"""insert into pg_catalog.pg_range(rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff)
          values (${fromWrite(unsaved.rngtypid)(Write.fromPut(PgRangeId.put))}::oid, ${fromWrite(unsaved.rngsubtype)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.rngmultitypid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.rngcollation)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.rngsubopc)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.rngcanonical)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.rngsubdiff)(Write.fromPut(TypoRegproc.put))}::regproc)
          returning rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff
       """.query(PgRangeRow.read).unique
  }
  override def select: SelectBuilder[PgRangeFields, PgRangeRow] = {
    SelectBuilderSql("pg_catalog.pg_range", PgRangeFields, PgRangeRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgRangeRow] = {
    sql"select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff from pg_catalog.pg_range".query(PgRangeRow.read).stream
  }
  override def selectById(rngtypid: PgRangeId): ConnectionIO[Option[PgRangeRow]] = {
    sql"select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff from pg_catalog.pg_range where rngtypid = ${fromWrite(rngtypid)(Write.fromPut(PgRangeId.put))}".query(PgRangeRow.read).option
  }
  override def selectByIds(rngtypids: Array[PgRangeId]): Stream[ConnectionIO, PgRangeRow] = {
    sql"select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff from pg_catalog.pg_range where rngtypid = ANY(${fromWrite(rngtypids)(Write.fromPut(PgRangeId.arrayPut))})".query(PgRangeRow.read).stream
  }
  override def update(row: PgRangeRow): ConnectionIO[Boolean] = {
    val rngtypid = row.rngtypid
    sql"""update pg_catalog.pg_range
          set rngsubtype = ${fromWrite(row.rngsubtype)(Write.fromPut(Meta.LongMeta.put))}::oid,
              rngmultitypid = ${fromWrite(row.rngmultitypid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              rngcollation = ${fromWrite(row.rngcollation)(Write.fromPut(Meta.LongMeta.put))}::oid,
              rngsubopc = ${fromWrite(row.rngsubopc)(Write.fromPut(Meta.LongMeta.put))}::oid,
              rngcanonical = ${fromWrite(row.rngcanonical)(Write.fromPut(TypoRegproc.put))}::regproc,
              rngsubdiff = ${fromWrite(row.rngsubdiff)(Write.fromPut(TypoRegproc.put))}::regproc
          where rngtypid = ${fromWrite(rngtypid)(Write.fromPut(PgRangeId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgRangeFields, PgRangeRow] = {
    UpdateBuilder("pg_catalog.pg_range", PgRangeFields, PgRangeRow.read)
  }
  override def upsert(unsaved: PgRangeRow): ConnectionIO[PgRangeRow] = {
    sql"""insert into pg_catalog.pg_range(rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff)
          values (
            ${fromWrite(unsaved.rngtypid)(Write.fromPut(PgRangeId.put))}::oid,
            ${fromWrite(unsaved.rngsubtype)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.rngmultitypid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.rngcollation)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.rngsubopc)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.rngcanonical)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.rngsubdiff)(Write.fromPut(TypoRegproc.put))}::regproc
          )
          on conflict (rngtypid)
          do update set
            rngsubtype = EXCLUDED.rngsubtype,
            rngmultitypid = EXCLUDED.rngmultitypid,
            rngcollation = EXCLUDED.rngcollation,
            rngsubopc = EXCLUDED.rngsubopc,
            rngcanonical = EXCLUDED.rngcanonical,
            rngsubdiff = EXCLUDED.rngsubdiff
          returning rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff
       """.query(PgRangeRow.read).unique
  }
}
