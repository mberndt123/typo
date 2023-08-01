/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_subscription

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatSubscriptionViewRepoImpl extends PgStatSubscriptionViewRepo {
  override def select: SelectBuilder[PgStatSubscriptionViewFields, PgStatSubscriptionViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_subscription", PgStatSubscriptionViewFields, PgStatSubscriptionViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatSubscriptionViewRow] = {
    sql"select subid, subname, pid, relid, received_lsn, last_msg_send_time::text, last_msg_receipt_time::text, latest_end_lsn, latest_end_time::text from pg_catalog.pg_stat_subscription".query(PgStatSubscriptionViewRow.read).stream
  }
}
