/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PersoncreditcardRepo {
  def delete(compositeId: PersoncreditcardId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def insert(unsaved: PersoncreditcardRow): ConnectionIO[PersoncreditcardRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, PersoncreditcardRow], batchSize: Int): ConnectionIO[Long]
  def insert(unsaved: PersoncreditcardRowUnsaved): ConnectionIO[PersoncreditcardRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PersoncreditcardRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def selectAll: Stream[ConnectionIO, PersoncreditcardRow]
  def selectById(compositeId: PersoncreditcardId): ConnectionIO[Option[PersoncreditcardRow]]
  def update(row: PersoncreditcardRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def upsert(unsaved: PersoncreditcardRow): ConnectionIO[PersoncreditcardRow]
}
