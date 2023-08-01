/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_aggregate

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgAggregateRepo {
  def delete(aggfnoid: PgAggregateId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgAggregateFields, PgAggregateRow]
  def insert(unsaved: PgAggregateRow)(implicit c: Connection): PgAggregateRow
  def select: SelectBuilder[PgAggregateFields, PgAggregateRow]
  def selectAll(implicit c: Connection): List[PgAggregateRow]
  def selectById(aggfnoid: PgAggregateId)(implicit c: Connection): Option[PgAggregateRow]
  def selectByIds(aggfnoids: Array[PgAggregateId])(implicit c: Connection): List[PgAggregateRow]
  def update(row: PgAggregateRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgAggregateFields, PgAggregateRow]
  def upsert(unsaved: PgAggregateRow)(implicit c: Connection): PgAggregateRow
}
