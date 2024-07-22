/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.countryregioncurrency

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait CountryregioncurrencyRepo {
  def delete: DeleteBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow]
  def deleteById(compositeId: CountryregioncurrencyId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[CountryregioncurrencyId]): ConnectionIO[Int]
  def insert(unsaved: CountryregioncurrencyRow): ConnectionIO[CountryregioncurrencyRow]
  def insert(unsaved: CountryregioncurrencyRowUnsaved): ConnectionIO[CountryregioncurrencyRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, CountryregioncurrencyRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CountryregioncurrencyRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow]
  def selectAll: Stream[ConnectionIO, CountryregioncurrencyRow]
  def selectById(compositeId: CountryregioncurrencyId): ConnectionIO[Option[CountryregioncurrencyRow]]
  def selectByIds(compositeIds: Array[CountryregioncurrencyId]): Stream[ConnectionIO, CountryregioncurrencyRow]
  def selectByIdsTracked(compositeIds: Array[CountryregioncurrencyId]): ConnectionIO[Map[CountryregioncurrencyId, CountryregioncurrencyRow]]
  def update: UpdateBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow]
  def update(row: CountryregioncurrencyRow): ConnectionIO[Boolean]
  def upsert(unsaved: CountryregioncurrencyRow): ConnectionIO[CountryregioncurrencyRow]
  def upsertBatch(unsaved: List[CountryregioncurrencyRow]): Stream[ConnectionIO, CountryregioncurrencyRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, CountryregioncurrencyRow], batchSize: Int = 10000): ConnectionIO[Int]
}
