/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait AddresstypeRepo {
  def delete(addresstypeid: AddresstypeId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[AddresstypeFields, AddresstypeRow]
  def insert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow
  def insertStreaming(unsaved: Iterator[AddresstypeRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: AddresstypeRowUnsaved)(implicit c: Connection): AddresstypeRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[AddresstypeRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[AddresstypeFields, AddresstypeRow]
  def selectAll(implicit c: Connection): List[AddresstypeRow]
  def selectById(addresstypeid: AddresstypeId)(implicit c: Connection): Option[AddresstypeRow]
  def selectByIds(addresstypeids: Array[AddresstypeId])(implicit c: Connection): List[AddresstypeRow]
  def update(row: AddresstypeRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[AddresstypeFields, AddresstypeRow]
  def upsert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow
}
