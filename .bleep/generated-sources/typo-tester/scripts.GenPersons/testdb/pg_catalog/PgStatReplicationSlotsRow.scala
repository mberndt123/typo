package testdb.pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class PgStatReplicationSlotsRow(
  slotName: /* unknown nullability */ Option[String],
  spillTxns: /* unknown nullability */ Option[Long],
  spillCount: /* unknown nullability */ Option[Long],
  spillBytes: /* unknown nullability */ Option[Long],
  streamTxns: /* unknown nullability */ Option[Long],
  streamCount: /* unknown nullability */ Option[Long],
  streamBytes: /* unknown nullability */ Option[Long],
  totalTxns: /* unknown nullability */ Option[Long],
  totalBytes: /* unknown nullability */ Option[Long],
  statsReset: /* unknown nullability */ Option[LocalDateTime]
)

object PgStatReplicationSlotsRow {
  implicit val rowParser: RowParser[PgStatReplicationSlotsRow] = { row =>
    Success(
      PgStatReplicationSlotsRow(
        slotName = row[/* unknown nullability */ Option[String]]("slot_name"),
        spillTxns = row[/* unknown nullability */ Option[Long]]("spill_txns"),
        spillCount = row[/* unknown nullability */ Option[Long]]("spill_count"),
        spillBytes = row[/* unknown nullability */ Option[Long]]("spill_bytes"),
        streamTxns = row[/* unknown nullability */ Option[Long]]("stream_txns"),
        streamCount = row[/* unknown nullability */ Option[Long]]("stream_count"),
        streamBytes = row[/* unknown nullability */ Option[Long]]("stream_bytes"),
        totalTxns = row[/* unknown nullability */ Option[Long]]("total_txns"),
        totalBytes = row[/* unknown nullability */ Option[Long]]("total_bytes"),
        statsReset = row[/* unknown nullability */ Option[LocalDateTime]]("stats_reset")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatReplicationSlotsRow] = Json.format
}
