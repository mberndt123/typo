/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesperson;

import adventureworks.person.businessentity.BusinessentityId;
import doobie.free.connection.ConnectionIO;
import fs2.Stream;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;

trait SalespersonRepo {
  def delete: DeleteBuilder[SalespersonFields, SalespersonRow]
  def deleteById(businessentityid: BusinessentityId): ConnectionIO[Boolean]
  def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int]
  def insert(unsaved: SalespersonRow): ConnectionIO[SalespersonRow]
  def insert(unsaved: SalespersonRowUnsaved): ConnectionIO[SalespersonRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, SalespersonRow], batchSize: Int = 10000): ConnectionIO[Long]
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalespersonRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[SalespersonFields, SalespersonRow]
  def selectAll: Stream[ConnectionIO, SalespersonRow]
  def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[SalespersonRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, SalespersonRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ConnectionIO[Map[BusinessentityId, SalespersonRow]]
  def update: UpdateBuilder[SalespersonFields, SalespersonRow]
  def update(row: SalespersonRow): ConnectionIO[Boolean]
  def upsert(unsaved: SalespersonRow): ConnectionIO[SalespersonRow]
  def upsertBatch(unsaved: List[SalespersonRow]): Stream[ConnectionIO, SalespersonRow]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, SalespersonRow], batchSize: Int = 10000): ConnectionIO[Int]
}