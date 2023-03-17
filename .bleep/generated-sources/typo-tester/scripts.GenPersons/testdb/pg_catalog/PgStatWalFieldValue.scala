package testdb.pg_catalog

import java.time.LocalDateTime
import scala.math.BigDecimal

sealed abstract class PgStatWalFieldValue[T](val name: String, val value: T)

object PgStatWalFieldValue {
  case class walRecords(override val value: /* unknown nullability */ Option[Long]) extends PgStatWalFieldValue("wal_records", value)
  case class walFpi(override val value: /* unknown nullability */ Option[Long]) extends PgStatWalFieldValue("wal_fpi", value)
  case class walBytes(override val value: /* unknown nullability */ Option[BigDecimal]) extends PgStatWalFieldValue("wal_bytes", value)
  case class walBuffersFull(override val value: /* unknown nullability */ Option[Long]) extends PgStatWalFieldValue("wal_buffers_full", value)
  case class walWrite(override val value: /* unknown nullability */ Option[Long]) extends PgStatWalFieldValue("wal_write", value)
  case class walSync(override val value: /* unknown nullability */ Option[Long]) extends PgStatWalFieldValue("wal_sync", value)
  case class walWriteTime(override val value: /* unknown nullability */ Option[Double]) extends PgStatWalFieldValue("wal_write_time", value)
  case class walSyncTime(override val value: /* unknown nullability */ Option[Double]) extends PgStatWalFieldValue("wal_sync_time", value)
  case class statsReset(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgStatWalFieldValue("stats_reset", value)
}
