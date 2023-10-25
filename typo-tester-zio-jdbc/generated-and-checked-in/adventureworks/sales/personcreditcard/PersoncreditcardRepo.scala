/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PersoncreditcardRepo {
  def delete(compositeId: PersoncreditcardId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def insert(unsaved: PersoncreditcardRow): ZIO[ZConnection, Throwable, PersoncreditcardRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersoncreditcardRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: PersoncreditcardRowUnsaved): ZIO[ZConnection, Throwable, PersoncreditcardRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersoncreditcardRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def selectAll: ZStream[ZConnection, Throwable, PersoncreditcardRow]
  def selectById(compositeId: PersoncreditcardId): ZIO[ZConnection, Throwable, Option[PersoncreditcardRow]]
  def update(row: PersoncreditcardRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def upsert(unsaved: PersoncreditcardRow): ZIO[ZConnection, Throwable, UpdateResult[PersoncreditcardRow]]
}
