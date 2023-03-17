package testdb.pg_catalog

import java.time.LocalDateTime

sealed abstract class PgStatReplicationSlotsFieldValue[T](val name: String, val value: T)

object PgStatReplicationSlotsFieldValue {
  case class slotName(override val value: /* unknown nullability */ Option[String]) extends PgStatReplicationSlotsFieldValue("slot_name", value)
  case class spillTxns(override val value: /* unknown nullability */ Option[Long]) extends PgStatReplicationSlotsFieldValue("spill_txns", value)
  case class spillCount(override val value: /* unknown nullability */ Option[Long]) extends PgStatReplicationSlotsFieldValue("spill_count", value)
  case class spillBytes(override val value: /* unknown nullability */ Option[Long]) extends PgStatReplicationSlotsFieldValue("spill_bytes", value)
  case class streamTxns(override val value: /* unknown nullability */ Option[Long]) extends PgStatReplicationSlotsFieldValue("stream_txns", value)
  case class streamCount(override val value: /* unknown nullability */ Option[Long]) extends PgStatReplicationSlotsFieldValue("stream_count", value)
  case class streamBytes(override val value: /* unknown nullability */ Option[Long]) extends PgStatReplicationSlotsFieldValue("stream_bytes", value)
  case class totalTxns(override val value: /* unknown nullability */ Option[Long]) extends PgStatReplicationSlotsFieldValue("total_txns", value)
  case class totalBytes(override val value: /* unknown nullability */ Option[Long]) extends PgStatReplicationSlotsFieldValue("total_bytes", value)
  case class statsReset(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgStatReplicationSlotsFieldValue("stats_reset", value)
}
