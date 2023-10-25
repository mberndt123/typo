/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PersoncreditcardRepo {
  def delete(compositeId: PersoncreditcardId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def insert(unsaved: PersoncreditcardRow)(implicit c: Connection): PersoncreditcardRow
  def insertStreaming(unsaved: Iterator[PersoncreditcardRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: PersoncreditcardRowUnsaved)(implicit c: Connection): PersoncreditcardRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[PersoncreditcardRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def selectAll(implicit c: Connection): List[PersoncreditcardRow]
  def selectById(compositeId: PersoncreditcardId)(implicit c: Connection): Option[PersoncreditcardRow]
  def update(row: PersoncreditcardRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow]
  def upsert(unsaved: PersoncreditcardRow)(implicit c: Connection): PersoncreditcardRow
}
