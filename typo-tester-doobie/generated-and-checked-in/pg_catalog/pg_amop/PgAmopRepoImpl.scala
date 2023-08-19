/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amop

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

object PgAmopRepoImpl extends PgAmopRepo {
  override def delete(oid: PgAmopId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_amop where oid = ${fromWrite(oid)(Write.fromPut(PgAmopId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgAmopFields, PgAmopRow] = {
    DeleteBuilder("pg_catalog.pg_amop", PgAmopFields)
  }
  override def insert(unsaved: PgAmopRow): ConnectionIO[PgAmopRow] = {
    sql"""insert into pg_catalog.pg_amop(oid, amopfamily, amoplefttype, amoprighttype, amopstrategy, amoppurpose, amopopr, amopmethod, amopsortfamily)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgAmopId.put))}::oid, ${fromWrite(unsaved.amopfamily)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.amoplefttype)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.amoprighttype)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.amopstrategy)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.amoppurpose)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.amopopr)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.amopmethod)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.amopsortfamily)(Write.fromPut(Meta.LongMeta.put))}::oid)
          returning oid, amopfamily, amoplefttype, amoprighttype, amopstrategy, amoppurpose, amopopr, amopmethod, amopsortfamily
       """.query(PgAmopRow.read).unique
  }
  override def select: SelectBuilder[PgAmopFields, PgAmopRow] = {
    SelectBuilderSql("pg_catalog.pg_amop", PgAmopFields, PgAmopRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgAmopRow] = {
    sql"select oid, amopfamily, amoplefttype, amoprighttype, amopstrategy, amoppurpose, amopopr, amopmethod, amopsortfamily from pg_catalog.pg_amop".query(PgAmopRow.read).stream
  }
  override def selectById(oid: PgAmopId): ConnectionIO[Option[PgAmopRow]] = {
    sql"select oid, amopfamily, amoplefttype, amoprighttype, amopstrategy, amoppurpose, amopopr, amopmethod, amopsortfamily from pg_catalog.pg_amop where oid = ${fromWrite(oid)(Write.fromPut(PgAmopId.put))}".query(PgAmopRow.read).option
  }
  override def selectByIds(oids: Array[PgAmopId]): Stream[ConnectionIO, PgAmopRow] = {
    sql"select oid, amopfamily, amoplefttype, amoprighttype, amopstrategy, amoppurpose, amopopr, amopmethod, amopsortfamily from pg_catalog.pg_amop where oid = ANY(${oids})".query(PgAmopRow.read).stream
  }
  override def update(row: PgAmopRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_amop
          set amopfamily = ${fromWrite(row.amopfamily)(Write.fromPut(Meta.LongMeta.put))}::oid,
              amoplefttype = ${fromWrite(row.amoplefttype)(Write.fromPut(Meta.LongMeta.put))}::oid,
              amoprighttype = ${fromWrite(row.amoprighttype)(Write.fromPut(Meta.LongMeta.put))}::oid,
              amopstrategy = ${fromWrite(row.amopstrategy)(Write.fromPut(Meta.IntMeta.put))}::int2,
              amoppurpose = ${fromWrite(row.amoppurpose)(Write.fromPut(Meta.StringMeta.put))}::char,
              amopopr = ${fromWrite(row.amopopr)(Write.fromPut(Meta.LongMeta.put))}::oid,
              amopmethod = ${fromWrite(row.amopmethod)(Write.fromPut(Meta.LongMeta.put))}::oid,
              amopsortfamily = ${fromWrite(row.amopsortfamily)(Write.fromPut(Meta.LongMeta.put))}::oid
          where oid = ${fromWrite(oid)(Write.fromPut(PgAmopId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgAmopFields, PgAmopRow] = {
    UpdateBuilder("pg_catalog.pg_amop", PgAmopFields, PgAmopRow.read)
  }
  override def upsert(unsaved: PgAmopRow): ConnectionIO[PgAmopRow] = {
    sql"""insert into pg_catalog.pg_amop(oid, amopfamily, amoplefttype, amoprighttype, amopstrategy, amoppurpose, amopopr, amopmethod, amopsortfamily)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgAmopId.put))}::oid,
            ${fromWrite(unsaved.amopfamily)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.amoplefttype)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.amoprighttype)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.amopstrategy)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.amoppurpose)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.amopopr)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.amopmethod)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.amopsortfamily)(Write.fromPut(Meta.LongMeta.put))}::oid
          )
          on conflict (oid)
          do update set
            amopfamily = EXCLUDED.amopfamily,
            amoplefttype = EXCLUDED.amoplefttype,
            amoprighttype = EXCLUDED.amoprighttype,
            amopstrategy = EXCLUDED.amopstrategy,
            amoppurpose = EXCLUDED.amoppurpose,
            amopopr = EXCLUDED.amopopr,
            amopmethod = EXCLUDED.amopmethod,
            amopsortfamily = EXCLUDED.amopsortfamily
          returning oid, amopfamily, amoplefttype, amoprighttype, amopstrategy, amoppurpose, amopopr, amopmethod, amopsortfamily
       """.query(PgAmopRow.read).unique
  }
}
