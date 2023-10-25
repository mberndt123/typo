/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait WorkorderRepo {
  def delete(workorderid: WorkorderId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[WorkorderFields, WorkorderRow]
  def insert(unsaved: WorkorderRow): ZIO[ZConnection, Throwable, WorkorderRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, WorkorderRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: WorkorderRowUnsaved): ZIO[ZConnection, Throwable, WorkorderRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, WorkorderRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[WorkorderFields, WorkorderRow]
  def selectAll: ZStream[ZConnection, Throwable, WorkorderRow]
  def selectById(workorderid: WorkorderId): ZIO[ZConnection, Throwable, Option[WorkorderRow]]
  def selectByIds(workorderids: Array[WorkorderId]): ZStream[ZConnection, Throwable, WorkorderRow]
  def update(row: WorkorderRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[WorkorderFields, WorkorderRow]
  def upsert(unsaved: WorkorderRow): ZIO[ZConnection, Throwable, UpdateResult[WorkorderRow]]
}
