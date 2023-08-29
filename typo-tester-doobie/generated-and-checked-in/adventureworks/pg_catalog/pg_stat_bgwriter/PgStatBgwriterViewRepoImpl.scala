/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_bgwriter

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatBgwriterViewRepoImpl extends PgStatBgwriterViewRepo {
  override def select: SelectBuilder[PgStatBgwriterViewFields, PgStatBgwriterViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_bgwriter", PgStatBgwriterViewFields, PgStatBgwriterViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatBgwriterViewRow] = {
    sql"""select "checkpoints_timed", "checkpoints_req", "checkpoint_write_time", "checkpoint_sync_time", "buffers_checkpoint", "buffers_clean", "maxwritten_clean", "buffers_backend", "buffers_backend_fsync", "buffers_alloc", "stats_reset"::text from pg_catalog.pg_stat_bgwriter""".query(PgStatBgwriterViewRow.read).stream
  }
}
