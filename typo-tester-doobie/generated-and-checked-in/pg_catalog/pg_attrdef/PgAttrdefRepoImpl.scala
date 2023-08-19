/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attrdef

import adventureworks.TypoPgNodeTree
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

object PgAttrdefRepoImpl extends PgAttrdefRepo {
  override def delete(oid: PgAttrdefId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_attrdef where oid = ${fromWrite(oid)(Write.fromPut(PgAttrdefId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgAttrdefFields, PgAttrdefRow] = {
    DeleteBuilder("pg_catalog.pg_attrdef", PgAttrdefFields)
  }
  override def insert(unsaved: PgAttrdefRow): ConnectionIO[PgAttrdefRow] = {
    sql"""insert into pg_catalog.pg_attrdef(oid, adrelid, adnum, adbin)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgAttrdefId.put))}::oid, ${fromWrite(unsaved.adrelid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.adnum)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.adbin)(Write.fromPut(TypoPgNodeTree.put))}::pg_node_tree)
          returning oid, adrelid, adnum, adbin
       """.query(PgAttrdefRow.read).unique
  }
  override def select: SelectBuilder[PgAttrdefFields, PgAttrdefRow] = {
    SelectBuilderSql("pg_catalog.pg_attrdef", PgAttrdefFields, PgAttrdefRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgAttrdefRow] = {
    sql"select oid, adrelid, adnum, adbin from pg_catalog.pg_attrdef".query(PgAttrdefRow.read).stream
  }
  override def selectById(oid: PgAttrdefId): ConnectionIO[Option[PgAttrdefRow]] = {
    sql"select oid, adrelid, adnum, adbin from pg_catalog.pg_attrdef where oid = ${fromWrite(oid)(Write.fromPut(PgAttrdefId.put))}".query(PgAttrdefRow.read).option
  }
  override def selectByIds(oids: Array[PgAttrdefId]): Stream[ConnectionIO, PgAttrdefRow] = {
    sql"select oid, adrelid, adnum, adbin from pg_catalog.pg_attrdef where oid = ANY(${oids})".query(PgAttrdefRow.read).stream
  }
  override def update(row: PgAttrdefRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_attrdef
          set adrelid = ${fromWrite(row.adrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              adnum = ${fromWrite(row.adnum)(Write.fromPut(Meta.IntMeta.put))}::int2,
              adbin = ${fromWrite(row.adbin)(Write.fromPut(TypoPgNodeTree.put))}::pg_node_tree
          where oid = ${fromWrite(oid)(Write.fromPut(PgAttrdefId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgAttrdefFields, PgAttrdefRow] = {
    UpdateBuilder("pg_catalog.pg_attrdef", PgAttrdefFields, PgAttrdefRow.read)
  }
  override def upsert(unsaved: PgAttrdefRow): ConnectionIO[PgAttrdefRow] = {
    sql"""insert into pg_catalog.pg_attrdef(oid, adrelid, adnum, adbin)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgAttrdefId.put))}::oid,
            ${fromWrite(unsaved.adrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.adnum)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.adbin)(Write.fromPut(TypoPgNodeTree.put))}::pg_node_tree
          )
          on conflict (oid)
          do update set
            adrelid = EXCLUDED.adrelid,
            adnum = EXCLUDED.adnum,
            adbin = EXCLUDED.adbin
          returning oid, adrelid, adnum, adbin
       """.query(PgAttrdefRow.read).unique
  }
}
