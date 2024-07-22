/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salestaxrate

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalestaxrateRepo {
  def delete: DeleteBuilder[SalestaxrateFields, SalestaxrateRow]
  def deleteById(salestaxrateid: SalestaxrateId): ConnectionIO[Boolean]
  def deleteByIds(salestaxrateids: Array[SalestaxrateId]): ConnectionIO[Int]
  def insert(unsaved: SalestaxrateRow): ConnectionIO[SalestaxrateRow]
  def insert(unsaved: SalestaxrateRowUnsaved): ConnectionIO[SalestaxrateRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, SalestaxrateRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalestaxrateRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[SalestaxrateFields, SalestaxrateRow]
  def selectAll: Stream[ConnectionIO, SalestaxrateRow]
  def selectById(salestaxrateid: SalestaxrateId): ConnectionIO[Option[SalestaxrateRow]]
  def selectByIds(salestaxrateids: Array[SalestaxrateId]): Stream[ConnectionIO, SalestaxrateRow]
  def selectByIdsTracked(salestaxrateids: Array[SalestaxrateId]): ConnectionIO[Map[SalestaxrateId, SalestaxrateRow]]
  def update: UpdateBuilder[SalestaxrateFields, SalestaxrateRow]
  def update(row: SalestaxrateRow): ConnectionIO[Boolean]
  def upsert(unsaved: SalestaxrateRow): ConnectionIO[SalestaxrateRow]
  def upsertBatch(unsaved: List[SalestaxrateRow]): Stream[ConnectionIO, SalestaxrateRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, SalestaxrateRow], batchSize: Int = 10000): ConnectionIO[Int]
}
