/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_replication_slots

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgStatReplicationSlotsViewRepo {
  def select: SelectBuilder[PgStatReplicationSlotsViewFields, PgStatReplicationSlotsViewRow]
  def selectAll(implicit c: Connection): List[PgStatReplicationSlotsViewRow]
}
