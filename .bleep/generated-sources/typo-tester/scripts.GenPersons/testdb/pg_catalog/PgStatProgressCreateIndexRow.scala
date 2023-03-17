package testdb.pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class PgStatProgressCreateIndexRow(
  pid: /* unknown nullability */ Option[Int],
  datid: /* unknown nullability */ Option[Long],
  /** Points to [[testdb.pg_catalog.PgDatabaseRow.datname]] */
  datname: String,
  relid: /* unknown nullability */ Option[Long],
  indexRelid: /* unknown nullability */ Option[Long],
  command: /* unknown nullability */ Option[String],
  phase: /* unknown nullability */ Option[String],
  lockersTotal: /* unknown nullability */ Option[Long],
  lockersDone: /* unknown nullability */ Option[Long],
  currentLockerPid: /* unknown nullability */ Option[Long],
  blocksTotal: /* unknown nullability */ Option[Long],
  blocksDone: /* unknown nullability */ Option[Long],
  tuplesTotal: /* unknown nullability */ Option[Long],
  tuplesDone: /* unknown nullability */ Option[Long],
  partitionsTotal: /* unknown nullability */ Option[Long],
  partitionsDone: /* unknown nullability */ Option[Long]
)

object PgStatProgressCreateIndexRow {
  implicit val rowParser: RowParser[PgStatProgressCreateIndexRow] = { row =>
    Success(
      PgStatProgressCreateIndexRow(
        pid = row[/* unknown nullability */ Option[Int]]("pid"),
        datid = row[/* unknown nullability */ Option[Long]]("datid"),
        datname = row[String]("datname"),
        relid = row[/* unknown nullability */ Option[Long]]("relid"),
        indexRelid = row[/* unknown nullability */ Option[Long]]("index_relid"),
        command = row[/* unknown nullability */ Option[String]]("command"),
        phase = row[/* unknown nullability */ Option[String]]("phase"),
        lockersTotal = row[/* unknown nullability */ Option[Long]]("lockers_total"),
        lockersDone = row[/* unknown nullability */ Option[Long]]("lockers_done"),
        currentLockerPid = row[/* unknown nullability */ Option[Long]]("current_locker_pid"),
        blocksTotal = row[/* unknown nullability */ Option[Long]]("blocks_total"),
        blocksDone = row[/* unknown nullability */ Option[Long]]("blocks_done"),
        tuplesTotal = row[/* unknown nullability */ Option[Long]]("tuples_total"),
        tuplesDone = row[/* unknown nullability */ Option[Long]]("tuples_done"),
        partitionsTotal = row[/* unknown nullability */ Option[Long]]("partitions_total"),
        partitionsDone = row[/* unknown nullability */ Option[Long]]("partitions_done")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatProgressCreateIndexRow] = Json.format
}
