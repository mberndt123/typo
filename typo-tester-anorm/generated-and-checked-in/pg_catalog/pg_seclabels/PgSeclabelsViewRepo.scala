/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabels

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgSeclabelsViewRepo {
  def select: SelectBuilder[PgSeclabelsViewFields, PgSeclabelsViewRow]
  def selectAll(implicit c: Connection): List[PgSeclabelsViewRow]
}
