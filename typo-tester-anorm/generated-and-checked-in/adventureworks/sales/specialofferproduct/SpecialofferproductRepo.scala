/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.specialofferproduct;

import java.sql.Connection;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;

trait SpecialofferproductRepo {
  def delete: DeleteBuilder[SpecialofferproductFields, SpecialofferproductRow]
  def deleteById(compositeId: SpecialofferproductId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[SpecialofferproductId])(implicit c: Connection): Int
  def insert(unsaved: SpecialofferproductRow)(implicit c: Connection): SpecialofferproductRow
  def insert(unsaved: SpecialofferproductRowUnsaved)(implicit c: Connection): SpecialofferproductRow
  def insertStreaming(unsaved: Iterator[SpecialofferproductRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[SpecialofferproductRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[SpecialofferproductFields, SpecialofferproductRow]
  def selectAll(implicit c: Connection): List[SpecialofferproductRow]
  def selectById(compositeId: SpecialofferproductId)(implicit c: Connection): Option[SpecialofferproductRow]
  def selectByIds(compositeIds: Array[SpecialofferproductId])(implicit c: Connection): List[SpecialofferproductRow]
  def selectByIdsTracked(compositeIds: Array[SpecialofferproductId])(implicit c: Connection): Map[SpecialofferproductId, SpecialofferproductRow]
  def update: UpdateBuilder[SpecialofferproductFields, SpecialofferproductRow]
  def update(row: SpecialofferproductRow)(implicit c: Connection): Boolean
  def upsert(unsaved: SpecialofferproductRow)(implicit c: Connection): SpecialofferproductRow
  def upsertBatch(unsaved: Iterable[SpecialofferproductRow])(implicit c: Connection): List[SpecialofferproductRow]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[SpecialofferproductRow], batchSize: Int = 10000)(implicit c: Connection): Int
}