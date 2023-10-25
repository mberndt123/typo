/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductproductphotoRepo {
  def delete(compositeId: ProductproductphotoId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[ProductproductphotoFields, ProductproductphotoRow]
  def insert(unsaved: ProductproductphotoRow): ConnectionIO[ProductproductphotoRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductproductphotoRow], batchSize: Int): ConnectionIO[Long]
  def insert(unsaved: ProductproductphotoRowUnsaved): ConnectionIO[ProductproductphotoRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductproductphotoRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[ProductproductphotoFields, ProductproductphotoRow]
  def selectAll: Stream[ConnectionIO, ProductproductphotoRow]
  def selectById(compositeId: ProductproductphotoId): ConnectionIO[Option[ProductproductphotoRow]]
  def update(row: ProductproductphotoRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[ProductproductphotoFields, ProductproductphotoRow]
  def upsert(unsaved: ProductproductphotoRow): ConnectionIO[ProductproductphotoRow]
}
