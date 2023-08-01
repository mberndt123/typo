/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait DepartmentRepo {
  def delete(departmentid: DepartmentId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[DepartmentFields, DepartmentRow]
  def insert(unsaved: DepartmentRow): ConnectionIO[DepartmentRow]
  def insert(unsaved: DepartmentRowUnsaved): ConnectionIO[DepartmentRow]
  def select: SelectBuilder[DepartmentFields, DepartmentRow]
  def selectAll: Stream[ConnectionIO, DepartmentRow]
  def selectById(departmentid: DepartmentId): ConnectionIO[Option[DepartmentRow]]
  def selectByIds(departmentids: Array[DepartmentId]): Stream[ConnectionIO, DepartmentRow]
  def update(row: DepartmentRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[DepartmentFields, DepartmentRow]
  def upsert(unsaved: DepartmentRow): ConnectionIO[DepartmentRow]
}
