/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_config_map

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgTsConfigMapRepo {
  def delete(compositeId: PgTsConfigMapId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgTsConfigMapFields, PgTsConfigMapRow]
  def insert(unsaved: PgTsConfigMapRow)(implicit c: Connection): PgTsConfigMapRow
  def select: SelectBuilder[PgTsConfigMapFields, PgTsConfigMapRow]
  def selectAll(implicit c: Connection): List[PgTsConfigMapRow]
  def selectById(compositeId: PgTsConfigMapId)(implicit c: Connection): Option[PgTsConfigMapRow]
  def update(row: PgTsConfigMapRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgTsConfigMapFields, PgTsConfigMapRow]
  def upsert(unsaved: PgTsConfigMapRow)(implicit c: Connection): PgTsConfigMapRow
}
