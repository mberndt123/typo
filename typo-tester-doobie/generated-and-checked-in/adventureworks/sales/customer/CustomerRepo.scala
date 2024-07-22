/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.customer

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait CustomerRepo {
  def delete: DeleteBuilder[CustomerFields, CustomerRow]
  def deleteById(customerid: CustomerId): ConnectionIO[Boolean]
  def deleteByIds(customerids: Array[CustomerId]): ConnectionIO[Int]
  def insert(unsaved: CustomerRow): ConnectionIO[CustomerRow]
  def insert(unsaved: CustomerRowUnsaved): ConnectionIO[CustomerRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, CustomerRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CustomerRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[CustomerFields, CustomerRow]
  def selectAll: Stream[ConnectionIO, CustomerRow]
  def selectById(customerid: CustomerId): ConnectionIO[Option[CustomerRow]]
  def selectByIds(customerids: Array[CustomerId]): Stream[ConnectionIO, CustomerRow]
  def selectByIdsTracked(customerids: Array[CustomerId]): ConnectionIO[Map[CustomerId, CustomerRow]]
  def update: UpdateBuilder[CustomerFields, CustomerRow]
  def update(row: CustomerRow): ConnectionIO[Boolean]
  def upsert(unsaved: CustomerRow): ConnectionIO[CustomerRow]
  def upsertBatch(unsaved: List[CustomerRow]): Stream[ConnectionIO, CustomerRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, CustomerRow], batchSize: Int = 10000): ConnectionIO[Int]
}
