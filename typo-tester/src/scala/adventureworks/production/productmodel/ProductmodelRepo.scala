/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import java.sql.Connection

trait ProductmodelRepo {
  def delete(productmodelid: ProductmodelId)(implicit c: Connection): Boolean
  def insert(unsaved: ProductmodelRow)(implicit c: Connection): ProductmodelRow
  def insert(unsaved: ProductmodelRowUnsaved)(implicit c: Connection): ProductmodelRow
  def selectAll(implicit c: Connection): List[ProductmodelRow]
  def selectByFieldValues(fieldValues: List[ProductmodelFieldOrIdValue[_]])(implicit c: Connection): List[ProductmodelRow]
  def selectById(productmodelid: ProductmodelId)(implicit c: Connection): Option[ProductmodelRow]
  def selectByIds(productmodelids: Array[ProductmodelId])(implicit c: Connection): List[ProductmodelRow]
  def update(row: ProductmodelRow)(implicit c: Connection): Boolean
  def updateFieldValues(productmodelid: ProductmodelId, fieldValues: List[ProductmodelFieldValue[_]])(implicit c: Connection): Boolean
  def upsert(unsaved: ProductmodelRow)(implicit c: Connection): ProductmodelRow
}
