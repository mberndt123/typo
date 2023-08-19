/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgPublicationRepoImpl extends PgPublicationRepo {
  override def delete(oid: PgPublicationId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_publication where oid = ${ParameterValue(oid, null, PgPublicationId.toStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgPublicationFields, PgPublicationRow] = {
    DeleteBuilder("pg_catalog.pg_publication", PgPublicationFields)
  }
  override def insert(unsaved: PgPublicationRow)(implicit c: Connection): PgPublicationRow = {
    SQL"""insert into pg_catalog.pg_publication(oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot)
          values (${ParameterValue(unsaved.oid, null, PgPublicationId.toStatement)}::oid, ${ParameterValue(unsaved.pubname, null, ToStatement.stringToStatement)}::name, ${ParameterValue(unsaved.pubowner, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.puballtables, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.pubinsert, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.pubupdate, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.pubdelete, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.pubtruncate, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.pubviaroot, null, ToStatement.booleanToStatement)})
          returning oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
       """
      .executeInsert(PgPublicationRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgPublicationFields, PgPublicationRow] = {
    SelectBuilderSql("pg_catalog.pg_publication", PgPublicationFields, PgPublicationRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgPublicationRow] = {
    SQL"""select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
          from pg_catalog.pg_publication
       """.as(PgPublicationRow.rowParser(1).*)
  }
  override def selectById(oid: PgPublicationId)(implicit c: Connection): Option[PgPublicationRow] = {
    SQL"""select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
          from pg_catalog.pg_publication
          where oid = ${ParameterValue(oid, null, PgPublicationId.toStatement)}
       """.as(PgPublicationRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgPublicationId])(implicit c: Connection): List[PgPublicationRow] = {
    SQL"""select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
          from pg_catalog.pg_publication
          where oid = ANY(${oids})
       """.as(PgPublicationRow.rowParser(1).*)
    
  }
  override def update(row: PgPublicationRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_publication
          set pubname = ${ParameterValue(row.pubname, null, ToStatement.stringToStatement)}::name,
              pubowner = ${ParameterValue(row.pubowner, null, ToStatement.longToStatement)}::oid,
              puballtables = ${ParameterValue(row.puballtables, null, ToStatement.booleanToStatement)},
              pubinsert = ${ParameterValue(row.pubinsert, null, ToStatement.booleanToStatement)},
              pubupdate = ${ParameterValue(row.pubupdate, null, ToStatement.booleanToStatement)},
              pubdelete = ${ParameterValue(row.pubdelete, null, ToStatement.booleanToStatement)},
              pubtruncate = ${ParameterValue(row.pubtruncate, null, ToStatement.booleanToStatement)},
              pubviaroot = ${ParameterValue(row.pubviaroot, null, ToStatement.booleanToStatement)}
          where oid = ${ParameterValue(oid, null, PgPublicationId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgPublicationFields, PgPublicationRow] = {
    UpdateBuilder("pg_catalog.pg_publication", PgPublicationFields, PgPublicationRow.rowParser)
  }
  override def upsert(unsaved: PgPublicationRow)(implicit c: Connection): PgPublicationRow = {
    SQL"""insert into pg_catalog.pg_publication(oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot)
          values (
            ${ParameterValue(unsaved.oid, null, PgPublicationId.toStatement)}::oid,
            ${ParameterValue(unsaved.pubname, null, ToStatement.stringToStatement)}::name,
            ${ParameterValue(unsaved.pubowner, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.puballtables, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.pubinsert, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.pubupdate, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.pubdelete, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.pubtruncate, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.pubviaroot, null, ToStatement.booleanToStatement)}
          )
          on conflict (oid)
          do update set
            pubname = EXCLUDED.pubname,
            pubowner = EXCLUDED.pubowner,
            puballtables = EXCLUDED.puballtables,
            pubinsert = EXCLUDED.pubinsert,
            pubupdate = EXCLUDED.pubupdate,
            pubdelete = EXCLUDED.pubdelete,
            pubtruncate = EXCLUDED.pubtruncate,
            pubviaroot = EXCLUDED.pubviaroot
          returning oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
       """
      .executeInsert(PgPublicationRow.rowParser(1).single)
    
  }
}
