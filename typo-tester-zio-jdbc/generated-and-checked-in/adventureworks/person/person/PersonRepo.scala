/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.person;

import adventureworks.person.businessentity.BusinessentityId;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

/** upsertBatch: Not implementable for zio-jdbc */
trait PersonRepo {
  def delete: DeleteBuilder[PersonFields, PersonRow]
  def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: PersonRow): ZIO[ZConnection, Throwable, PersonRow]
  def insert(unsaved: PersonRowUnsaved): ZIO[ZConnection, Throwable, PersonRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[PersonFields, PersonRow]
  def selectAll: ZStream[ZConnection, Throwable, PersonRow]
  def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[PersonRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, PersonRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Map[BusinessentityId, PersonRow]]
  def update: UpdateBuilder[PersonFields, PersonRow]
  def update(row: PersonRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: PersonRow): ZIO[ZConnection, Throwable, UpdateResult[PersonRow]]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}