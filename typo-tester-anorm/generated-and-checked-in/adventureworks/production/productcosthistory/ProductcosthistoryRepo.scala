/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productcosthistory;

import java.sql.Connection;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;

trait ProductcosthistoryRepo {
  def delete: DeleteBuilder[ProductcosthistoryFields, ProductcosthistoryRow]
  def deleteById(compositeId: ProductcosthistoryId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[ProductcosthistoryId])(implicit c: Connection): Int
  def insert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow
  def insert(unsaved: ProductcosthistoryRowUnsaved)(implicit c: Connection): ProductcosthistoryRow
  def insertStreaming(unsaved: Iterator[ProductcosthistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductcosthistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[ProductcosthistoryFields, ProductcosthistoryRow]
  def selectAll(implicit c: Connection): List[ProductcosthistoryRow]
  def selectById(compositeId: ProductcosthistoryId)(implicit c: Connection): Option[ProductcosthistoryRow]
  def selectByIds(compositeIds: Array[ProductcosthistoryId])(implicit c: Connection): List[ProductcosthistoryRow]
  def selectByIdsTracked(compositeIds: Array[ProductcosthistoryId])(implicit c: Connection): Map[ProductcosthistoryId, ProductcosthistoryRow]
  def update: UpdateBuilder[ProductcosthistoryFields, ProductcosthistoryRow]
  def update(row: ProductcosthistoryRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow
  def upsertBatch(unsaved: Iterable[ProductcosthistoryRow])(implicit c: Connection): List[ProductcosthistoryRow]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ProductcosthistoryRow], batchSize: Int = 10000)(implicit c: Connection): Int
}