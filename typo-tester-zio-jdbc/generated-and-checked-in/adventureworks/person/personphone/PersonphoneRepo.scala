/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.personphone;

import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

/** upsertBatch: Not implementable for zio-jdbc */
trait PersonphoneRepo {
  def delete: DeleteBuilder[PersonphoneFields, PersonphoneRow]
  def deleteById(compositeId: PersonphoneId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[PersonphoneId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: PersonphoneRow): ZIO[ZConnection, Throwable, PersonphoneRow]
  def insert(unsaved: PersonphoneRowUnsaved): ZIO[ZConnection, Throwable, PersonphoneRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonphoneRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersonphoneRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[PersonphoneFields, PersonphoneRow]
  def selectAll: ZStream[ZConnection, Throwable, PersonphoneRow]
  def selectById(compositeId: PersonphoneId): ZIO[ZConnection, Throwable, Option[PersonphoneRow]]
  def selectByIds(compositeIds: Array[PersonphoneId]): ZStream[ZConnection, Throwable, PersonphoneRow]
  def selectByIdsTracked(compositeIds: Array[PersonphoneId]): ZIO[ZConnection, Throwable, Map[PersonphoneId, PersonphoneRow]]
  def update: UpdateBuilder[PersonphoneFields, PersonphoneRow]
  def update(row: PersonphoneRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: PersonphoneRow): ZIO[ZConnection, Throwable, UpdateResult[PersonphoneRow]]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonphoneRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}