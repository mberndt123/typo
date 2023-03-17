package testdb.pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class PgStatDatabaseRow(
  datid: /* unknown nullability */ Option[Long],
  datname: /* unknown nullability */ Option[String],
  numbackends: /* unknown nullability */ Option[Int],
  xactCommit: /* unknown nullability */ Option[Long],
  xactRollback: /* unknown nullability */ Option[Long],
  blksRead: /* unknown nullability */ Option[Long],
  blksHit: /* unknown nullability */ Option[Long],
  tupReturned: /* unknown nullability */ Option[Long],
  tupFetched: /* unknown nullability */ Option[Long],
  tupInserted: /* unknown nullability */ Option[Long],
  tupUpdated: /* unknown nullability */ Option[Long],
  tupDeleted: /* unknown nullability */ Option[Long],
  conflicts: /* unknown nullability */ Option[Long],
  tempFiles: /* unknown nullability */ Option[Long],
  tempBytes: /* unknown nullability */ Option[Long],
  deadlocks: /* unknown nullability */ Option[Long],
  checksumFailures: /* unknown nullability */ Option[Long],
  checksumLastFailure: /* unknown nullability */ Option[LocalDateTime],
  blkReadTime: /* unknown nullability */ Option[Double],
  blkWriteTime: /* unknown nullability */ Option[Double],
  sessionTime: /* unknown nullability */ Option[Double],
  activeTime: /* unknown nullability */ Option[Double],
  idleInTransactionTime: /* unknown nullability */ Option[Double],
  sessions: /* unknown nullability */ Option[Long],
  sessionsAbandoned: /* unknown nullability */ Option[Long],
  sessionsFatal: /* unknown nullability */ Option[Long],
  sessionsKilled: /* unknown nullability */ Option[Long],
  statsReset: /* unknown nullability */ Option[LocalDateTime]
)

object PgStatDatabaseRow {
  implicit val rowParser: RowParser[PgStatDatabaseRow] = { row =>
    Success(
      PgStatDatabaseRow(
        datid = row[/* unknown nullability */ Option[Long]]("datid"),
        datname = row[/* unknown nullability */ Option[String]]("datname"),
        numbackends = row[/* unknown nullability */ Option[Int]]("numbackends"),
        xactCommit = row[/* unknown nullability */ Option[Long]]("xact_commit"),
        xactRollback = row[/* unknown nullability */ Option[Long]]("xact_rollback"),
        blksRead = row[/* unknown nullability */ Option[Long]]("blks_read"),
        blksHit = row[/* unknown nullability */ Option[Long]]("blks_hit"),
        tupReturned = row[/* unknown nullability */ Option[Long]]("tup_returned"),
        tupFetched = row[/* unknown nullability */ Option[Long]]("tup_fetched"),
        tupInserted = row[/* unknown nullability */ Option[Long]]("tup_inserted"),
        tupUpdated = row[/* unknown nullability */ Option[Long]]("tup_updated"),
        tupDeleted = row[/* unknown nullability */ Option[Long]]("tup_deleted"),
        conflicts = row[/* unknown nullability */ Option[Long]]("conflicts"),
        tempFiles = row[/* unknown nullability */ Option[Long]]("temp_files"),
        tempBytes = row[/* unknown nullability */ Option[Long]]("temp_bytes"),
        deadlocks = row[/* unknown nullability */ Option[Long]]("deadlocks"),
        checksumFailures = row[/* unknown nullability */ Option[Long]]("checksum_failures"),
        checksumLastFailure = row[/* unknown nullability */ Option[LocalDateTime]]("checksum_last_failure"),
        blkReadTime = row[/* unknown nullability */ Option[Double]]("blk_read_time"),
        blkWriteTime = row[/* unknown nullability */ Option[Double]]("blk_write_time"),
        sessionTime = row[/* unknown nullability */ Option[Double]]("session_time"),
        activeTime = row[/* unknown nullability */ Option[Double]]("active_time"),
        idleInTransactionTime = row[/* unknown nullability */ Option[Double]]("idle_in_transaction_time"),
        sessions = row[/* unknown nullability */ Option[Long]]("sessions"),
        sessionsAbandoned = row[/* unknown nullability */ Option[Long]]("sessions_abandoned"),
        sessionsFatal = row[/* unknown nullability */ Option[Long]]("sessions_fatal"),
        sessionsKilled = row[/* unknown nullability */ Option[Long]]("sessions_killed"),
        statsReset = row[/* unknown nullability */ Option[LocalDateTime]]("stats_reset")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatDatabaseRow] = Json.format
}
