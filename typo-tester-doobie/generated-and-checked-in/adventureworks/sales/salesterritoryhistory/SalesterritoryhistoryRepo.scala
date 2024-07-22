/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesterritoryhistory

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalesterritoryhistoryRepo {
  def delete: DeleteBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow]
  def deleteById(compositeId: SalesterritoryhistoryId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[SalesterritoryhistoryId]): ConnectionIO[Int]
  def insert(unsaved: SalesterritoryhistoryRow): ConnectionIO[SalesterritoryhistoryRow]
  def insert(unsaved: SalesterritoryhistoryRowUnsaved): ConnectionIO[SalesterritoryhistoryRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, SalesterritoryhistoryRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesterritoryhistoryRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow]
  def selectAll: Stream[ConnectionIO, SalesterritoryhistoryRow]
  def selectById(compositeId: SalesterritoryhistoryId): ConnectionIO[Option[SalesterritoryhistoryRow]]
  def selectByIds(compositeIds: Array[SalesterritoryhistoryId]): Stream[ConnectionIO, SalesterritoryhistoryRow]
  def selectByIdsTracked(compositeIds: Array[SalesterritoryhistoryId]): ConnectionIO[Map[SalesterritoryhistoryId, SalesterritoryhistoryRow]]
  def update: UpdateBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow]
  def update(row: SalesterritoryhistoryRow): ConnectionIO[Boolean]
  def upsert(unsaved: SalesterritoryhistoryRow): ConnectionIO[SalesterritoryhistoryRow]
  def upsertBatch(unsaved: List[SalesterritoryhistoryRow]): Stream[ConnectionIO, SalesterritoryhistoryRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, SalesterritoryhistoryRow], batchSize: Int = 10000): ConnectionIO[Int]
}
