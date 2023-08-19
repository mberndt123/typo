/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_class

import adventureworks.TypoAclItem
import adventureworks.TypoPgNodeTree
import adventureworks.TypoXid
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

object PgClassRepoImpl extends PgClassRepo {
  override def delete(oid: PgClassId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_class where oid = ${fromWrite(oid)(Write.fromPut(PgClassId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgClassFields, PgClassRow] = {
    DeleteBuilder("pg_catalog.pg_class", PgClassFields)
  }
  override def insert(unsaved: PgClassRow): ConnectionIO[PgClassRow] = {
    sql"""insert into pg_catalog.pg_class(oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgClassId.put))}::oid, ${fromWrite(unsaved.relname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.relnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.reltype)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.reloftype)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.relowner)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.relam)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.relfilenode)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.reltablespace)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.relpages)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.reltuples)(Write.fromPut(Meta.FloatMeta.put))}::float4, ${fromWrite(unsaved.relallvisible)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.reltoastrelid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.relhasindex)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.relisshared)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.relpersistence)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.relkind)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.relnatts)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.relchecks)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.relhasrules)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.relhastriggers)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.relhassubclass)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.relrowsecurity)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.relforcerowsecurity)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.relispopulated)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.relreplident)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.relispartition)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.relrewrite)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.relfrozenxid)(Write.fromPut(TypoXid.put))}::xid, ${fromWrite(unsaved.relminmxid)(Write.fromPut(TypoXid.put))}::xid, ${fromWrite(unsaved.relacl)(Write.fromPutOption(TypoAclItem.arrayPut))}::_aclitem, ${fromWrite(unsaved.reloptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text, ${fromWrite(unsaved.relpartbound)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree)
          returning oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound
       """.query(PgClassRow.read).unique
  }
  override def select: SelectBuilder[PgClassFields, PgClassRow] = {
    SelectBuilderSql("pg_catalog.pg_class", PgClassFields, PgClassRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgClassRow] = {
    sql"select oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound from pg_catalog.pg_class".query(PgClassRow.read).stream
  }
  override def selectById(oid: PgClassId): ConnectionIO[Option[PgClassRow]] = {
    sql"select oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound from pg_catalog.pg_class where oid = ${fromWrite(oid)(Write.fromPut(PgClassId.put))}".query(PgClassRow.read).option
  }
  override def selectByIds(oids: Array[PgClassId]): Stream[ConnectionIO, PgClassRow] = {
    sql"select oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound from pg_catalog.pg_class where oid = ANY(${oids})".query(PgClassRow.read).stream
  }
  override def update(row: PgClassRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_class
          set relname = ${fromWrite(row.relname)(Write.fromPut(Meta.StringMeta.put))}::name,
              relnamespace = ${fromWrite(row.relnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
              reltype = ${fromWrite(row.reltype)(Write.fromPut(Meta.LongMeta.put))}::oid,
              reloftype = ${fromWrite(row.reloftype)(Write.fromPut(Meta.LongMeta.put))}::oid,
              relowner = ${fromWrite(row.relowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
              relam = ${fromWrite(row.relam)(Write.fromPut(Meta.LongMeta.put))}::oid,
              relfilenode = ${fromWrite(row.relfilenode)(Write.fromPut(Meta.LongMeta.put))}::oid,
              reltablespace = ${fromWrite(row.reltablespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
              relpages = ${fromWrite(row.relpages)(Write.fromPut(Meta.IntMeta.put))}::int4,
              reltuples = ${fromWrite(row.reltuples)(Write.fromPut(Meta.FloatMeta.put))}::float4,
              relallvisible = ${fromWrite(row.relallvisible)(Write.fromPut(Meta.IntMeta.put))}::int4,
              reltoastrelid = ${fromWrite(row.reltoastrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              relhasindex = ${fromWrite(row.relhasindex)(Write.fromPut(Meta.BooleanMeta.put))},
              relisshared = ${fromWrite(row.relisshared)(Write.fromPut(Meta.BooleanMeta.put))},
              relpersistence = ${fromWrite(row.relpersistence)(Write.fromPut(Meta.StringMeta.put))}::char,
              relkind = ${fromWrite(row.relkind)(Write.fromPut(Meta.StringMeta.put))}::char,
              relnatts = ${fromWrite(row.relnatts)(Write.fromPut(Meta.IntMeta.put))}::int2,
              relchecks = ${fromWrite(row.relchecks)(Write.fromPut(Meta.IntMeta.put))}::int2,
              relhasrules = ${fromWrite(row.relhasrules)(Write.fromPut(Meta.BooleanMeta.put))},
              relhastriggers = ${fromWrite(row.relhastriggers)(Write.fromPut(Meta.BooleanMeta.put))},
              relhassubclass = ${fromWrite(row.relhassubclass)(Write.fromPut(Meta.BooleanMeta.put))},
              relrowsecurity = ${fromWrite(row.relrowsecurity)(Write.fromPut(Meta.BooleanMeta.put))},
              relforcerowsecurity = ${fromWrite(row.relforcerowsecurity)(Write.fromPut(Meta.BooleanMeta.put))},
              relispopulated = ${fromWrite(row.relispopulated)(Write.fromPut(Meta.BooleanMeta.put))},
              relreplident = ${fromWrite(row.relreplident)(Write.fromPut(Meta.StringMeta.put))}::char,
              relispartition = ${fromWrite(row.relispartition)(Write.fromPut(Meta.BooleanMeta.put))},
              relrewrite = ${fromWrite(row.relrewrite)(Write.fromPut(Meta.LongMeta.put))}::oid,
              relfrozenxid = ${fromWrite(row.relfrozenxid)(Write.fromPut(TypoXid.put))}::xid,
              relminmxid = ${fromWrite(row.relminmxid)(Write.fromPut(TypoXid.put))}::xid,
              relacl = ${fromWrite(row.relacl)(Write.fromPutOption(TypoAclItem.arrayPut))}::_aclitem,
              reloptions = ${fromWrite(row.reloptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text,
              relpartbound = ${fromWrite(row.relpartbound)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          where oid = ${fromWrite(oid)(Write.fromPut(PgClassId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgClassFields, PgClassRow] = {
    UpdateBuilder("pg_catalog.pg_class", PgClassFields, PgClassRow.read)
  }
  override def upsert(unsaved: PgClassRow): ConnectionIO[PgClassRow] = {
    sql"""insert into pg_catalog.pg_class(oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgClassId.put))}::oid,
            ${fromWrite(unsaved.relname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.relnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.reltype)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.reloftype)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.relowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.relam)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.relfilenode)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.reltablespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.relpages)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.reltuples)(Write.fromPut(Meta.FloatMeta.put))}::float4,
            ${fromWrite(unsaved.relallvisible)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.reltoastrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.relhasindex)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.relisshared)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.relpersistence)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.relkind)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.relnatts)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.relchecks)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.relhasrules)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.relhastriggers)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.relhassubclass)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.relrowsecurity)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.relforcerowsecurity)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.relispopulated)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.relreplident)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.relispartition)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.relrewrite)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.relfrozenxid)(Write.fromPut(TypoXid.put))}::xid,
            ${fromWrite(unsaved.relminmxid)(Write.fromPut(TypoXid.put))}::xid,
            ${fromWrite(unsaved.relacl)(Write.fromPutOption(TypoAclItem.arrayPut))}::_aclitem,
            ${fromWrite(unsaved.reloptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text,
            ${fromWrite(unsaved.relpartbound)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          )
          on conflict (oid)
          do update set
            relname = EXCLUDED.relname,
            relnamespace = EXCLUDED.relnamespace,
            reltype = EXCLUDED.reltype,
            reloftype = EXCLUDED.reloftype,
            relowner = EXCLUDED.relowner,
            relam = EXCLUDED.relam,
            relfilenode = EXCLUDED.relfilenode,
            reltablespace = EXCLUDED.reltablespace,
            relpages = EXCLUDED.relpages,
            reltuples = EXCLUDED.reltuples,
            relallvisible = EXCLUDED.relallvisible,
            reltoastrelid = EXCLUDED.reltoastrelid,
            relhasindex = EXCLUDED.relhasindex,
            relisshared = EXCLUDED.relisshared,
            relpersistence = EXCLUDED.relpersistence,
            relkind = EXCLUDED.relkind,
            relnatts = EXCLUDED.relnatts,
            relchecks = EXCLUDED.relchecks,
            relhasrules = EXCLUDED.relhasrules,
            relhastriggers = EXCLUDED.relhastriggers,
            relhassubclass = EXCLUDED.relhassubclass,
            relrowsecurity = EXCLUDED.relrowsecurity,
            relforcerowsecurity = EXCLUDED.relforcerowsecurity,
            relispopulated = EXCLUDED.relispopulated,
            relreplident = EXCLUDED.relreplident,
            relispartition = EXCLUDED.relispartition,
            relrewrite = EXCLUDED.relrewrite,
            relfrozenxid = EXCLUDED.relfrozenxid,
            relminmxid = EXCLUDED.relminmxid,
            relacl = EXCLUDED.relacl,
            reloptions = EXCLUDED.reloptions,
            relpartbound = EXCLUDED.relpartbound
          returning oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound
       """.query(PgClassRow.read).unique
  }
}
