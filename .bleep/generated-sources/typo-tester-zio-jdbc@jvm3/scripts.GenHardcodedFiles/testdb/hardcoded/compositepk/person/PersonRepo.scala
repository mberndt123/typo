/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PersonRepo {
  def delete(compositeId: PersonId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PersonFields, PersonRow]
  def insert(unsaved: PersonRow): ZIO[ZConnection, Throwable, PersonRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: PersonRowUnsaved): ZIO[ZConnection, Throwable, PersonRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[PersonFields, PersonRow]
  def selectAll: ZStream[ZConnection, Throwable, PersonRow]
  def selectById(compositeId: PersonId): ZIO[ZConnection, Throwable, Option[PersonRow]]
  def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[?]]): ZStream[ZConnection, Throwable, PersonRow]
  def update(row: PersonRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PersonFields, PersonRow]
  def updateFieldValues(compositeId: PersonId, fieldValues: List[PersonFieldValue[?]]): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: PersonRow): ZIO[ZConnection, Throwable, UpdateResult[PersonRow]]
}
