/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesperson;

import adventureworks.person.businessentity.BusinessentityId;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

/** upsertBatch: Not implementable for zio-jdbc */
trait SalespersonRepo {
  def delete: DeleteBuilder[SalespersonFields, SalespersonRow]
  def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: SalespersonRow): ZIO[ZConnection, Throwable, SalespersonRow]
  def insert(unsaved: SalespersonRowUnsaved): ZIO[ZConnection, Throwable, SalespersonRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalespersonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalespersonRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[SalespersonFields, SalespersonRow]
  def selectAll: ZStream[ZConnection, Throwable, SalespersonRow]
  def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[SalespersonRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, SalespersonRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Map[BusinessentityId, SalespersonRow]]
  def update: UpdateBuilder[SalespersonFields, SalespersonRow]
  def update(row: SalespersonRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: SalespersonRow): ZIO[ZConnection, Throwable, UpdateResult[SalespersonRow]]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, SalespersonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}