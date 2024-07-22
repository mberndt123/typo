/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.location;

import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

/** upsertBatch: Not implementable for zio-jdbc */
trait LocationRepo {
  def delete: DeleteBuilder[LocationFields, LocationRow]
  def deleteById(locationid: LocationId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(locationids: Array[LocationId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: LocationRow): ZIO[ZConnection, Throwable, LocationRow]
  def insert(unsaved: LocationRowUnsaved): ZIO[ZConnection, Throwable, LocationRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, LocationRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, LocationRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[LocationFields, LocationRow]
  def selectAll: ZStream[ZConnection, Throwable, LocationRow]
  def selectById(locationid: LocationId): ZIO[ZConnection, Throwable, Option[LocationRow]]
  def selectByIds(locationids: Array[LocationId]): ZStream[ZConnection, Throwable, LocationRow]
  def selectByIdsTracked(locationids: Array[LocationId]): ZIO[ZConnection, Throwable, Map[LocationId, LocationRow]]
  def update: UpdateBuilder[LocationFields, LocationRow]
  def update(row: LocationRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: LocationRow): ZIO[ZConnection, Throwable, UpdateResult[LocationRow]]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, LocationRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}