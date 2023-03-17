package testdb.pg_catalog

import java.time.LocalDateTime

sealed abstract class PgStatSubscriptionFieldValue[T](val name: String, val value: T)

object PgStatSubscriptionFieldValue {
  case class subid(override val value: Long) extends PgStatSubscriptionFieldValue("subid", value)
  case class subname(override val value: String) extends PgStatSubscriptionFieldValue("subname", value)
  case class pid(override val value: /* unknown nullability */ Option[Int]) extends PgStatSubscriptionFieldValue("pid", value)
  case class relid(override val value: /* unknown nullability */ Option[Long]) extends PgStatSubscriptionFieldValue("relid", value)
  case class receivedLsn(override val value: /* unknown nullability */ Option[/* pg_lsn */ String]) extends PgStatSubscriptionFieldValue("received_lsn", value)
  case class lastMsgSendTime(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgStatSubscriptionFieldValue("last_msg_send_time", value)
  case class lastMsgReceiptTime(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgStatSubscriptionFieldValue("last_msg_receipt_time", value)
  case class latestEndLsn(override val value: /* unknown nullability */ Option[/* pg_lsn */ String]) extends PgStatSubscriptionFieldValue("latest_end_lsn", value)
  case class latestEndTime(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgStatSubscriptionFieldValue("latest_end_time", value)
}
