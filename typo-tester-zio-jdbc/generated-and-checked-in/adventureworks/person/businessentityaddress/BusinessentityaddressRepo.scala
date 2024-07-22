/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentityaddress

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait BusinessentityaddressRepo {
  def delete: DeleteBuilder[BusinessentityaddressFields, BusinessentityaddressRow]
  def deleteById(compositeId: BusinessentityaddressId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[BusinessentityaddressId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: BusinessentityaddressRow): ZIO[ZConnection, Throwable, BusinessentityaddressRow]
  def insert(unsaved: BusinessentityaddressRowUnsaved): ZIO[ZConnection, Throwable, BusinessentityaddressRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityaddressRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityaddressRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[BusinessentityaddressFields, BusinessentityaddressRow]
  def selectAll: ZStream[ZConnection, Throwable, BusinessentityaddressRow]
  def selectById(compositeId: BusinessentityaddressId): ZIO[ZConnection, Throwable, Option[BusinessentityaddressRow]]
  def selectByIds(compositeIds: Array[BusinessentityaddressId]): ZStream[ZConnection, Throwable, BusinessentityaddressRow]
  def selectByIdsTracked(compositeIds: Array[BusinessentityaddressId]): ZIO[ZConnection, Throwable, Map[BusinessentityaddressId, BusinessentityaddressRow]]
  def update: UpdateBuilder[BusinessentityaddressFields, BusinessentityaddressRow]
  def update(row: BusinessentityaddressRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: BusinessentityaddressRow): ZIO[ZConnection, Throwable, UpdateResult[BusinessentityaddressRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityaddressRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
