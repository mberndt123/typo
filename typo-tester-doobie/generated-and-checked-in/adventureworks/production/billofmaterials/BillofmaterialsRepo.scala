/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.billofmaterials;

import doobie.free.connection.ConnectionIO;
import fs2.Stream;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;

trait BillofmaterialsRepo {
  def delete: DeleteBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def deleteById(billofmaterialsid: Int): ConnectionIO[Boolean]
  def deleteByIds(billofmaterialsids: Array[Int]): ConnectionIO[Int]
  def insert(unsaved: BillofmaterialsRow): ConnectionIO[BillofmaterialsRow]
  def insert(unsaved: BillofmaterialsRowUnsaved): ConnectionIO[BillofmaterialsRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, BillofmaterialsRow], batchSize: Int = 10000): ConnectionIO[Long]
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, BillofmaterialsRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def selectAll: Stream[ConnectionIO, BillofmaterialsRow]
  def selectById(billofmaterialsid: Int): ConnectionIO[Option[BillofmaterialsRow]]
  def selectByIds(billofmaterialsids: Array[Int]): Stream[ConnectionIO, BillofmaterialsRow]
  def selectByIdsTracked(billofmaterialsids: Array[Int]): ConnectionIO[Map[Int, BillofmaterialsRow]]
  def update: UpdateBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def update(row: BillofmaterialsRow): ConnectionIO[Boolean]
  def upsert(unsaved: BillofmaterialsRow): ConnectionIO[BillofmaterialsRow]
  def upsertBatch(unsaved: List[BillofmaterialsRow]): Stream[ConnectionIO, BillofmaterialsRow]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, BillofmaterialsRow], batchSize: Int = 10000): ConnectionIO[Int]
}