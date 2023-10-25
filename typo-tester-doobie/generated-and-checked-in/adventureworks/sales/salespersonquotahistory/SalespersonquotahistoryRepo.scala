/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalespersonquotahistoryRepo {
  def delete(compositeId: SalespersonquotahistoryId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow]
  def insert(unsaved: SalespersonquotahistoryRow): ConnectionIO[SalespersonquotahistoryRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, SalespersonquotahistoryRow], batchSize: Int): ConnectionIO[Long]
  def insert(unsaved: SalespersonquotahistoryRowUnsaved): ConnectionIO[SalespersonquotahistoryRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalespersonquotahistoryRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow]
  def selectAll: Stream[ConnectionIO, SalespersonquotahistoryRow]
  def selectById(compositeId: SalespersonquotahistoryId): ConnectionIO[Option[SalespersonquotahistoryRow]]
  def update(row: SalespersonquotahistoryRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow]
  def upsert(unsaved: SalespersonquotahistoryRow): ConnectionIO[SalespersonquotahistoryRow]
}
