/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attribute

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgAttributeRepo {
  def delete(compositeId: PgAttributeId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgAttributeFields, PgAttributeRow]
  def insert(unsaved: PgAttributeRow): ConnectionIO[PgAttributeRow]
  def select: SelectBuilder[PgAttributeFields, PgAttributeRow]
  def selectAll: Stream[ConnectionIO, PgAttributeRow]
  def selectById(compositeId: PgAttributeId): ConnectionIO[Option[PgAttributeRow]]
  def update(row: PgAttributeRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgAttributeFields, PgAttributeRow]
  def upsert(unsaved: PgAttributeRow): ConnectionIO[PgAttributeRow]
}
