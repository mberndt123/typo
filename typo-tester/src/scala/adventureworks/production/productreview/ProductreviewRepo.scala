/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import java.sql.Connection

trait ProductreviewRepo {
  def delete(productreviewid: ProductreviewId)(implicit c: Connection): Boolean
  def insert(unsaved: ProductreviewRow)(implicit c: Connection): ProductreviewRow
  def insert(unsaved: ProductreviewRowUnsaved)(implicit c: Connection): ProductreviewRow
  def selectAll(implicit c: Connection): List[ProductreviewRow]
  def selectByFieldValues(fieldValues: List[ProductreviewFieldOrIdValue[_]])(implicit c: Connection): List[ProductreviewRow]
  def selectById(productreviewid: ProductreviewId)(implicit c: Connection): Option[ProductreviewRow]
  def selectByIds(productreviewids: Array[ProductreviewId])(implicit c: Connection): List[ProductreviewRow]
  def update(row: ProductreviewRow)(implicit c: Connection): Boolean
  def updateFieldValues(productreviewid: ProductreviewId, fieldValues: List[ProductreviewFieldValue[_]])(implicit c: Connection): Boolean
  def upsert(unsaved: ProductreviewRow)(implicit c: Connection): ProductreviewRow
}
