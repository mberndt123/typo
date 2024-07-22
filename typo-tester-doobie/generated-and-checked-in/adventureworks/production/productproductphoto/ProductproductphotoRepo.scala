/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productproductphoto

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductproductphotoRepo {
  def delete: DeleteBuilder[ProductproductphotoFields, ProductproductphotoRow]
  def deleteById(compositeId: ProductproductphotoId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[ProductproductphotoId]): ConnectionIO[Int]
  def insert(unsaved: ProductproductphotoRow): ConnectionIO[ProductproductphotoRow]
  def insert(unsaved: ProductproductphotoRowUnsaved): ConnectionIO[ProductproductphotoRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductproductphotoRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductproductphotoRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[ProductproductphotoFields, ProductproductphotoRow]
  def selectAll: Stream[ConnectionIO, ProductproductphotoRow]
  def selectById(compositeId: ProductproductphotoId): ConnectionIO[Option[ProductproductphotoRow]]
  def selectByIds(compositeIds: Array[ProductproductphotoId]): Stream[ConnectionIO, ProductproductphotoRow]
  def selectByIdsTracked(compositeIds: Array[ProductproductphotoId]): ConnectionIO[Map[ProductproductphotoId, ProductproductphotoRow]]
  def update: UpdateBuilder[ProductproductphotoFields, ProductproductphotoRow]
  def update(row: ProductproductphotoRow): ConnectionIO[Boolean]
  def upsert(unsaved: ProductproductphotoRow): ConnectionIO[ProductproductphotoRow]
  def upsertBatch(unsaved: List[ProductproductphotoRow]): Stream[ConnectionIO, ProductproductphotoRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, ProductproductphotoRow], batchSize: Int = 10000): ConnectionIO[Int]
}
