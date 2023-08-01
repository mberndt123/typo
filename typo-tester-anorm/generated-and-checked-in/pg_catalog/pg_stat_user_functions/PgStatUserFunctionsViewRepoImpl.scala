/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_functions

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatUserFunctionsViewRepoImpl extends PgStatUserFunctionsViewRepo {
  override def select: SelectBuilder[PgStatUserFunctionsViewFields, PgStatUserFunctionsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_user_functions", PgStatUserFunctionsViewFields, PgStatUserFunctionsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatUserFunctionsViewRow] = {
    SQL"""select funcid, schemaname, funcname, calls, total_time, self_time
          from pg_catalog.pg_stat_user_functions
       """.as(PgStatUserFunctionsViewRow.rowParser(1).*)
  }
}
