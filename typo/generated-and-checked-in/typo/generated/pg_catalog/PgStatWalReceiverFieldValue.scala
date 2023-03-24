/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import java.time.ZonedDateTime

sealed abstract class PgStatWalReceiverFieldValue[T](val name: String, val value: T)

object PgStatWalReceiverFieldValue {
  case class pid(override val value: Option[Int]) extends PgStatWalReceiverFieldValue("pid", value)
  case class status(override val value: Option[String]) extends PgStatWalReceiverFieldValue("status", value)
  case class receiveStartLsn(override val value: Option[String]) extends PgStatWalReceiverFieldValue("receive_start_lsn", value)
  case class receiveStartTli(override val value: Option[Int]) extends PgStatWalReceiverFieldValue("receive_start_tli", value)
  case class writtenLsn(override val value: Option[String]) extends PgStatWalReceiverFieldValue("written_lsn", value)
  case class flushedLsn(override val value: Option[String]) extends PgStatWalReceiverFieldValue("flushed_lsn", value)
  case class receivedTli(override val value: Option[Int]) extends PgStatWalReceiverFieldValue("received_tli", value)
  case class lastMsgSendTime(override val value: Option[ZonedDateTime]) extends PgStatWalReceiverFieldValue("last_msg_send_time", value)
  case class lastMsgReceiptTime(override val value: Option[ZonedDateTime]) extends PgStatWalReceiverFieldValue("last_msg_receipt_time", value)
  case class latestEndLsn(override val value: Option[String]) extends PgStatWalReceiverFieldValue("latest_end_lsn", value)
  case class latestEndTime(override val value: Option[ZonedDateTime]) extends PgStatWalReceiverFieldValue("latest_end_time", value)
  case class slotName(override val value: Option[String]) extends PgStatWalReceiverFieldValue("slot_name", value)
  case class senderHost(override val value: Option[String]) extends PgStatWalReceiverFieldValue("sender_host", value)
  case class senderPort(override val value: Option[Int]) extends PgStatWalReceiverFieldValue("sender_port", value)
  case class conninfo(override val value: Option[String]) extends PgStatWalReceiverFieldValue("conninfo", value)
}
