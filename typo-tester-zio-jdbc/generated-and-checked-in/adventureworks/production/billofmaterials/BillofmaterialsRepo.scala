/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.billofmaterials

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait BillofmaterialsRepo {
  def delete: DeleteBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def deleteById(billofmaterialsid: Int): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(billofmaterialsids: Array[Int]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: BillofmaterialsRow): ZIO[ZConnection, Throwable, BillofmaterialsRow]
  def insert(unsaved: BillofmaterialsRowUnsaved): ZIO[ZConnection, Throwable, BillofmaterialsRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, BillofmaterialsRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, BillofmaterialsRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def selectAll: ZStream[ZConnection, Throwable, BillofmaterialsRow]
  def selectById(billofmaterialsid: Int): ZIO[ZConnection, Throwable, Option[BillofmaterialsRow]]
  def selectByIds(billofmaterialsids: Array[Int]): ZStream[ZConnection, Throwable, BillofmaterialsRow]
  def selectByIdsTracked(billofmaterialsids: Array[Int]): ZIO[ZConnection, Throwable, Map[Int, BillofmaterialsRow]]
  def update: UpdateBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def update(row: BillofmaterialsRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: BillofmaterialsRow): ZIO[ZConnection, Throwable, UpdateResult[BillofmaterialsRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, BillofmaterialsRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
