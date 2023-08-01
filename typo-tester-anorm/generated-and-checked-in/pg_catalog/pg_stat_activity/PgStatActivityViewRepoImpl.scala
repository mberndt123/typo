/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_activity

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatActivityViewRepoImpl extends PgStatActivityViewRepo {
  override def select: SelectBuilder[PgStatActivityViewFields, PgStatActivityViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_activity", PgStatActivityViewFields, PgStatActivityViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatActivityViewRow] = {
    SQL"""select datid, datname, pid, leader_pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start::text, xact_start::text, query_start::text, state_change::text, wait_event_type, wait_event, "state", backend_xid, backend_xmin, query_id, query, backend_type
          from pg_catalog.pg_stat_activity
       """.as(PgStatActivityViewRow.rowParser(1).*)
  }
}
