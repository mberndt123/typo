/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait CurrencyrateRepo {
  def delete(currencyrateid: CurrencyrateId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[CurrencyrateFields, CurrencyrateRow]
  def insert(unsaved: CurrencyrateRow)(implicit c: Connection): CurrencyrateRow
  def insertStreaming(unsaved: Iterator[CurrencyrateRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: CurrencyrateRowUnsaved)(implicit c: Connection): CurrencyrateRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[CurrencyrateRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[CurrencyrateFields, CurrencyrateRow]
  def selectAll(implicit c: Connection): List[CurrencyrateRow]
  def selectById(currencyrateid: CurrencyrateId)(implicit c: Connection): Option[CurrencyrateRow]
  def selectByIds(currencyrateids: Array[CurrencyrateId])(implicit c: Connection): List[CurrencyrateRow]
  def update(row: CurrencyrateRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[CurrencyrateFields, CurrencyrateRow]
  def upsert(unsaved: CurrencyrateRow)(implicit c: Connection): CurrencyrateRow
}
