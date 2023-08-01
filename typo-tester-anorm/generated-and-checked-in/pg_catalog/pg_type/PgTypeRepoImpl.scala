/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_type

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgTypeRepoImpl extends PgTypeRepo {
  override def delete(oid: PgTypeId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_type where oid = $oid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgTypeFields, PgTypeRow] = {
    DeleteBuilder("pg_catalog.pg_type", PgTypeFields)
  }
  override def insert(unsaved: PgTypeRow)(implicit c: Connection): PgTypeRow = {
    SQL"""insert into pg_catalog.pg_type(oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl)
          values (${unsaved.oid}::oid, ${unsaved.typname}::name, ${unsaved.typnamespace}::oid, ${unsaved.typowner}::oid, ${unsaved.typlen}::int2, ${unsaved.typbyval}, ${unsaved.typtype}::char, ${unsaved.typcategory}::char, ${unsaved.typispreferred}, ${unsaved.typisdefined}, ${unsaved.typdelim}::char, ${unsaved.typrelid}::oid, ${unsaved.typsubscript}::regproc, ${unsaved.typelem}::oid, ${unsaved.typarray}::oid, ${unsaved.typinput}::regproc, ${unsaved.typoutput}::regproc, ${unsaved.typreceive}::regproc, ${unsaved.typsend}::regproc, ${unsaved.typmodin}::regproc, ${unsaved.typmodout}::regproc, ${unsaved.typanalyze}::regproc, ${unsaved.typalign}::char, ${unsaved.typstorage}::char, ${unsaved.typnotnull}, ${unsaved.typbasetype}::oid, ${unsaved.typtypmod}::int4, ${unsaved.typndims}::int4, ${unsaved.typcollation}::oid, ${unsaved.typdefaultbin}::pg_node_tree, ${unsaved.typdefault}, ${unsaved.typacl}::_aclitem)
          returning oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl
       """
      .executeInsert(PgTypeRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgTypeFields, PgTypeRow] = {
    SelectBuilderSql("pg_catalog.pg_type", PgTypeFields, PgTypeRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgTypeRow] = {
    SQL"""select oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl
          from pg_catalog.pg_type
       """.as(PgTypeRow.rowParser(1).*)
  }
  override def selectById(oid: PgTypeId)(implicit c: Connection): Option[PgTypeRow] = {
    SQL"""select oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl
          from pg_catalog.pg_type
          where oid = $oid
       """.as(PgTypeRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgTypeId])(implicit c: Connection): List[PgTypeRow] = {
    SQL"""select oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl
          from pg_catalog.pg_type
          where oid = ANY($oids)
       """.as(PgTypeRow.rowParser(1).*)
    
  }
  override def update(row: PgTypeRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_type
          set typname = ${row.typname}::name,
              typnamespace = ${row.typnamespace}::oid,
              typowner = ${row.typowner}::oid,
              typlen = ${row.typlen}::int2,
              typbyval = ${row.typbyval},
              typtype = ${row.typtype}::char,
              typcategory = ${row.typcategory}::char,
              typispreferred = ${row.typispreferred},
              typisdefined = ${row.typisdefined},
              typdelim = ${row.typdelim}::char,
              typrelid = ${row.typrelid}::oid,
              typsubscript = ${row.typsubscript}::regproc,
              typelem = ${row.typelem}::oid,
              typarray = ${row.typarray}::oid,
              typinput = ${row.typinput}::regproc,
              typoutput = ${row.typoutput}::regproc,
              typreceive = ${row.typreceive}::regproc,
              typsend = ${row.typsend}::regproc,
              typmodin = ${row.typmodin}::regproc,
              typmodout = ${row.typmodout}::regproc,
              typanalyze = ${row.typanalyze}::regproc,
              typalign = ${row.typalign}::char,
              typstorage = ${row.typstorage}::char,
              typnotnull = ${row.typnotnull},
              typbasetype = ${row.typbasetype}::oid,
              typtypmod = ${row.typtypmod}::int4,
              typndims = ${row.typndims}::int4,
              typcollation = ${row.typcollation}::oid,
              typdefaultbin = ${row.typdefaultbin}::pg_node_tree,
              typdefault = ${row.typdefault},
              typacl = ${row.typacl}::_aclitem
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgTypeFields, PgTypeRow] = {
    UpdateBuilder("pg_catalog.pg_type", PgTypeFields, PgTypeRow.rowParser)
  }
  override def upsert(unsaved: PgTypeRow)(implicit c: Connection): PgTypeRow = {
    SQL"""insert into pg_catalog.pg_type(oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.typname}::name,
            ${unsaved.typnamespace}::oid,
            ${unsaved.typowner}::oid,
            ${unsaved.typlen}::int2,
            ${unsaved.typbyval},
            ${unsaved.typtype}::char,
            ${unsaved.typcategory}::char,
            ${unsaved.typispreferred},
            ${unsaved.typisdefined},
            ${unsaved.typdelim}::char,
            ${unsaved.typrelid}::oid,
            ${unsaved.typsubscript}::regproc,
            ${unsaved.typelem}::oid,
            ${unsaved.typarray}::oid,
            ${unsaved.typinput}::regproc,
            ${unsaved.typoutput}::regproc,
            ${unsaved.typreceive}::regproc,
            ${unsaved.typsend}::regproc,
            ${unsaved.typmodin}::regproc,
            ${unsaved.typmodout}::regproc,
            ${unsaved.typanalyze}::regproc,
            ${unsaved.typalign}::char,
            ${unsaved.typstorage}::char,
            ${unsaved.typnotnull},
            ${unsaved.typbasetype}::oid,
            ${unsaved.typtypmod}::int4,
            ${unsaved.typndims}::int4,
            ${unsaved.typcollation}::oid,
            ${unsaved.typdefaultbin}::pg_node_tree,
            ${unsaved.typdefault},
            ${unsaved.typacl}::_aclitem
          )
          on conflict (oid)
          do update set
            typname = EXCLUDED.typname,
            typnamespace = EXCLUDED.typnamespace,
            typowner = EXCLUDED.typowner,
            typlen = EXCLUDED.typlen,
            typbyval = EXCLUDED.typbyval,
            typtype = EXCLUDED.typtype,
            typcategory = EXCLUDED.typcategory,
            typispreferred = EXCLUDED.typispreferred,
            typisdefined = EXCLUDED.typisdefined,
            typdelim = EXCLUDED.typdelim,
            typrelid = EXCLUDED.typrelid,
            typsubscript = EXCLUDED.typsubscript,
            typelem = EXCLUDED.typelem,
            typarray = EXCLUDED.typarray,
            typinput = EXCLUDED.typinput,
            typoutput = EXCLUDED.typoutput,
            typreceive = EXCLUDED.typreceive,
            typsend = EXCLUDED.typsend,
            typmodin = EXCLUDED.typmodin,
            typmodout = EXCLUDED.typmodout,
            typanalyze = EXCLUDED.typanalyze,
            typalign = EXCLUDED.typalign,
            typstorage = EXCLUDED.typstorage,
            typnotnull = EXCLUDED.typnotnull,
            typbasetype = EXCLUDED.typbasetype,
            typtypmod = EXCLUDED.typtypmod,
            typndims = EXCLUDED.typndims,
            typcollation = EXCLUDED.typcollation,
            typdefaultbin = EXCLUDED.typdefaultbin,
            typdefault = EXCLUDED.typdefault,
            typacl = EXCLUDED.typacl
          returning oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl
       """
      .executeInsert(PgTypeRow.rowParser(1).single)
    
  }
}
