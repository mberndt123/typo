/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attribute

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgAttributeRepo {
  def delete(compositeId: PgAttributeId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgAttributeFields, PgAttributeRow]
  def insert(unsaved: PgAttributeRow)(implicit c: Connection): PgAttributeRow
  def select: SelectBuilder[PgAttributeFields, PgAttributeRow]
  def selectAll(implicit c: Connection): List[PgAttributeRow]
  def selectById(compositeId: PgAttributeId)(implicit c: Connection): Option[PgAttributeRow]
  def update(row: PgAttributeRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgAttributeFields, PgAttributeRow]
  def upsert(unsaved: PgAttributeRow)(implicit c: Connection): PgAttributeRow
}
