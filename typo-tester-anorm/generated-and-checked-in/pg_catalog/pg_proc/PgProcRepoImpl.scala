/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgProcRepoImpl extends PgProcRepo {
  override def delete(oid: PgProcId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_proc where oid = $oid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgProcFields, PgProcRow] = {
    DeleteBuilder("pg_catalog.pg_proc", PgProcFields)
  }
  override def insert(unsaved: PgProcRow)(implicit c: Connection): PgProcRow = {
    SQL"""insert into pg_catalog.pg_proc(oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl)
          values (${unsaved.oid}::oid, ${unsaved.proname}::name, ${unsaved.pronamespace}::oid, ${unsaved.proowner}::oid, ${unsaved.prolang}::oid, ${unsaved.procost}::float4, ${unsaved.prorows}::float4, ${unsaved.provariadic}::oid, ${unsaved.prosupport}::regproc, ${unsaved.prokind}::char, ${unsaved.prosecdef}, ${unsaved.proleakproof}, ${unsaved.proisstrict}, ${unsaved.proretset}, ${unsaved.provolatile}::char, ${unsaved.proparallel}::char, ${unsaved.pronargs}::int2, ${unsaved.pronargdefaults}::int2, ${unsaved.prorettype}::oid, ${unsaved.proargtypes}::oidvector, ${unsaved.proallargtypes}::_oid, ${unsaved.proargmodes}::_char, ${unsaved.proargnames}::_text, ${unsaved.proargdefaults}::pg_node_tree, ${unsaved.protrftypes}::_oid, ${unsaved.prosrc}, ${unsaved.probin}, ${unsaved.prosqlbody}::pg_node_tree, ${unsaved.proconfig}::_text, ${unsaved.proacl}::_aclitem)
          returning oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl
       """
      .executeInsert(PgProcRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgProcFields, PgProcRow] = {
    SelectBuilderSql("pg_catalog.pg_proc", PgProcFields, PgProcRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgProcRow] = {
    SQL"""select oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl
          from pg_catalog.pg_proc
       """.as(PgProcRow.rowParser(1).*)
  }
  override def selectById(oid: PgProcId)(implicit c: Connection): Option[PgProcRow] = {
    SQL"""select oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl
          from pg_catalog.pg_proc
          where oid = $oid
       """.as(PgProcRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgProcId])(implicit c: Connection): List[PgProcRow] = {
    SQL"""select oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl
          from pg_catalog.pg_proc
          where oid = ANY($oids)
       """.as(PgProcRow.rowParser(1).*)
    
  }
  override def update(row: PgProcRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_proc
          set proname = ${row.proname}::name,
              pronamespace = ${row.pronamespace}::oid,
              proowner = ${row.proowner}::oid,
              prolang = ${row.prolang}::oid,
              procost = ${row.procost}::float4,
              prorows = ${row.prorows}::float4,
              provariadic = ${row.provariadic}::oid,
              prosupport = ${row.prosupport}::regproc,
              prokind = ${row.prokind}::char,
              prosecdef = ${row.prosecdef},
              proleakproof = ${row.proleakproof},
              proisstrict = ${row.proisstrict},
              proretset = ${row.proretset},
              provolatile = ${row.provolatile}::char,
              proparallel = ${row.proparallel}::char,
              pronargs = ${row.pronargs}::int2,
              pronargdefaults = ${row.pronargdefaults}::int2,
              prorettype = ${row.prorettype}::oid,
              proargtypes = ${row.proargtypes}::oidvector,
              proallargtypes = ${row.proallargtypes}::_oid,
              proargmodes = ${row.proargmodes}::_char,
              proargnames = ${row.proargnames}::_text,
              proargdefaults = ${row.proargdefaults}::pg_node_tree,
              protrftypes = ${row.protrftypes}::_oid,
              prosrc = ${row.prosrc},
              probin = ${row.probin},
              prosqlbody = ${row.prosqlbody}::pg_node_tree,
              proconfig = ${row.proconfig}::_text,
              proacl = ${row.proacl}::_aclitem
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgProcFields, PgProcRow] = {
    UpdateBuilder("pg_catalog.pg_proc", PgProcFields, PgProcRow.rowParser)
  }
  override def upsert(unsaved: PgProcRow)(implicit c: Connection): PgProcRow = {
    SQL"""insert into pg_catalog.pg_proc(oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.proname}::name,
            ${unsaved.pronamespace}::oid,
            ${unsaved.proowner}::oid,
            ${unsaved.prolang}::oid,
            ${unsaved.procost}::float4,
            ${unsaved.prorows}::float4,
            ${unsaved.provariadic}::oid,
            ${unsaved.prosupport}::regproc,
            ${unsaved.prokind}::char,
            ${unsaved.prosecdef},
            ${unsaved.proleakproof},
            ${unsaved.proisstrict},
            ${unsaved.proretset},
            ${unsaved.provolatile}::char,
            ${unsaved.proparallel}::char,
            ${unsaved.pronargs}::int2,
            ${unsaved.pronargdefaults}::int2,
            ${unsaved.prorettype}::oid,
            ${unsaved.proargtypes}::oidvector,
            ${unsaved.proallargtypes}::_oid,
            ${unsaved.proargmodes}::_char,
            ${unsaved.proargnames}::_text,
            ${unsaved.proargdefaults}::pg_node_tree,
            ${unsaved.protrftypes}::_oid,
            ${unsaved.prosrc},
            ${unsaved.probin},
            ${unsaved.prosqlbody}::pg_node_tree,
            ${unsaved.proconfig}::_text,
            ${unsaved.proacl}::_aclitem
          )
          on conflict (oid)
          do update set
            proname = EXCLUDED.proname,
            pronamespace = EXCLUDED.pronamespace,
            proowner = EXCLUDED.proowner,
            prolang = EXCLUDED.prolang,
            procost = EXCLUDED.procost,
            prorows = EXCLUDED.prorows,
            provariadic = EXCLUDED.provariadic,
            prosupport = EXCLUDED.prosupport,
            prokind = EXCLUDED.prokind,
            prosecdef = EXCLUDED.prosecdef,
            proleakproof = EXCLUDED.proleakproof,
            proisstrict = EXCLUDED.proisstrict,
            proretset = EXCLUDED.proretset,
            provolatile = EXCLUDED.provolatile,
            proparallel = EXCLUDED.proparallel,
            pronargs = EXCLUDED.pronargs,
            pronargdefaults = EXCLUDED.pronargdefaults,
            prorettype = EXCLUDED.prorettype,
            proargtypes = EXCLUDED.proargtypes,
            proallargtypes = EXCLUDED.proallargtypes,
            proargmodes = EXCLUDED.proargmodes,
            proargnames = EXCLUDED.proargnames,
            proargdefaults = EXCLUDED.proargdefaults,
            protrftypes = EXCLUDED.protrftypes,
            prosrc = EXCLUDED.prosrc,
            probin = EXCLUDED.probin,
            prosqlbody = EXCLUDED.prosqlbody,
            proconfig = EXCLUDED.proconfig,
            proacl = EXCLUDED.proacl
          returning oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl
       """
      .executeInsert(PgProcRow.rowParser(1).single)
    
  }
}
