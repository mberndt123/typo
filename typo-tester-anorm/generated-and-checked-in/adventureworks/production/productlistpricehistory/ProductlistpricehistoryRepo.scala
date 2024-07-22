/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productlistpricehistory;

import java.sql.Connection;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;

trait ProductlistpricehistoryRepo {
  def delete: DeleteBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow]
  def deleteById(compositeId: ProductlistpricehistoryId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): Int
  def insert(unsaved: ProductlistpricehistoryRow)(implicit c: Connection): ProductlistpricehistoryRow
  def insert(unsaved: ProductlistpricehistoryRowUnsaved)(implicit c: Connection): ProductlistpricehistoryRow
  def insertStreaming(unsaved: Iterator[ProductlistpricehistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductlistpricehistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow]
  def selectAll(implicit c: Connection): List[ProductlistpricehistoryRow]
  def selectById(compositeId: ProductlistpricehistoryId)(implicit c: Connection): Option[ProductlistpricehistoryRow]
  def selectByIds(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): List[ProductlistpricehistoryRow]
  def selectByIdsTracked(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): Map[ProductlistpricehistoryId, ProductlistpricehistoryRow]
  def update: UpdateBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow]
  def update(row: ProductlistpricehistoryRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ProductlistpricehistoryRow)(implicit c: Connection): ProductlistpricehistoryRow
  def upsertBatch(unsaved: Iterable[ProductlistpricehistoryRow])(implicit c: Connection): List[ProductlistpricehistoryRow]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ProductlistpricehistoryRow], batchSize: Int = 10000)(implicit c: Connection): Int
}