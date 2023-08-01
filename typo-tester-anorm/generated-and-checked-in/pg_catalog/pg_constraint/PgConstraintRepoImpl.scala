/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_constraint

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgConstraintRepoImpl extends PgConstraintRepo {
  override def delete(oid: PgConstraintId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_constraint where oid = $oid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgConstraintFields, PgConstraintRow] = {
    DeleteBuilder("pg_catalog.pg_constraint", PgConstraintFields)
  }
  override def insert(unsaved: PgConstraintRow)(implicit c: Connection): PgConstraintRow = {
    SQL"""insert into pg_catalog.pg_constraint(oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin)
          values (${unsaved.oid}::oid, ${unsaved.conname}::name, ${unsaved.connamespace}::oid, ${unsaved.contype}::char, ${unsaved.condeferrable}, ${unsaved.condeferred}, ${unsaved.convalidated}, ${unsaved.conrelid}::oid, ${unsaved.contypid}::oid, ${unsaved.conindid}::oid, ${unsaved.conparentid}::oid, ${unsaved.confrelid}::oid, ${unsaved.confupdtype}::char, ${unsaved.confdeltype}::char, ${unsaved.confmatchtype}::char, ${unsaved.conislocal}, ${unsaved.coninhcount}::int4, ${unsaved.connoinherit}, ${unsaved.conkey}::_int2, ${unsaved.confkey}::_int2, ${unsaved.conpfeqop}::_oid, ${unsaved.conppeqop}::_oid, ${unsaved.conffeqop}::_oid, ${unsaved.conexclop}::_oid, ${unsaved.conbin}::pg_node_tree)
          returning oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin
       """
      .executeInsert(PgConstraintRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgConstraintFields, PgConstraintRow] = {
    SelectBuilderSql("pg_catalog.pg_constraint", PgConstraintFields, PgConstraintRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgConstraintRow] = {
    SQL"""select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin
          from pg_catalog.pg_constraint
       """.as(PgConstraintRow.rowParser(1).*)
  }
  override def selectById(oid: PgConstraintId)(implicit c: Connection): Option[PgConstraintRow] = {
    SQL"""select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin
          from pg_catalog.pg_constraint
          where oid = $oid
       """.as(PgConstraintRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgConstraintId])(implicit c: Connection): List[PgConstraintRow] = {
    SQL"""select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin
          from pg_catalog.pg_constraint
          where oid = ANY($oids)
       """.as(PgConstraintRow.rowParser(1).*)
    
  }
  override def update(row: PgConstraintRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_constraint
          set conname = ${row.conname}::name,
              connamespace = ${row.connamespace}::oid,
              contype = ${row.contype}::char,
              condeferrable = ${row.condeferrable},
              condeferred = ${row.condeferred},
              convalidated = ${row.convalidated},
              conrelid = ${row.conrelid}::oid,
              contypid = ${row.contypid}::oid,
              conindid = ${row.conindid}::oid,
              conparentid = ${row.conparentid}::oid,
              confrelid = ${row.confrelid}::oid,
              confupdtype = ${row.confupdtype}::char,
              confdeltype = ${row.confdeltype}::char,
              confmatchtype = ${row.confmatchtype}::char,
              conislocal = ${row.conislocal},
              coninhcount = ${row.coninhcount}::int4,
              connoinherit = ${row.connoinherit},
              conkey = ${row.conkey}::_int2,
              confkey = ${row.confkey}::_int2,
              conpfeqop = ${row.conpfeqop}::_oid,
              conppeqop = ${row.conppeqop}::_oid,
              conffeqop = ${row.conffeqop}::_oid,
              conexclop = ${row.conexclop}::_oid,
              conbin = ${row.conbin}::pg_node_tree
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgConstraintFields, PgConstraintRow] = {
    UpdateBuilder("pg_catalog.pg_constraint", PgConstraintFields, PgConstraintRow.rowParser)
  }
  override def upsert(unsaved: PgConstraintRow)(implicit c: Connection): PgConstraintRow = {
    SQL"""insert into pg_catalog.pg_constraint(oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.conname}::name,
            ${unsaved.connamespace}::oid,
            ${unsaved.contype}::char,
            ${unsaved.condeferrable},
            ${unsaved.condeferred},
            ${unsaved.convalidated},
            ${unsaved.conrelid}::oid,
            ${unsaved.contypid}::oid,
            ${unsaved.conindid}::oid,
            ${unsaved.conparentid}::oid,
            ${unsaved.confrelid}::oid,
            ${unsaved.confupdtype}::char,
            ${unsaved.confdeltype}::char,
            ${unsaved.confmatchtype}::char,
            ${unsaved.conislocal},
            ${unsaved.coninhcount}::int4,
            ${unsaved.connoinherit},
            ${unsaved.conkey}::_int2,
            ${unsaved.confkey}::_int2,
            ${unsaved.conpfeqop}::_oid,
            ${unsaved.conppeqop}::_oid,
            ${unsaved.conffeqop}::_oid,
            ${unsaved.conexclop}::_oid,
            ${unsaved.conbin}::pg_node_tree
          )
          on conflict (oid)
          do update set
            conname = EXCLUDED.conname,
            connamespace = EXCLUDED.connamespace,
            contype = EXCLUDED.contype,
            condeferrable = EXCLUDED.condeferrable,
            condeferred = EXCLUDED.condeferred,
            convalidated = EXCLUDED.convalidated,
            conrelid = EXCLUDED.conrelid,
            contypid = EXCLUDED.contypid,
            conindid = EXCLUDED.conindid,
            conparentid = EXCLUDED.conparentid,
            confrelid = EXCLUDED.confrelid,
            confupdtype = EXCLUDED.confupdtype,
            confdeltype = EXCLUDED.confdeltype,
            confmatchtype = EXCLUDED.confmatchtype,
            conislocal = EXCLUDED.conislocal,
            coninhcount = EXCLUDED.coninhcount,
            connoinherit = EXCLUDED.connoinherit,
            conkey = EXCLUDED.conkey,
            confkey = EXCLUDED.confkey,
            conpfeqop = EXCLUDED.conpfeqop,
            conppeqop = EXCLUDED.conppeqop,
            conffeqop = EXCLUDED.conffeqop,
            conexclop = EXCLUDED.conexclop,
            conbin = EXCLUDED.conbin
          returning oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin
       """
      .executeInsert(PgConstraintRow.rowParser(1).single)
    
  }
}
