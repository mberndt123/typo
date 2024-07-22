/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.transactionhistory

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait TransactionhistoryRepo {
  def delete: DeleteBuilder[TransactionhistoryFields, TransactionhistoryRow]
  def deleteById(transactionid: TransactionhistoryId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(transactionids: Array[TransactionhistoryId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: TransactionhistoryRow): ZIO[ZConnection, Throwable, TransactionhistoryRow]
  def insert(unsaved: TransactionhistoryRowUnsaved): ZIO[ZConnection, Throwable, TransactionhistoryRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, TransactionhistoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, TransactionhistoryRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[TransactionhistoryFields, TransactionhistoryRow]
  def selectAll: ZStream[ZConnection, Throwable, TransactionhistoryRow]
  def selectById(transactionid: TransactionhistoryId): ZIO[ZConnection, Throwable, Option[TransactionhistoryRow]]
  def selectByIds(transactionids: Array[TransactionhistoryId]): ZStream[ZConnection, Throwable, TransactionhistoryRow]
  def selectByIdsTracked(transactionids: Array[TransactionhistoryId]): ZIO[ZConnection, Throwable, Map[TransactionhistoryId, TransactionhistoryRow]]
  def update: UpdateBuilder[TransactionhistoryFields, TransactionhistoryRow]
  def update(row: TransactionhistoryRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: TransactionhistoryRow): ZIO[ZConnection, Throwable, UpdateResult[TransactionhistoryRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, TransactionhistoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
