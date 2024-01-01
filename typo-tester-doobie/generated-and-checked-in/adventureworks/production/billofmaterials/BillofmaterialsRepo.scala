/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait BillofmaterialsRepo {
  def delete(billofmaterialsid: Int): ConnectionIO[Boolean]
  def delete: DeleteBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def insert(unsaved: BillofmaterialsRow): ConnectionIO[BillofmaterialsRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, BillofmaterialsRow], batchSize: Int): ConnectionIO[Long]
  def insert(unsaved: BillofmaterialsRowUnsaved): ConnectionIO[BillofmaterialsRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, BillofmaterialsRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def selectAll: Stream[ConnectionIO, BillofmaterialsRow]
  def selectById(billofmaterialsid: Int): ConnectionIO[Option[BillofmaterialsRow]]
  def selectByIds(billofmaterialsids: Array[Int]): Stream[ConnectionIO, BillofmaterialsRow]
  def update(row: BillofmaterialsRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[BillofmaterialsFields, BillofmaterialsRow]
  def upsert(unsaved: BillofmaterialsRow): ConnectionIO[BillofmaterialsRow]
}
