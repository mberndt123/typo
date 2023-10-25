/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductvendorRepo {
  def delete(compositeId: ProductvendorId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[ProductvendorFields, ProductvendorRow]
  def insert(unsaved: ProductvendorRow)(implicit c: Connection): ProductvendorRow
  def insertStreaming(unsaved: Iterator[ProductvendorRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: ProductvendorRowUnsaved)(implicit c: Connection): ProductvendorRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductvendorRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[ProductvendorFields, ProductvendorRow]
  def selectAll(implicit c: Connection): List[ProductvendorRow]
  def selectById(compositeId: ProductvendorId)(implicit c: Connection): Option[ProductvendorRow]
  def update(row: ProductvendorRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[ProductvendorFields, ProductvendorRow]
  def upsert(unsaved: ProductvendorRow)(implicit c: Connection): ProductvendorRow
}
