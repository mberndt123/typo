/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats_ext_exprs

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgStatsExtExprsViewRepo {
  def select: SelectBuilder[PgStatsExtExprsViewFields, PgStatsExtExprsViewRow]
  def selectAll(implicit c: Connection): List[PgStatsExtExprsViewRow]
}
