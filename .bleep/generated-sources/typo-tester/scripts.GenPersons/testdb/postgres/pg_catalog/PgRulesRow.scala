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

case class PgRulesRow(
  schemaname: Option[String],
  tablename: Option[String],
  rulename: Option[String],
  definition: Option[String]
)

object PgRulesRow {
  implicit val rowParser: RowParser[PgRulesRow] = { row =>
    Success(
      PgRulesRow(
        schemaname = row[Option[String]]("schemaname"),
        tablename = row[Option[String]]("tablename"),
        rulename = row[Option[String]]("rulename"),
        definition = row[Option[String]]("definition")
      )
    )
  }

  implicit val oFormat: OFormat[PgRulesRow] = new OFormat[PgRulesRow]{
    override def writes(o: PgRulesRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "tablename" -> o.tablename,
      "rulename" -> o.rulename,
      "definition" -> o.definition
      )

    override def reads(json: JsValue): JsResult[PgRulesRow] = {
      JsResult.fromTry(
        Try(
          PgRulesRow(
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            tablename = json.\("tablename").toOption.map(_.as[String]),
            rulename = json.\("rulename").toOption.map(_.as[String]),
            definition = json.\("definition").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
