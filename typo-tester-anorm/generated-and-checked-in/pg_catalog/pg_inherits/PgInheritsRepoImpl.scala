/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_inherits

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgInheritsRepoImpl extends PgInheritsRepo {
  override def delete(compositeId: PgInheritsId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_inherits where inhrelid = ${compositeId.inhrelid} AND inhseqno = ${compositeId.inhseqno}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgInheritsFields, PgInheritsRow] = {
    DeleteBuilder("pg_catalog.pg_inherits", PgInheritsFields)
  }
  override def insert(unsaved: PgInheritsRow)(implicit c: Connection): PgInheritsRow = {
    SQL"""insert into pg_catalog.pg_inherits(inhrelid, inhparent, inhseqno, inhdetachpending)
          values (${unsaved.inhrelid}::oid, ${unsaved.inhparent}::oid, ${unsaved.inhseqno}::int4, ${unsaved.inhdetachpending})
          returning inhrelid, inhparent, inhseqno, inhdetachpending
       """
      .executeInsert(PgInheritsRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgInheritsFields, PgInheritsRow] = {
    SelectBuilderSql("pg_catalog.pg_inherits", PgInheritsFields, PgInheritsRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgInheritsRow] = {
    SQL"""select inhrelid, inhparent, inhseqno, inhdetachpending
          from pg_catalog.pg_inherits
       """.as(PgInheritsRow.rowParser(1).*)
  }
  override def selectById(compositeId: PgInheritsId)(implicit c: Connection): Option[PgInheritsRow] = {
    SQL"""select inhrelid, inhparent, inhseqno, inhdetachpending
          from pg_catalog.pg_inherits
          where inhrelid = ${compositeId.inhrelid} AND inhseqno = ${compositeId.inhseqno}
       """.as(PgInheritsRow.rowParser(1).singleOpt)
  }
  override def update(row: PgInheritsRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update pg_catalog.pg_inherits
          set inhparent = ${row.inhparent}::oid,
              inhdetachpending = ${row.inhdetachpending}
          where inhrelid = ${compositeId.inhrelid} AND inhseqno = ${compositeId.inhseqno}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgInheritsFields, PgInheritsRow] = {
    UpdateBuilder("pg_catalog.pg_inherits", PgInheritsFields, PgInheritsRow.rowParser)
  }
  override def upsert(unsaved: PgInheritsRow)(implicit c: Connection): PgInheritsRow = {
    SQL"""insert into pg_catalog.pg_inherits(inhrelid, inhparent, inhseqno, inhdetachpending)
          values (
            ${unsaved.inhrelid}::oid,
            ${unsaved.inhparent}::oid,
            ${unsaved.inhseqno}::int4,
            ${unsaved.inhdetachpending}
          )
          on conflict (inhrelid, inhseqno)
          do update set
            inhparent = EXCLUDED.inhparent,
            inhdetachpending = EXCLUDED.inhdetachpending
          returning inhrelid, inhparent, inhseqno, inhdetachpending
       """
      .executeInsert(PgInheritsRow.rowParser(1).single)
    
  }
}
