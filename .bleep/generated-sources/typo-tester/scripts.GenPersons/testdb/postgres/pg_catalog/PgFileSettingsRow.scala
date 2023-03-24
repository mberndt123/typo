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
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgFileSettingsRow(
  sourcefile: Option[String],
  sourceline: Option[Int],
  seqno: Option[Int],
  name: Option[String],
  setting: Option[String],
  applied: Option[Boolean],
  error: Option[String]
)

object PgFileSettingsRow {
  implicit val rowParser: RowParser[PgFileSettingsRow] = { row =>
    Success(
      PgFileSettingsRow(
        sourcefile = row[Option[String]]("sourcefile"),
        sourceline = row[Option[Int]]("sourceline"),
        seqno = row[Option[Int]]("seqno"),
        name = row[Option[String]]("name"),
        setting = row[Option[String]]("setting"),
        applied = row[Option[Boolean]]("applied"),
        error = row[Option[String]]("error")
      )
    )
  }

  implicit val oFormat: OFormat[PgFileSettingsRow] = new OFormat[PgFileSettingsRow]{
    override def writes(o: PgFileSettingsRow): JsObject =
      Json.obj(
        "sourcefile" -> o.sourcefile,
      "sourceline" -> o.sourceline,
      "seqno" -> o.seqno,
      "name" -> o.name,
      "setting" -> o.setting,
      "applied" -> o.applied,
      "error" -> o.error
      )

    override def reads(json: JsValue): JsResult[PgFileSettingsRow] = {
      JsResult.fromTry(
        Try(
          PgFileSettingsRow(
            sourcefile = json.\("sourcefile").toOption.map(_.as[String]),
            sourceline = json.\("sourceline").toOption.map(_.as[Int]),
            seqno = json.\("seqno").toOption.map(_.as[Int]),
            name = json.\("name").toOption.map(_.as[String]),
            setting = json.\("setting").toOption.map(_.as[String]),
            applied = json.\("applied").toOption.map(_.as[Boolean]),
            error = json.\("error").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
