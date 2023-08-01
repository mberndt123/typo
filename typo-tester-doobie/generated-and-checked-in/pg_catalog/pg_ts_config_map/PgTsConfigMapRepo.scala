/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_config_map

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgTsConfigMapRepo {
  def delete(compositeId: PgTsConfigMapId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgTsConfigMapFields, PgTsConfigMapRow]
  def insert(unsaved: PgTsConfigMapRow): ConnectionIO[PgTsConfigMapRow]
  def select: SelectBuilder[PgTsConfigMapFields, PgTsConfigMapRow]
  def selectAll: Stream[ConnectionIO, PgTsConfigMapRow]
  def selectById(compositeId: PgTsConfigMapId): ConnectionIO[Option[PgTsConfigMapRow]]
  def update(row: PgTsConfigMapRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgTsConfigMapFields, PgTsConfigMapRow]
  def upsert(unsaved: PgTsConfigMapRow): ConnectionIO[PgTsConfigMapRow]
}
