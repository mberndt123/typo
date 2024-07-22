/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesorderheader

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait SalesorderheaderRepo {
  def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def deleteById(salesorderid: SalesorderheaderId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(salesorderids: Array[SalesorderheaderId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: SalesorderheaderRow): ZIO[ZConnection, Throwable, SalesorderheaderRow]
  def insert(unsaved: SalesorderheaderRowUnsaved): ZIO[ZConnection, Throwable, SalesorderheaderRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheaderRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheaderRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def selectAll: ZStream[ZConnection, Throwable, SalesorderheaderRow]
  def selectById(salesorderid: SalesorderheaderId): ZIO[ZConnection, Throwable, Option[SalesorderheaderRow]]
  def selectByIds(salesorderids: Array[SalesorderheaderId]): ZStream[ZConnection, Throwable, SalesorderheaderRow]
  def selectByIdsTracked(salesorderids: Array[SalesorderheaderId]): ZIO[ZConnection, Throwable, Map[SalesorderheaderId, SalesorderheaderRow]]
  def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def update(row: SalesorderheaderRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: SalesorderheaderRow): ZIO[ZConnection, Throwable, UpdateResult[SalesorderheaderRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheaderRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
