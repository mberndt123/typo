/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.customtypes.TypoUUID
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait DocumentRepo {
  def delete(documentnode: DocumentId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[DocumentFields, DocumentRow]
  def insert(unsaved: DocumentRow)(implicit c: Connection): DocumentRow
  def insertStreaming(unsaved: Iterator[DocumentRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: DocumentRowUnsaved)(implicit c: Connection): DocumentRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[DocumentRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[DocumentFields, DocumentRow]
  def selectAll(implicit c: Connection): List[DocumentRow]
  def selectById(documentnode: DocumentId)(implicit c: Connection): Option[DocumentRow]
  def selectByIds(documentnodes: Array[DocumentId])(implicit c: Connection): List[DocumentRow]
  def selectByUnique(rowguid: TypoUUID)(implicit c: Connection): Option[DocumentRow]
  def update(row: DocumentRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[DocumentFields, DocumentRow]
  def upsert(unsaved: DocumentRow)(implicit c: Connection): DocumentRow
}
