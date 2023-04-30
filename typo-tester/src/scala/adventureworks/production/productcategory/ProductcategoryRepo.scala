/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import java.sql.Connection

trait ProductcategoryRepo {
  def delete(productcategoryid: ProductcategoryId)(implicit c: Connection): Boolean
  def insert(unsaved: ProductcategoryRow)(implicit c: Connection): ProductcategoryRow
  def insert(unsaved: ProductcategoryRowUnsaved)(implicit c: Connection): ProductcategoryRow
  def selectAll(implicit c: Connection): List[ProductcategoryRow]
  def selectByFieldValues(fieldValues: List[ProductcategoryFieldOrIdValue[_]])(implicit c: Connection): List[ProductcategoryRow]
  def selectById(productcategoryid: ProductcategoryId)(implicit c: Connection): Option[ProductcategoryRow]
  def selectByIds(productcategoryids: Array[ProductcategoryId])(implicit c: Connection): List[ProductcategoryRow]
  def update(row: ProductcategoryRow)(implicit c: Connection): Boolean
  def updateFieldValues(productcategoryid: ProductcategoryId, fieldValues: List[ProductcategoryFieldValue[_]])(implicit c: Connection): Boolean
  def upsert(unsaved: ProductcategoryRow)(implicit c: Connection): ProductcategoryRow
}
