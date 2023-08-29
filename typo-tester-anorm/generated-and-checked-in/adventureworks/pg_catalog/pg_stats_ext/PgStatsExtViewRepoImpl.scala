/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats_ext

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatsExtViewRepoImpl extends PgStatsExtViewRepo {
  override def select: SelectBuilder[PgStatsExtViewFields, PgStatsExtViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stats_ext", PgStatsExtViewFields, PgStatsExtViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatsExtViewRow] = {
    SQL"""select "schemaname", "tablename", "statistics_schemaname", "statistics_name", "statistics_owner", "attnames", "exprs", "kinds", "n_distinct", "dependencies", "most_common_vals", "most_common_val_nulls", "most_common_freqs", "most_common_base_freqs"
          from pg_catalog.pg_stats_ext
       """.as(PgStatsExtViewRow.rowParser(1).*)
  }
}
