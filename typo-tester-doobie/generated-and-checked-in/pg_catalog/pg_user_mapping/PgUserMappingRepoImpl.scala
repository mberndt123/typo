/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user_mapping

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

object PgUserMappingRepoImpl extends PgUserMappingRepo {
  override def delete(oid: PgUserMappingId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_user_mapping where oid = ${fromWrite(oid)(Write.fromPut(PgUserMappingId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgUserMappingFields, PgUserMappingRow] = {
    DeleteBuilder("pg_catalog.pg_user_mapping", PgUserMappingFields)
  }
  override def insert(unsaved: PgUserMappingRow): ConnectionIO[PgUserMappingRow] = {
    sql"""insert into pg_catalog.pg_user_mapping(oid, umuser, umserver, umoptions)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgUserMappingId.put))}::oid, ${fromWrite(unsaved.umuser)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.umserver)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.umoptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text)
          returning oid, umuser, umserver, umoptions
       """.query(PgUserMappingRow.read).unique
  }
  override def select: SelectBuilder[PgUserMappingFields, PgUserMappingRow] = {
    SelectBuilderSql("pg_catalog.pg_user_mapping", PgUserMappingFields, PgUserMappingRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgUserMappingRow] = {
    sql"select oid, umuser, umserver, umoptions from pg_catalog.pg_user_mapping".query(PgUserMappingRow.read).stream
  }
  override def selectById(oid: PgUserMappingId): ConnectionIO[Option[PgUserMappingRow]] = {
    sql"select oid, umuser, umserver, umoptions from pg_catalog.pg_user_mapping where oid = ${fromWrite(oid)(Write.fromPut(PgUserMappingId.put))}".query(PgUserMappingRow.read).option
  }
  override def selectByIds(oids: Array[PgUserMappingId]): Stream[ConnectionIO, PgUserMappingRow] = {
    sql"select oid, umuser, umserver, umoptions from pg_catalog.pg_user_mapping where oid = ANY(${fromWrite(oids)(Write.fromPut(PgUserMappingId.arrayPut))})".query(PgUserMappingRow.read).stream
  }
  override def update(row: PgUserMappingRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_user_mapping
          set umuser = ${fromWrite(row.umuser)(Write.fromPut(Meta.LongMeta.put))}::oid,
              umserver = ${fromWrite(row.umserver)(Write.fromPut(Meta.LongMeta.put))}::oid,
              umoptions = ${fromWrite(row.umoptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text
          where oid = ${fromWrite(oid)(Write.fromPut(PgUserMappingId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgUserMappingFields, PgUserMappingRow] = {
    UpdateBuilder("pg_catalog.pg_user_mapping", PgUserMappingFields, PgUserMappingRow.read)
  }
  override def upsert(unsaved: PgUserMappingRow): ConnectionIO[PgUserMappingRow] = {
    sql"""insert into pg_catalog.pg_user_mapping(oid, umuser, umserver, umoptions)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgUserMappingId.put))}::oid,
            ${fromWrite(unsaved.umuser)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.umserver)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.umoptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text
          )
          on conflict (oid)
          do update set
            umuser = EXCLUDED.umuser,
            umserver = EXCLUDED.umserver,
            umoptions = EXCLUDED.umoptions
          returning oid, umuser, umserver, umoptions
       """.query(PgUserMappingRow.read).unique
  }
}
