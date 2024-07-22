/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productdescription;

import java.sql.Connection;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;

trait ProductdescriptionRepo {
  def delete: DeleteBuilder[ProductdescriptionFields, ProductdescriptionRow]
  def deleteById(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Boolean
  def deleteByIds(productdescriptionids: Array[ProductdescriptionId])(implicit c: Connection): Int
  def insert(unsaved: ProductdescriptionRow)(implicit c: Connection): ProductdescriptionRow
  def insert(unsaved: ProductdescriptionRowUnsaved)(implicit c: Connection): ProductdescriptionRow
  def insertStreaming(unsaved: Iterator[ProductdescriptionRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductdescriptionRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[ProductdescriptionFields, ProductdescriptionRow]
  def selectAll(implicit c: Connection): List[ProductdescriptionRow]
  def selectById(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Option[ProductdescriptionRow]
  def selectByIds(productdescriptionids: Array[ProductdescriptionId])(implicit c: Connection): List[ProductdescriptionRow]
  def selectByIdsTracked(productdescriptionids: Array[ProductdescriptionId])(implicit c: Connection): Map[ProductdescriptionId, ProductdescriptionRow]
  def update: UpdateBuilder[ProductdescriptionFields, ProductdescriptionRow]
  def update(row: ProductdescriptionRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ProductdescriptionRow)(implicit c: Connection): ProductdescriptionRow
  def upsertBatch(unsaved: Iterable[ProductdescriptionRow])(implicit c: Connection): List[ProductdescriptionRow]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ProductdescriptionRow], batchSize: Int = 10000)(implicit c: Connection): Int
}