/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ContacttypeRepo {
  def delete(contacttypeid: ContacttypeId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[ContacttypeFields, ContacttypeRow]
  def insert(unsaved: ContacttypeRow): ConnectionIO[ContacttypeRow]
  def insert(unsaved: ContacttypeRowUnsaved): ConnectionIO[ContacttypeRow]
  def select: SelectBuilder[ContacttypeFields, ContacttypeRow]
  def selectAll: Stream[ConnectionIO, ContacttypeRow]
  def selectById(contacttypeid: ContacttypeId): ConnectionIO[Option[ContacttypeRow]]
  def selectByIds(contacttypeids: Array[ContacttypeId]): Stream[ConnectionIO, ContacttypeRow]
  def update(row: ContacttypeRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[ContacttypeFields, ContacttypeRow]
  def upsert(unsaved: ContacttypeRow): ConnectionIO[ContacttypeRow]
}
