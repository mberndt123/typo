/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_collation

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgCollationRepo {
  def delete(oid: PgCollationId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgCollationFields, PgCollationRow]
  def insert(unsaved: PgCollationRow)(implicit c: Connection): PgCollationRow
  def select: SelectBuilder[PgCollationFields, PgCollationRow]
  def selectAll(implicit c: Connection): List[PgCollationRow]
  def selectById(oid: PgCollationId)(implicit c: Connection): Option[PgCollationRow]
  def selectByIds(oids: Array[PgCollationId])(implicit c: Connection): List[PgCollationRow]
  def update(row: PgCollationRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgCollationFields, PgCollationRow]
  def upsert(unsaved: PgCollationRow)(implicit c: Connection): PgCollationRow
}
