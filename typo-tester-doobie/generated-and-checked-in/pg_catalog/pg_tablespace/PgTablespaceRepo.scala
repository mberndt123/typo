/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tablespace

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgTablespaceRepo {
  def delete(oid: PgTablespaceId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgTablespaceFields, PgTablespaceRow]
  def insert(unsaved: PgTablespaceRow): ConnectionIO[PgTablespaceRow]
  def select: SelectBuilder[PgTablespaceFields, PgTablespaceRow]
  def selectAll: Stream[ConnectionIO, PgTablespaceRow]
  def selectById(oid: PgTablespaceId): ConnectionIO[Option[PgTablespaceRow]]
  def selectByIds(oids: Array[PgTablespaceId]): Stream[ConnectionIO, PgTablespaceRow]
  def update(row: PgTablespaceRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgTablespaceFields, PgTablespaceRow]
  def upsert(unsaved: PgTablespaceRow): ConnectionIO[PgTablespaceRow]
}
