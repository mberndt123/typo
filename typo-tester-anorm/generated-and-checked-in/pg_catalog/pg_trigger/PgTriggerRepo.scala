/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_trigger

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgTriggerRepo {
  def delete(oid: PgTriggerId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgTriggerFields, PgTriggerRow]
  def insert(unsaved: PgTriggerRow)(implicit c: Connection): PgTriggerRow
  def select: SelectBuilder[PgTriggerFields, PgTriggerRow]
  def selectAll(implicit c: Connection): List[PgTriggerRow]
  def selectById(oid: PgTriggerId)(implicit c: Connection): Option[PgTriggerRow]
  def selectByIds(oids: Array[PgTriggerId])(implicit c: Connection): List[PgTriggerRow]
  def update(row: PgTriggerRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgTriggerFields, PgTriggerRow]
  def upsert(unsaved: PgTriggerRow)(implicit c: Connection): PgTriggerRow
}
