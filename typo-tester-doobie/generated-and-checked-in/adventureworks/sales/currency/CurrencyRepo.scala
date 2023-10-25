/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait CurrencyRepo {
  def delete(currencycode: CurrencyId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[CurrencyFields, CurrencyRow]
  def insert(unsaved: CurrencyRow): ConnectionIO[CurrencyRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, CurrencyRow], batchSize: Int): ConnectionIO[Long]
  def insert(unsaved: CurrencyRowUnsaved): ConnectionIO[CurrencyRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CurrencyRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[CurrencyFields, CurrencyRow]
  def selectAll: Stream[ConnectionIO, CurrencyRow]
  def selectById(currencycode: CurrencyId): ConnectionIO[Option[CurrencyRow]]
  def selectByIds(currencycodes: Array[CurrencyId]): Stream[ConnectionIO, CurrencyRow]
  def update(row: CurrencyRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[CurrencyFields, CurrencyRow]
  def upsert(unsaved: CurrencyRow): ConnectionIO[CurrencyRow]
}
