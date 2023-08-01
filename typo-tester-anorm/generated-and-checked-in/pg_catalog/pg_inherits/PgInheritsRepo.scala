/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_inherits

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgInheritsRepo {
  def delete(compositeId: PgInheritsId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgInheritsFields, PgInheritsRow]
  def insert(unsaved: PgInheritsRow)(implicit c: Connection): PgInheritsRow
  def select: SelectBuilder[PgInheritsFields, PgInheritsRow]
  def selectAll(implicit c: Connection): List[PgInheritsRow]
  def selectById(compositeId: PgInheritsId)(implicit c: Connection): Option[PgInheritsRow]
  def update(row: PgInheritsRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgInheritsFields, PgInheritsRow]
  def upsert(unsaved: PgInheritsRow)(implicit c: Connection): PgInheritsRow
}
