/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgStatisticRepo {
  def delete(compositeId: PgStatisticId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgStatisticFields, PgStatisticRow]
  def insert(unsaved: PgStatisticRow): ConnectionIO[PgStatisticRow]
  def select: SelectBuilder[PgStatisticFields, PgStatisticRow]
  def selectAll: Stream[ConnectionIO, PgStatisticRow]
  def selectById(compositeId: PgStatisticId): ConnectionIO[Option[PgStatisticRow]]
  def update(row: PgStatisticRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgStatisticFields, PgStatisticRow]
  def upsert(unsaved: PgStatisticRow): ConnectionIO[PgStatisticRow]
}
