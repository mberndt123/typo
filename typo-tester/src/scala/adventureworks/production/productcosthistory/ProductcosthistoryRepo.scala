/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import java.sql.Connection

trait ProductcosthistoryRepo {
  def delete(compositeId: ProductcosthistoryId)(implicit c: Connection): Boolean
  def insert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow
  def insert(unsaved: ProductcosthistoryRowUnsaved)(implicit c: Connection): ProductcosthistoryRow
  def selectAll(implicit c: Connection): List[ProductcosthistoryRow]
  def selectByFieldValues(fieldValues: List[ProductcosthistoryFieldOrIdValue[_]])(implicit c: Connection): List[ProductcosthistoryRow]
  def selectById(compositeId: ProductcosthistoryId)(implicit c: Connection): Option[ProductcosthistoryRow]
  def update(row: ProductcosthistoryRow)(implicit c: Connection): Boolean
  def updateFieldValues(compositeId: ProductcosthistoryId, fieldValues: List[ProductcosthistoryFieldValue[_]])(implicit c: Connection): Boolean
  def upsert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow
}
