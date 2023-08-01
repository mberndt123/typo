/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_all_tables

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatXactAllTablesViewRepoImpl extends PgStatXactAllTablesViewRepo {
  override def select: SelectBuilder[PgStatXactAllTablesViewFields, PgStatXactAllTablesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_xact_all_tables", PgStatXactAllTablesViewFields, PgStatXactAllTablesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatXactAllTablesViewRow] = {
    sql"select relid, schemaname, relname, seq_scan, seq_tup_read, idx_scan, idx_tup_fetch, n_tup_ins, n_tup_upd, n_tup_del, n_tup_hot_upd from pg_catalog.pg_stat_xact_all_tables".query(PgStatXactAllTablesViewRow.read).stream
  }
}
