/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait BusinessentityaddressRepo {
  def delete(compositeId: BusinessentityaddressId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[BusinessentityaddressFields, BusinessentityaddressRow]
  def insert(unsaved: BusinessentityaddressRow): ConnectionIO[BusinessentityaddressRow]
  def insert(unsaved: BusinessentityaddressRowUnsaved): ConnectionIO[BusinessentityaddressRow]
  def select: SelectBuilder[BusinessentityaddressFields, BusinessentityaddressRow]
  def selectAll: Stream[ConnectionIO, BusinessentityaddressRow]
  def selectById(compositeId: BusinessentityaddressId): ConnectionIO[Option[BusinessentityaddressRow]]
  def update(row: BusinessentityaddressRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[BusinessentityaddressFields, BusinessentityaddressRow]
  def upsert(unsaved: BusinessentityaddressRow): ConnectionIO[BusinessentityaddressRow]
}
