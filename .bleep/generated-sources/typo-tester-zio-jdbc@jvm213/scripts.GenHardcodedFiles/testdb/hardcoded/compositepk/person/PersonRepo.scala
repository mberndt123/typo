/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.compositepk.person

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PersonRepo {
  def delete: DeleteBuilder[PersonFields, PersonRow]
  def deleteById(compositeId: PersonId): ZIO[ZConnection, Throwable, Boolean]
  def insert(unsaved: PersonRow): ZIO[ZConnection, Throwable, PersonRow]
  def insert(unsaved: PersonRowUnsaved): ZIO[ZConnection, Throwable, PersonRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[PersonFields, PersonRow]
  def selectAll: ZStream[ZConnection, Throwable, PersonRow]
  def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[?]]): ZStream[ZConnection, Throwable, PersonRow]
  def selectById(compositeId: PersonId): ZIO[ZConnection, Throwable, Option[PersonRow]]
  def update: UpdateBuilder[PersonFields, PersonRow]
  def update(row: PersonRow): ZIO[ZConnection, Throwable, Boolean]
  def updateFieldValues(compositeId: PersonId, fieldValues: List[PersonFieldValue[?]]): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: PersonRow): ZIO[ZConnection, Throwable, UpdateResult[PersonRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
