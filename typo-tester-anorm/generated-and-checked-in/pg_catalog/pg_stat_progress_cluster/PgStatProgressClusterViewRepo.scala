/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_cluster

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgStatProgressClusterViewRepo {
  def select: SelectBuilder[PgStatProgressClusterViewFields, PgStatProgressClusterViewRow]
  def selectAll(implicit c: Connection): List[PgStatProgressClusterViewRow]
}
