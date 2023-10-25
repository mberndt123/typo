/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait StateprovinceRepo {
  def delete(stateprovinceid: StateprovinceId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[StateprovinceFields, StateprovinceRow]
  def insert(unsaved: StateprovinceRow): ZIO[ZConnection, Throwable, StateprovinceRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, StateprovinceRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: StateprovinceRowUnsaved): ZIO[ZConnection, Throwable, StateprovinceRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, StateprovinceRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[StateprovinceFields, StateprovinceRow]
  def selectAll: ZStream[ZConnection, Throwable, StateprovinceRow]
  def selectById(stateprovinceid: StateprovinceId): ZIO[ZConnection, Throwable, Option[StateprovinceRow]]
  def selectByIds(stateprovinceids: Array[StateprovinceId]): ZStream[ZConnection, Throwable, StateprovinceRow]
  def update(row: StateprovinceRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[StateprovinceFields, StateprovinceRow]
  def upsert(unsaved: StateprovinceRow): ZIO[ZConnection, Throwable, UpdateResult[StateprovinceRow]]
}
