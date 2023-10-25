/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait EmailaddressRepo {
  def delete(compositeId: EmailaddressId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow]
  def insert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, EmailaddressRow], batchSize: Int): ConnectionIO[Long]
  def insert(unsaved: EmailaddressRowUnsaved): ConnectionIO[EmailaddressRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, EmailaddressRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[EmailaddressFields, EmailaddressRow]
  def selectAll: Stream[ConnectionIO, EmailaddressRow]
  def selectById(compositeId: EmailaddressId): ConnectionIO[Option[EmailaddressRow]]
  def update(row: EmailaddressRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[EmailaddressFields, EmailaddressRow]
  def upsert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow]
}
