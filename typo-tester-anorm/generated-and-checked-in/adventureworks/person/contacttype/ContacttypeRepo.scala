/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ContacttypeRepo {
  def delete(contacttypeid: ContacttypeId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[ContacttypeFields, ContacttypeRow]
  def insert(unsaved: ContacttypeRow)(implicit c: Connection): ContacttypeRow
  def insertStreaming(unsaved: Iterator[ContacttypeRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: ContacttypeRowUnsaved)(implicit c: Connection): ContacttypeRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ContacttypeRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[ContacttypeFields, ContacttypeRow]
  def selectAll(implicit c: Connection): List[ContacttypeRow]
  def selectById(contacttypeid: ContacttypeId)(implicit c: Connection): Option[ContacttypeRow]
  def selectByIds(contacttypeids: Array[ContacttypeId])(implicit c: Connection): List[ContacttypeRow]
  def update(row: ContacttypeRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[ContacttypeFields, ContacttypeRow]
  def upsert(unsaved: ContacttypeRow)(implicit c: Connection): ContacttypeRow
}
