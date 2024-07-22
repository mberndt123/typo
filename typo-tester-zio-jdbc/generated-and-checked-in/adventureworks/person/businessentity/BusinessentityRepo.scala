/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentity;

import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

/** upsertBatch: Not implementable for zio-jdbc */
trait BusinessentityRepo {
  def delete: DeleteBuilder[BusinessentityFields, BusinessentityRow]
  def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: BusinessentityRow): ZIO[ZConnection, Throwable, BusinessentityRow]
  def insert(unsaved: BusinessentityRowUnsaved): ZIO[ZConnection, Throwable, BusinessentityRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[BusinessentityFields, BusinessentityRow]
  def selectAll: ZStream[ZConnection, Throwable, BusinessentityRow]
  def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[BusinessentityRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, BusinessentityRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Map[BusinessentityId, BusinessentityRow]]
  def update: UpdateBuilder[BusinessentityFields, BusinessentityRow]
  def update(row: BusinessentityRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: BusinessentityRow): ZIO[ZConnection, Throwable, UpdateResult[BusinessentityRow]]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}