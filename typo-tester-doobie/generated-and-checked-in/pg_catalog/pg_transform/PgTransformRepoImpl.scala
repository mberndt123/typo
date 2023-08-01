/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_transform

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

object PgTransformRepoImpl extends PgTransformRepo {
  override def delete(oid: PgTransformId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_transform where oid = ${fromWrite(oid)(Write.fromPut(PgTransformId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgTransformFields, PgTransformRow] = {
    DeleteBuilder("pg_catalog.pg_transform", PgTransformFields)
  }
  override def insert(unsaved: PgTransformRow): ConnectionIO[PgTransformRow] = {
    sql"""insert into pg_catalog.pg_transform(oid, trftype, trflang, trffromsql, trftosql)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgTransformId.put))}::oid, ${fromWrite(unsaved.trftype)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.trflang)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.trffromsql)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.trftosql)(Write.fromPut(TypoRegproc.put))}::regproc)
          returning oid, trftype, trflang, trffromsql, trftosql
       """.query(PgTransformRow.read).unique
  }
  override def select: SelectBuilder[PgTransformFields, PgTransformRow] = {
    SelectBuilderSql("pg_catalog.pg_transform", PgTransformFields, PgTransformRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgTransformRow] = {
    sql"select oid, trftype, trflang, trffromsql, trftosql from pg_catalog.pg_transform".query(PgTransformRow.read).stream
  }
  override def selectById(oid: PgTransformId): ConnectionIO[Option[PgTransformRow]] = {
    sql"select oid, trftype, trflang, trffromsql, trftosql from pg_catalog.pg_transform where oid = ${fromWrite(oid)(Write.fromPut(PgTransformId.put))}".query(PgTransformRow.read).option
  }
  override def selectByIds(oids: Array[PgTransformId]): Stream[ConnectionIO, PgTransformRow] = {
    sql"select oid, trftype, trflang, trffromsql, trftosql from pg_catalog.pg_transform where oid = ANY(${fromWrite(oids)(Write.fromPut(PgTransformId.arrayPut))})".query(PgTransformRow.read).stream
  }
  override def update(row: PgTransformRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_transform
          set trftype = ${fromWrite(row.trftype)(Write.fromPut(Meta.LongMeta.put))}::oid,
              trflang = ${fromWrite(row.trflang)(Write.fromPut(Meta.LongMeta.put))}::oid,
              trffromsql = ${fromWrite(row.trffromsql)(Write.fromPut(TypoRegproc.put))}::regproc,
              trftosql = ${fromWrite(row.trftosql)(Write.fromPut(TypoRegproc.put))}::regproc
          where oid = ${fromWrite(oid)(Write.fromPut(PgTransformId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgTransformFields, PgTransformRow] = {
    UpdateBuilder("pg_catalog.pg_transform", PgTransformFields, PgTransformRow.read)
  }
  override def upsert(unsaved: PgTransformRow): ConnectionIO[PgTransformRow] = {
    sql"""insert into pg_catalog.pg_transform(oid, trftype, trflang, trffromsql, trftosql)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgTransformId.put))}::oid,
            ${fromWrite(unsaved.trftype)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.trflang)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.trffromsql)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.trftosql)(Write.fromPut(TypoRegproc.put))}::regproc
          )
          on conflict (oid)
          do update set
            trftype = EXCLUDED.trftype,
            trflang = EXCLUDED.trflang,
            trffromsql = EXCLUDED.trffromsql,
            trftosql = EXCLUDED.trftosql
          returning oid, trftype, trflang, trffromsql, trftosql
       """.query(PgTransformRow.read).unique
  }
}
