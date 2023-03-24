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

case class PgPublicationTablesRow(
  pubname: Option[String],
  schemaname: Option[String],
  tablename: Option[String]
)

object PgPublicationTablesRow {
  implicit val rowParser: RowParser[PgPublicationTablesRow] = { row =>
    Success(
      PgPublicationTablesRow(
        pubname = row[Option[String]]("pubname"),
        schemaname = row[Option[String]]("schemaname"),
        tablename = row[Option[String]]("tablename")
      )
    )
  }

  implicit val oFormat: OFormat[PgPublicationTablesRow] = new OFormat[PgPublicationTablesRow]{
    override def writes(o: PgPublicationTablesRow): JsObject =
      Json.obj(
        "pubname" -> o.pubname,
      "schemaname" -> o.schemaname,
      "tablename" -> o.tablename
      )

    override def reads(json: JsValue): JsResult[PgPublicationTablesRow] = {
      JsResult.fromTry(
        Try(
          PgPublicationTablesRow(
            pubname = json.\("pubname").toOption.map(_.as[String]),
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            tablename = json.\("tablename").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
