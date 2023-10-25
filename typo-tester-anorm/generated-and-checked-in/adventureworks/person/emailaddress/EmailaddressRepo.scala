/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait EmailaddressRepo {
  def delete(compositeId: EmailaddressId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow]
  def insert(unsaved: EmailaddressRow)(implicit c: Connection): EmailaddressRow
  def insertStreaming(unsaved: Iterator[EmailaddressRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: EmailaddressRowUnsaved)(implicit c: Connection): EmailaddressRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[EmailaddressRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[EmailaddressFields, EmailaddressRow]
  def selectAll(implicit c: Connection): List[EmailaddressRow]
  def selectById(compositeId: EmailaddressId)(implicit c: Connection): Option[EmailaddressRow]
  def update(row: EmailaddressRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[EmailaddressFields, EmailaddressRow]
  def upsert(unsaved: EmailaddressRow)(implicit c: Connection): EmailaddressRow
}
