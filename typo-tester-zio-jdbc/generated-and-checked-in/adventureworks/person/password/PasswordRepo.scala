/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PasswordRepo {
  def delete(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PasswordFields, PasswordRow]
  def insert(unsaved: PasswordRow): ZIO[ZConnection, Throwable, PasswordRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PasswordRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: PasswordRowUnsaved): ZIO[ZConnection, Throwable, PasswordRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PasswordRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[PasswordFields, PasswordRow]
  def selectAll: ZStream[ZConnection, Throwable, PasswordRow]
  def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[PasswordRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, PasswordRow]
  def update(row: PasswordRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PasswordFields, PasswordRow]
  def upsert(unsaved: PasswordRow): ZIO[ZConnection, Throwable, UpdateResult[PasswordRow]]
}
