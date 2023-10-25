/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait LocationRepo {
  def delete(locationid: LocationId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[LocationFields, LocationRow]
  def insert(unsaved: LocationRow): ZIO[ZConnection, Throwable, LocationRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, LocationRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: LocationRowUnsaved): ZIO[ZConnection, Throwable, LocationRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, LocationRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[LocationFields, LocationRow]
  def selectAll: ZStream[ZConnection, Throwable, LocationRow]
  def selectById(locationid: LocationId): ZIO[ZConnection, Throwable, Option[LocationRow]]
  def selectByIds(locationids: Array[LocationId]): ZStream[ZConnection, Throwable, LocationRow]
  def update(row: LocationRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[LocationFields, LocationRow]
  def upsert(unsaved: LocationRow): ZIO[ZConnection, Throwable, UpdateResult[LocationRow]]
}
