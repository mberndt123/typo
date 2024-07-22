/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.shoppingcartitem;

import java.sql.Connection;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;

trait ShoppingcartitemRepo {
  def delete: DeleteBuilder[ShoppingcartitemFields, ShoppingcartitemRow]
  def deleteById(shoppingcartitemid: ShoppingcartitemId)(implicit c: Connection): Boolean
  def deleteByIds(shoppingcartitemids: Array[ShoppingcartitemId])(implicit c: Connection): Int
  def insert(unsaved: ShoppingcartitemRow)(implicit c: Connection): ShoppingcartitemRow
  def insert(unsaved: ShoppingcartitemRowUnsaved)(implicit c: Connection): ShoppingcartitemRow
  def insertStreaming(unsaved: Iterator[ShoppingcartitemRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ShoppingcartitemRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[ShoppingcartitemFields, ShoppingcartitemRow]
  def selectAll(implicit c: Connection): List[ShoppingcartitemRow]
  def selectById(shoppingcartitemid: ShoppingcartitemId)(implicit c: Connection): Option[ShoppingcartitemRow]
  def selectByIds(shoppingcartitemids: Array[ShoppingcartitemId])(implicit c: Connection): List[ShoppingcartitemRow]
  def selectByIdsTracked(shoppingcartitemids: Array[ShoppingcartitemId])(implicit c: Connection): Map[ShoppingcartitemId, ShoppingcartitemRow]
  def update: UpdateBuilder[ShoppingcartitemFields, ShoppingcartitemRow]
  def update(row: ShoppingcartitemRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ShoppingcartitemRow)(implicit c: Connection): ShoppingcartitemRow
  def upsertBatch(unsaved: Iterable[ShoppingcartitemRow])(implicit c: Connection): List[ShoppingcartitemRow]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ShoppingcartitemRow], batchSize: Int = 10000)(implicit c: Connection): Int
}