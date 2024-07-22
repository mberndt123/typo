/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.department

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait DepartmentRepo {
  def delete: DeleteBuilder[DepartmentFields, DepartmentRow]
  def deleteById(departmentid: DepartmentId)(implicit c: Connection): Boolean
  def deleteByIds(departmentids: Array[DepartmentId])(implicit c: Connection): Int
  def insert(unsaved: DepartmentRow)(implicit c: Connection): DepartmentRow
  def insert(unsaved: DepartmentRowUnsaved)(implicit c: Connection): DepartmentRow
  def insertStreaming(unsaved: Iterator[DepartmentRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[DepartmentRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[DepartmentFields, DepartmentRow]
  def selectAll(implicit c: Connection): List[DepartmentRow]
  def selectById(departmentid: DepartmentId)(implicit c: Connection): Option[DepartmentRow]
  def selectByIds(departmentids: Array[DepartmentId])(implicit c: Connection): List[DepartmentRow]
  def selectByIdsTracked(departmentids: Array[DepartmentId])(implicit c: Connection): Map[DepartmentId, DepartmentRow]
  def update: UpdateBuilder[DepartmentFields, DepartmentRow]
  def update(row: DepartmentRow)(implicit c: Connection): Boolean
  def upsert(unsaved: DepartmentRow)(implicit c: Connection): DepartmentRow
  def upsertBatch(unsaved: Iterable[DepartmentRow])(implicit c: Connection): List[DepartmentRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[DepartmentRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
