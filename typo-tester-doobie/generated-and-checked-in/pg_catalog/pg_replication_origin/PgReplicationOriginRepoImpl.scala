/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_origin

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

object PgReplicationOriginRepoImpl extends PgReplicationOriginRepo {
  override def delete(roident: PgReplicationOriginId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_replication_origin where roident = ${fromWrite(roident)(Write.fromPut(PgReplicationOriginId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgReplicationOriginFields, PgReplicationOriginRow] = {
    DeleteBuilder("pg_catalog.pg_replication_origin", PgReplicationOriginFields)
  }
  override def insert(unsaved: PgReplicationOriginRow): ConnectionIO[PgReplicationOriginRow] = {
    sql"""insert into pg_catalog.pg_replication_origin(roident, roname)
          values (${fromWrite(unsaved.roident)(Write.fromPut(PgReplicationOriginId.put))}::oid, ${fromWrite(unsaved.roname)(Write.fromPut(Meta.StringMeta.put))})
          returning roident, roname
       """.query(PgReplicationOriginRow.read).unique
  }
  override def select: SelectBuilder[PgReplicationOriginFields, PgReplicationOriginRow] = {
    SelectBuilderSql("pg_catalog.pg_replication_origin", PgReplicationOriginFields, PgReplicationOriginRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgReplicationOriginRow] = {
    sql"select roident, roname from pg_catalog.pg_replication_origin".query(PgReplicationOriginRow.read).stream
  }
  override def selectById(roident: PgReplicationOriginId): ConnectionIO[Option[PgReplicationOriginRow]] = {
    sql"select roident, roname from pg_catalog.pg_replication_origin where roident = ${fromWrite(roident)(Write.fromPut(PgReplicationOriginId.put))}".query(PgReplicationOriginRow.read).option
  }
  override def selectByIds(roidents: Array[PgReplicationOriginId]): Stream[ConnectionIO, PgReplicationOriginRow] = {
    sql"select roident, roname from pg_catalog.pg_replication_origin where roident = ANY(${roidents})".query(PgReplicationOriginRow.read).stream
  }
  override def update(row: PgReplicationOriginRow): ConnectionIO[Boolean] = {
    val roident = row.roident
    sql"""update pg_catalog.pg_replication_origin
          set roname = ${fromWrite(row.roname)(Write.fromPut(Meta.StringMeta.put))}
          where roident = ${fromWrite(roident)(Write.fromPut(PgReplicationOriginId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgReplicationOriginFields, PgReplicationOriginRow] = {
    UpdateBuilder("pg_catalog.pg_replication_origin", PgReplicationOriginFields, PgReplicationOriginRow.read)
  }
  override def upsert(unsaved: PgReplicationOriginRow): ConnectionIO[PgReplicationOriginRow] = {
    sql"""insert into pg_catalog.pg_replication_origin(roident, roname)
          values (
            ${fromWrite(unsaved.roident)(Write.fromPut(PgReplicationOriginId.put))}::oid,
            ${fromWrite(unsaved.roname)(Write.fromPut(Meta.StringMeta.put))}
          )
          on conflict (roident)
          do update set
            roname = EXCLUDED.roname
          returning roident, roname
       """.query(PgReplicationOriginRow.read).unique
  }
}
