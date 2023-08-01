/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_collation

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgCollationRepo {
  def delete(oid: PgCollationId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgCollationFields, PgCollationRow]
  def insert(unsaved: PgCollationRow): ConnectionIO[PgCollationRow]
  def select: SelectBuilder[PgCollationFields, PgCollationRow]
  def selectAll: Stream[ConnectionIO, PgCollationRow]
  def selectById(oid: PgCollationId): ConnectionIO[Option[PgCollationRow]]
  def selectByIds(oids: Array[PgCollationId]): Stream[ConnectionIO, PgCollationRow]
  def update(row: PgCollationRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgCollationFields, PgCollationRow]
  def upsert(unsaved: PgCollationRow): ConnectionIO[PgCollationRow]
}
