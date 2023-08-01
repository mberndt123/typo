/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shseclabel

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgShseclabelRepo {
  def delete(compositeId: PgShseclabelId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgShseclabelFields, PgShseclabelRow]
  def insert(unsaved: PgShseclabelRow)(implicit c: Connection): PgShseclabelRow
  def select: SelectBuilder[PgShseclabelFields, PgShseclabelRow]
  def selectAll(implicit c: Connection): List[PgShseclabelRow]
  def selectById(compositeId: PgShseclabelId)(implicit c: Connection): Option[PgShseclabelRow]
  def update(row: PgShseclabelRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgShseclabelFields, PgShseclabelRow]
  def upsert(unsaved: PgShseclabelRow)(implicit c: Connection): PgShseclabelRow
}
