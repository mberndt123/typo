/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_origin

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgReplicationOriginRepo {
  def delete(roident: PgReplicationOriginId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgReplicationOriginFields, PgReplicationOriginRow]
  def insert(unsaved: PgReplicationOriginRow)(implicit c: Connection): PgReplicationOriginRow
  def select: SelectBuilder[PgReplicationOriginFields, PgReplicationOriginRow]
  def selectAll(implicit c: Connection): List[PgReplicationOriginRow]
  def selectById(roident: PgReplicationOriginId)(implicit c: Connection): Option[PgReplicationOriginRow]
  def selectByIds(roidents: Array[PgReplicationOriginId])(implicit c: Connection): List[PgReplicationOriginRow]
  def update(row: PgReplicationOriginRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgReplicationOriginFields, PgReplicationOriginRow]
  def upsert(unsaved: PgReplicationOriginRow)(implicit c: Connection): PgReplicationOriginRow
}
