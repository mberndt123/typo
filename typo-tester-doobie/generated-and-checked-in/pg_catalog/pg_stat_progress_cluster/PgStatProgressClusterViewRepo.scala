/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_cluster

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgStatProgressClusterViewRepo {
  def select: SelectBuilder[PgStatProgressClusterViewFields, PgStatProgressClusterViewRow]
  def selectAll: Stream[ConnectionIO, PgStatProgressClusterViewRow]
}
