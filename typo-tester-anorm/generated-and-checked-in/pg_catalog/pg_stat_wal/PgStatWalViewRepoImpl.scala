/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_wal

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatWalViewRepoImpl extends PgStatWalViewRepo {
  override def select: SelectBuilder[PgStatWalViewFields, PgStatWalViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_wal", PgStatWalViewFields, PgStatWalViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatWalViewRow] = {
    SQL"""select wal_records, wal_fpi, wal_bytes, wal_buffers_full, wal_write, wal_sync, wal_write_time, wal_sync_time, stats_reset::text
          from pg_catalog.pg_stat_wal
       """.as(PgStatWalViewRow.rowParser(1).*)
  }
}
