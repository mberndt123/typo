/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgProcRepo {
  def delete(oid: PgProcId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgProcFields, PgProcRow]
  def insert(unsaved: PgProcRow)(implicit c: Connection): PgProcRow
  def select: SelectBuilder[PgProcFields, PgProcRow]
  def selectAll(implicit c: Connection): List[PgProcRow]
  def selectById(oid: PgProcId)(implicit c: Connection): Option[PgProcRow]
  def selectByIds(oids: Array[PgProcId])(implicit c: Connection): List[PgProcRow]
  def update(row: PgProcRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgProcFields, PgProcRow]
  def upsert(unsaved: PgProcRow)(implicit c: Connection): PgProcRow
}
