/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shadow

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgShadowViewRepo {
  def select: SelectBuilder[PgShadowViewFields, PgShadowViewRow]
  def selectAll(implicit c: Connection): List[PgShadowViewRow]
}
