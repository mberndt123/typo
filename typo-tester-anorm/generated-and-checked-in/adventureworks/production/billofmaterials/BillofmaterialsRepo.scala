/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait BillofmaterialsRepo {
  def delete(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def insert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow
  def insertStreaming(unsaved: Iterator[BillofmaterialsRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: BillofmaterialsRowUnsaved)(implicit c: Connection): BillofmaterialsRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[BillofmaterialsRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def selectAll(implicit c: Connection): List[BillofmaterialsRow]
  def selectById(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Option[BillofmaterialsRow]
  def selectByIds(billofmaterialsids: Array[BillofmaterialsId])(implicit c: Connection): List[BillofmaterialsRow]
  def update(row: BillofmaterialsRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def upsert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow
}
