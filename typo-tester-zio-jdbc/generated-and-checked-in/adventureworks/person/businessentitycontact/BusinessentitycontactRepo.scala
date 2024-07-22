/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentitycontact

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait BusinessentitycontactRepo {
  def delete: DeleteBuilder[BusinessentitycontactFields, BusinessentitycontactRow]
  def deleteById(compositeId: BusinessentitycontactId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[BusinessentitycontactId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: BusinessentitycontactRow): ZIO[ZConnection, Throwable, BusinessentitycontactRow]
  def insert(unsaved: BusinessentitycontactRowUnsaved): ZIO[ZConnection, Throwable, BusinessentitycontactRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentitycontactRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentitycontactRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[BusinessentitycontactFields, BusinessentitycontactRow]
  def selectAll: ZStream[ZConnection, Throwable, BusinessentitycontactRow]
  def selectById(compositeId: BusinessentitycontactId): ZIO[ZConnection, Throwable, Option[BusinessentitycontactRow]]
  def selectByIds(compositeIds: Array[BusinessentitycontactId]): ZStream[ZConnection, Throwable, BusinessentitycontactRow]
  def selectByIdsTracked(compositeIds: Array[BusinessentitycontactId]): ZIO[ZConnection, Throwable, Map[BusinessentitycontactId, BusinessentitycontactRow]]
  def update: UpdateBuilder[BusinessentitycontactFields, BusinessentitycontactRow]
  def update(row: BusinessentitycontactRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: BusinessentitycontactRow): ZIO[ZConnection, Throwable, UpdateResult[BusinessentitycontactRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentitycontactRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
