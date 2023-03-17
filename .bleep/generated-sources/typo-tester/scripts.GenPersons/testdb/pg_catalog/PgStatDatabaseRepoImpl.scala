package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatDatabaseRepoImpl extends PgStatDatabaseRepo {
  override def selectAll(implicit c: Connection): List[PgStatDatabaseRow] = {
    SQL"""select datid, datname, numbackends, xact_commit, xact_rollback, blks_read, blks_hit, tup_returned, tup_fetched, tup_inserted, tup_updated, tup_deleted, conflicts, temp_files, temp_bytes, deadlocks, checksum_failures, checksum_last_failure, blk_read_time, blk_write_time, session_time, active_time, idle_in_transaction_time, sessions, sessions_abandoned, sessions_fatal, sessions_killed, stats_reset from pg_catalog.pg_stat_database""".as(PgStatDatabaseRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatDatabaseFieldValue[_]])(implicit c: Connection): List[PgStatDatabaseRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatDatabaseFieldValue.datid(value) => NamedParameter("datid", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.datname(value) => NamedParameter("datname", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.numbackends(value) => NamedParameter("numbackends", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.xactCommit(value) => NamedParameter("xact_commit", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.xactRollback(value) => NamedParameter("xact_rollback", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.blksRead(value) => NamedParameter("blks_read", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.blksHit(value) => NamedParameter("blks_hit", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.tupReturned(value) => NamedParameter("tup_returned", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.tupFetched(value) => NamedParameter("tup_fetched", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.tupInserted(value) => NamedParameter("tup_inserted", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.tupUpdated(value) => NamedParameter("tup_updated", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.tupDeleted(value) => NamedParameter("tup_deleted", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.conflicts(value) => NamedParameter("conflicts", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.tempFiles(value) => NamedParameter("temp_files", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.tempBytes(value) => NamedParameter("temp_bytes", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.deadlocks(value) => NamedParameter("deadlocks", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.checksumFailures(value) => NamedParameter("checksum_failures", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.checksumLastFailure(value) => NamedParameter("checksum_last_failure", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.blkReadTime(value) => NamedParameter("blk_read_time", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.blkWriteTime(value) => NamedParameter("blk_write_time", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.sessionTime(value) => NamedParameter("session_time", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.activeTime(value) => NamedParameter("active_time", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.idleInTransactionTime(value) => NamedParameter("idle_in_transaction_time", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.sessions(value) => NamedParameter("sessions", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.sessionsAbandoned(value) => NamedParameter("sessions_abandoned", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.sessionsFatal(value) => NamedParameter("sessions_fatal", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.sessionsKilled(value) => NamedParameter("sessions_killed", ParameterValue.from(value))
          case PgStatDatabaseFieldValue.statsReset(value) => NamedParameter("stats_reset", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_database where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatDatabaseRow.rowParser.*)
    }

  }
}
