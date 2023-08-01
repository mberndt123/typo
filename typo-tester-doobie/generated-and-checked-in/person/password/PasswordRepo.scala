/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PasswordRepo {
  def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PasswordFields, PasswordRow]
  def insert(unsaved: PasswordRow): ConnectionIO[PasswordRow]
  def insert(unsaved: PasswordRowUnsaved): ConnectionIO[PasswordRow]
  def select: SelectBuilder[PasswordFields, PasswordRow]
  def selectAll: Stream[ConnectionIO, PasswordRow]
  def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[PasswordRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, PasswordRow]
  def update(row: PasswordRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PasswordFields, PasswordRow]
  def upsert(unsaved: PasswordRow): ConnectionIO[PasswordRow]
}
