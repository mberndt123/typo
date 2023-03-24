/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.ZonedDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatDatabaseRow(
  datid: Option[Long],
  datname: Option[String],
  numbackends: Option[Int],
  xactCommit: Option[Long],
  xactRollback: Option[Long],
  blksRead: Option[Long],
  blksHit: Option[Long],
  tupReturned: Option[Long],
  tupFetched: Option[Long],
  tupInserted: Option[Long],
  tupUpdated: Option[Long],
  tupDeleted: Option[Long],
  conflicts: Option[Long],
  tempFiles: Option[Long],
  tempBytes: Option[Long],
  deadlocks: Option[Long],
  checksumFailures: Option[Long],
  checksumLastFailure: Option[ZonedDateTime],
  blkReadTime: Option[Double],
  blkWriteTime: Option[Double],
  sessionTime: Option[Double],
  activeTime: Option[Double],
  idleInTransactionTime: Option[Double],
  sessions: Option[Long],
  sessionsAbandoned: Option[Long],
  sessionsFatal: Option[Long],
  sessionsKilled: Option[Long],
  statsReset: Option[ZonedDateTime]
)

object PgStatDatabaseRow {
  implicit val rowParser: RowParser[PgStatDatabaseRow] = { row =>
    Success(
      PgStatDatabaseRow(
        datid = row[Option[Long]]("datid"),
        datname = row[Option[String]]("datname"),
        numbackends = row[Option[Int]]("numbackends"),
        xactCommit = row[Option[Long]]("xact_commit"),
        xactRollback = row[Option[Long]]("xact_rollback"),
        blksRead = row[Option[Long]]("blks_read"),
        blksHit = row[Option[Long]]("blks_hit"),
        tupReturned = row[Option[Long]]("tup_returned"),
        tupFetched = row[Option[Long]]("tup_fetched"),
        tupInserted = row[Option[Long]]("tup_inserted"),
        tupUpdated = row[Option[Long]]("tup_updated"),
        tupDeleted = row[Option[Long]]("tup_deleted"),
        conflicts = row[Option[Long]]("conflicts"),
        tempFiles = row[Option[Long]]("temp_files"),
        tempBytes = row[Option[Long]]("temp_bytes"),
        deadlocks = row[Option[Long]]("deadlocks"),
        checksumFailures = row[Option[Long]]("checksum_failures"),
        checksumLastFailure = row[Option[ZonedDateTime]]("checksum_last_failure"),
        blkReadTime = row[Option[Double]]("blk_read_time"),
        blkWriteTime = row[Option[Double]]("blk_write_time"),
        sessionTime = row[Option[Double]]("session_time"),
        activeTime = row[Option[Double]]("active_time"),
        idleInTransactionTime = row[Option[Double]]("idle_in_transaction_time"),
        sessions = row[Option[Long]]("sessions"),
        sessionsAbandoned = row[Option[Long]]("sessions_abandoned"),
        sessionsFatal = row[Option[Long]]("sessions_fatal"),
        sessionsKilled = row[Option[Long]]("sessions_killed"),
        statsReset = row[Option[ZonedDateTime]]("stats_reset")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatDatabaseRow] = new OFormat[PgStatDatabaseRow]{
    override def writes(o: PgStatDatabaseRow): JsObject =
      Json.obj(
        "datid" -> o.datid,
      "datname" -> o.datname,
      "numbackends" -> o.numbackends,
      "xact_commit" -> o.xactCommit,
      "xact_rollback" -> o.xactRollback,
      "blks_read" -> o.blksRead,
      "blks_hit" -> o.blksHit,
      "tup_returned" -> o.tupReturned,
      "tup_fetched" -> o.tupFetched,
      "tup_inserted" -> o.tupInserted,
      "tup_updated" -> o.tupUpdated,
      "tup_deleted" -> o.tupDeleted,
      "conflicts" -> o.conflicts,
      "temp_files" -> o.tempFiles,
      "temp_bytes" -> o.tempBytes,
      "deadlocks" -> o.deadlocks,
      "checksum_failures" -> o.checksumFailures,
      "checksum_last_failure" -> o.checksumLastFailure,
      "blk_read_time" -> o.blkReadTime,
      "blk_write_time" -> o.blkWriteTime,
      "session_time" -> o.sessionTime,
      "active_time" -> o.activeTime,
      "idle_in_transaction_time" -> o.idleInTransactionTime,
      "sessions" -> o.sessions,
      "sessions_abandoned" -> o.sessionsAbandoned,
      "sessions_fatal" -> o.sessionsFatal,
      "sessions_killed" -> o.sessionsKilled,
      "stats_reset" -> o.statsReset
      )

    override def reads(json: JsValue): JsResult[PgStatDatabaseRow] = {
      JsResult.fromTry(
        Try(
          PgStatDatabaseRow(
            datid = json.\("datid").toOption.map(_.as[Long]),
            datname = json.\("datname").toOption.map(_.as[String]),
            numbackends = json.\("numbackends").toOption.map(_.as[Int]),
            xactCommit = json.\("xact_commit").toOption.map(_.as[Long]),
            xactRollback = json.\("xact_rollback").toOption.map(_.as[Long]),
            blksRead = json.\("blks_read").toOption.map(_.as[Long]),
            blksHit = json.\("blks_hit").toOption.map(_.as[Long]),
            tupReturned = json.\("tup_returned").toOption.map(_.as[Long]),
            tupFetched = json.\("tup_fetched").toOption.map(_.as[Long]),
            tupInserted = json.\("tup_inserted").toOption.map(_.as[Long]),
            tupUpdated = json.\("tup_updated").toOption.map(_.as[Long]),
            tupDeleted = json.\("tup_deleted").toOption.map(_.as[Long]),
            conflicts = json.\("conflicts").toOption.map(_.as[Long]),
            tempFiles = json.\("temp_files").toOption.map(_.as[Long]),
            tempBytes = json.\("temp_bytes").toOption.map(_.as[Long]),
            deadlocks = json.\("deadlocks").toOption.map(_.as[Long]),
            checksumFailures = json.\("checksum_failures").toOption.map(_.as[Long]),
            checksumLastFailure = json.\("checksum_last_failure").toOption.map(_.as[ZonedDateTime]),
            blkReadTime = json.\("blk_read_time").toOption.map(_.as[Double]),
            blkWriteTime = json.\("blk_write_time").toOption.map(_.as[Double]),
            sessionTime = json.\("session_time").toOption.map(_.as[Double]),
            activeTime = json.\("active_time").toOption.map(_.as[Double]),
            idleInTransactionTime = json.\("idle_in_transaction_time").toOption.map(_.as[Double]),
            sessions = json.\("sessions").toOption.map(_.as[Long]),
            sessionsAbandoned = json.\("sessions_abandoned").toOption.map(_.as[Long]),
            sessionsFatal = json.\("sessions_fatal").toOption.map(_.as[Long]),
            sessionsKilled = json.\("sessions_killed").toOption.map(_.as[Long]),
            statsReset = json.\("stats_reset").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}
