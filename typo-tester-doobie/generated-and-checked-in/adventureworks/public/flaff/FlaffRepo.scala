/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public.flaff

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait FlaffRepo {
  def delete: DeleteBuilder[FlaffFields, FlaffRow]
  def deleteById(compositeId: FlaffId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[FlaffId]): ConnectionIO[Int]
  def insert(unsaved: FlaffRow): ConnectionIO[FlaffRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, FlaffRow], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[FlaffFields, FlaffRow]
  def selectAll: Stream[ConnectionIO, FlaffRow]
  def selectById(compositeId: FlaffId): ConnectionIO[Option[FlaffRow]]
  def selectByIds(compositeIds: Array[FlaffId]): Stream[ConnectionIO, FlaffRow]
  def selectByIdsTracked(compositeIds: Array[FlaffId]): ConnectionIO[Map[FlaffId, FlaffRow]]
  def update: UpdateBuilder[FlaffFields, FlaffRow]
  def update(row: FlaffRow): ConnectionIO[Boolean]
  def upsert(unsaved: FlaffRow): ConnectionIO[FlaffRow]
  def upsertBatch(unsaved: List[FlaffRow]): Stream[ConnectionIO, FlaffRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, FlaffRow], batchSize: Int = 10000): ConnectionIO[Int]
}
