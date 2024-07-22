/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productdescription

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductdescriptionRepo {
  def delete: DeleteBuilder[ProductdescriptionFields, ProductdescriptionRow]
  def deleteById(productdescriptionid: ProductdescriptionId): ConnectionIO[Boolean]
  def deleteByIds(productdescriptionids: Array[ProductdescriptionId]): ConnectionIO[Int]
  def insert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow]
  def insert(unsaved: ProductdescriptionRowUnsaved): ConnectionIO[ProductdescriptionRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductdescriptionRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductdescriptionRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[ProductdescriptionFields, ProductdescriptionRow]
  def selectAll: Stream[ConnectionIO, ProductdescriptionRow]
  def selectById(productdescriptionid: ProductdescriptionId): ConnectionIO[Option[ProductdescriptionRow]]
  def selectByIds(productdescriptionids: Array[ProductdescriptionId]): Stream[ConnectionIO, ProductdescriptionRow]
  def selectByIdsTracked(productdescriptionids: Array[ProductdescriptionId]): ConnectionIO[Map[ProductdescriptionId, ProductdescriptionRow]]
  def update: UpdateBuilder[ProductdescriptionFields, ProductdescriptionRow]
  def update(row: ProductdescriptionRow): ConnectionIO[Boolean]
  def upsert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow]
  def upsertBatch(unsaved: List[ProductdescriptionRow]): Stream[ConnectionIO, ProductdescriptionRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, ProductdescriptionRow], batchSize: Int = 10000): ConnectionIO[Int]
}
