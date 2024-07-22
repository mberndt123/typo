/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesorderheadersalesreason

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalesorderheadersalesreasonRepo {
  def delete: DeleteBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow]
  def deleteById(compositeId: SalesorderheadersalesreasonId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[SalesorderheadersalesreasonId])(implicit c: Connection): Int
  def insert(unsaved: SalesorderheadersalesreasonRow)(implicit c: Connection): SalesorderheadersalesreasonRow
  def insert(unsaved: SalesorderheadersalesreasonRowUnsaved)(implicit c: Connection): SalesorderheadersalesreasonRow
  def insertStreaming(unsaved: Iterator[SalesorderheadersalesreasonRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[SalesorderheadersalesreasonRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow]
  def selectAll(implicit c: Connection): List[SalesorderheadersalesreasonRow]
  def selectById(compositeId: SalesorderheadersalesreasonId)(implicit c: Connection): Option[SalesorderheadersalesreasonRow]
  def selectByIds(compositeIds: Array[SalesorderheadersalesreasonId])(implicit c: Connection): List[SalesorderheadersalesreasonRow]
  def selectByIdsTracked(compositeIds: Array[SalesorderheadersalesreasonId])(implicit c: Connection): Map[SalesorderheadersalesreasonId, SalesorderheadersalesreasonRow]
  def update: UpdateBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow]
  def update(row: SalesorderheadersalesreasonRow)(implicit c: Connection): Boolean
  def upsert(unsaved: SalesorderheadersalesreasonRow)(implicit c: Connection): SalesorderheadersalesreasonRow
  def upsertBatch(unsaved: Iterable[SalesorderheadersalesreasonRow])(implicit c: Connection): List[SalesorderheadersalesreasonRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[SalesorderheadersalesreasonRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
