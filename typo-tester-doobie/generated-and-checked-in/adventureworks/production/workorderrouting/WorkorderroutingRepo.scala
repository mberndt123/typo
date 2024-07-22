/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.workorderrouting

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait WorkorderroutingRepo {
  def delete: DeleteBuilder[WorkorderroutingFields, WorkorderroutingRow]
  def deleteById(compositeId: WorkorderroutingId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[WorkorderroutingId]): ConnectionIO[Int]
  def insert(unsaved: WorkorderroutingRow): ConnectionIO[WorkorderroutingRow]
  def insert(unsaved: WorkorderroutingRowUnsaved): ConnectionIO[WorkorderroutingRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, WorkorderroutingRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, WorkorderroutingRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[WorkorderroutingFields, WorkorderroutingRow]
  def selectAll: Stream[ConnectionIO, WorkorderroutingRow]
  def selectById(compositeId: WorkorderroutingId): ConnectionIO[Option[WorkorderroutingRow]]
  def selectByIds(compositeIds: Array[WorkorderroutingId]): Stream[ConnectionIO, WorkorderroutingRow]
  def selectByIdsTracked(compositeIds: Array[WorkorderroutingId]): ConnectionIO[Map[WorkorderroutingId, WorkorderroutingRow]]
  def update: UpdateBuilder[WorkorderroutingFields, WorkorderroutingRow]
  def update(row: WorkorderroutingRow): ConnectionIO[Boolean]
  def upsert(unsaved: WorkorderroutingRow): ConnectionIO[WorkorderroutingRow]
  def upsertBatch(unsaved: List[WorkorderroutingRow]): Stream[ConnectionIO, WorkorderroutingRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, WorkorderroutingRow], batchSize: Int = 10000): ConnectionIO[Int]
}
