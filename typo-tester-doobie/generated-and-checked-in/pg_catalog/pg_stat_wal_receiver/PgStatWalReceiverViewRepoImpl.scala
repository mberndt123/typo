/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_wal_receiver

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatWalReceiverViewRepoImpl extends PgStatWalReceiverViewRepo {
  override def select: SelectBuilder[PgStatWalReceiverViewFields, PgStatWalReceiverViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_wal_receiver", PgStatWalReceiverViewFields, PgStatWalReceiverViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatWalReceiverViewRow] = {
    sql"select pid, status, receive_start_lsn, receive_start_tli, written_lsn, flushed_lsn, received_tli, last_msg_send_time::text, last_msg_receipt_time::text, latest_end_lsn, latest_end_time::text, slot_name, sender_host, sender_port, conninfo from pg_catalog.pg_stat_wal_receiver".query(PgStatWalReceiverViewRow.read).stream
  }
}
