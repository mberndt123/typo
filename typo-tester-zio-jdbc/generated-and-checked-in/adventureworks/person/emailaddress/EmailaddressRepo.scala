/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.emailaddress

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait EmailaddressRepo {
  def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow]
  def deleteById(compositeId: EmailaddressId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[EmailaddressId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: EmailaddressRow): ZIO[ZConnection, Throwable, EmailaddressRow]
  def insert(unsaved: EmailaddressRowUnsaved): ZIO[ZConnection, Throwable, EmailaddressRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmailaddressRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmailaddressRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[EmailaddressFields, EmailaddressRow]
  def selectAll: ZStream[ZConnection, Throwable, EmailaddressRow]
  def selectById(compositeId: EmailaddressId): ZIO[ZConnection, Throwable, Option[EmailaddressRow]]
  def selectByIds(compositeIds: Array[EmailaddressId]): ZStream[ZConnection, Throwable, EmailaddressRow]
  def selectByIdsTracked(compositeIds: Array[EmailaddressId]): ZIO[ZConnection, Throwable, Map[EmailaddressId, EmailaddressRow]]
  def update: UpdateBuilder[EmailaddressFields, EmailaddressRow]
  def update(row: EmailaddressRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: EmailaddressRow): ZIO[ZConnection, Throwable, UpdateResult[EmailaddressRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, EmailaddressRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
