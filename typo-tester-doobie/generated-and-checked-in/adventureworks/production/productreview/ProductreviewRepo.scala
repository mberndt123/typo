/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productreview;

import doobie.free.connection.ConnectionIO;
import fs2.Stream;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;

trait ProductreviewRepo {
  def delete: DeleteBuilder[ProductreviewFields, ProductreviewRow]
  def deleteById(productreviewid: ProductreviewId): ConnectionIO[Boolean]
  def deleteByIds(productreviewids: Array[ProductreviewId]): ConnectionIO[Int]
  def insert(unsaved: ProductreviewRow): ConnectionIO[ProductreviewRow]
  def insert(unsaved: ProductreviewRowUnsaved): ConnectionIO[ProductreviewRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductreviewRow], batchSize: Int = 10000): ConnectionIO[Long]
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductreviewRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[ProductreviewFields, ProductreviewRow]
  def selectAll: Stream[ConnectionIO, ProductreviewRow]
  def selectById(productreviewid: ProductreviewId): ConnectionIO[Option[ProductreviewRow]]
  def selectByIds(productreviewids: Array[ProductreviewId]): Stream[ConnectionIO, ProductreviewRow]
  def selectByIdsTracked(productreviewids: Array[ProductreviewId]): ConnectionIO[Map[ProductreviewId, ProductreviewRow]]
  def update: UpdateBuilder[ProductreviewFields, ProductreviewRow]
  def update(row: ProductreviewRow): ConnectionIO[Boolean]
  def upsert(unsaved: ProductreviewRow): ConnectionIO[ProductreviewRow]
  def upsertBatch(unsaved: List[ProductreviewRow]): Stream[ConnectionIO, ProductreviewRow]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, ProductreviewRow], batchSize: Int = 10000): ConnectionIO[Int]
}