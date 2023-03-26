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

case class PgStatSubscriptionRow(
  subid: Option[/* oid */ Long],
  subname: Option[String],
  pid: Option[Int],
  relid: Option[/* oid */ Long],
  receivedLsn: Option[/* pg_lsn */ Long],
  lastMsgSendTime: Option[ZonedDateTime],
  lastMsgReceiptTime: Option[ZonedDateTime],
  latestEndLsn: Option[/* pg_lsn */ Long],
  latestEndTime: Option[ZonedDateTime]
)

object PgStatSubscriptionRow {
  def rowParser(prefix: String): RowParser[PgStatSubscriptionRow] = { row =>
    Success(
      PgStatSubscriptionRow(
        subid = row[Option[/* oid */ Long]](prefix + "subid"),
        subname = row[Option[String]](prefix + "subname"),
        pid = row[Option[Int]](prefix + "pid"),
        relid = row[Option[/* oid */ Long]](prefix + "relid"),
        receivedLsn = row[Option[/* pg_lsn */ Long]](prefix + "received_lsn"),
        lastMsgSendTime = row[Option[ZonedDateTime]](prefix + "last_msg_send_time"),
        lastMsgReceiptTime = row[Option[ZonedDateTime]](prefix + "last_msg_receipt_time"),
        latestEndLsn = row[Option[/* pg_lsn */ Long]](prefix + "latest_end_lsn"),
        latestEndTime = row[Option[ZonedDateTime]](prefix + "latest_end_time")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatSubscriptionRow] = new OFormat[PgStatSubscriptionRow]{
    override def writes(o: PgStatSubscriptionRow): JsObject =
      Json.obj(
        "subid" -> o.subid,
      "subname" -> o.subname,
      "pid" -> o.pid,
      "relid" -> o.relid,
      "received_lsn" -> o.receivedLsn,
      "last_msg_send_time" -> o.lastMsgSendTime,
      "last_msg_receipt_time" -> o.lastMsgReceiptTime,
      "latest_end_lsn" -> o.latestEndLsn,
      "latest_end_time" -> o.latestEndTime
      )

    override def reads(json: JsValue): JsResult[PgStatSubscriptionRow] = {
      JsResult.fromTry(
        Try(
          PgStatSubscriptionRow(
            subid = json.\("subid").toOption.map(_.as[/* oid */ Long]),
            subname = json.\("subname").toOption.map(_.as[String]),
            pid = json.\("pid").toOption.map(_.as[Int]),
            relid = json.\("relid").toOption.map(_.as[/* oid */ Long]),
            receivedLsn = json.\("received_lsn").toOption.map(_.as[/* pg_lsn */ Long]),
            lastMsgSendTime = json.\("last_msg_send_time").toOption.map(_.as[ZonedDateTime]),
            lastMsgReceiptTime = json.\("last_msg_receipt_time").toOption.map(_.as[ZonedDateTime]),
            latestEndLsn = json.\("latest_end_lsn").toOption.map(_.as[/* pg_lsn */ Long]),
            latestEndTime = json.\("latest_end_time").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}
