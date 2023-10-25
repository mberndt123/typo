/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait EmployeeRepo {
  def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[EmployeeFields, EmployeeRow]
  def insert(unsaved: EmployeeRow): ConnectionIO[EmployeeRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, EmployeeRow], batchSize: Int): ConnectionIO[Long]
  def insert(unsaved: EmployeeRowUnsaved): ConnectionIO[EmployeeRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, EmployeeRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[EmployeeFields, EmployeeRow]
  def selectAll: Stream[ConnectionIO, EmployeeRow]
  def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[EmployeeRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, EmployeeRow]
  def update(row: EmployeeRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[EmployeeFields, EmployeeRow]
  def upsert(unsaved: EmployeeRow): ConnectionIO[EmployeeRow]
}
