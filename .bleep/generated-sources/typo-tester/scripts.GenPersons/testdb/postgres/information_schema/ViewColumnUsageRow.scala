/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ViewColumnUsageRow(
  viewCatalog: Option[String],
  viewSchema: Option[String],
  viewName: Option[String],
  tableCatalog: Option[String],
  tableSchema: Option[String],
  tableName: Option[String],
  columnName: Option[String]
)

object ViewColumnUsageRow {
  implicit val rowParser: RowParser[ViewColumnUsageRow] = { row =>
    Success(
      ViewColumnUsageRow(
        viewCatalog = row[Option[String]]("view_catalog"),
        viewSchema = row[Option[String]]("view_schema"),
        viewName = row[Option[String]]("view_name"),
        tableCatalog = row[Option[String]]("table_catalog"),
        tableSchema = row[Option[String]]("table_schema"),
        tableName = row[Option[String]]("table_name"),
        columnName = row[Option[String]]("column_name")
      )
    )
  }

  implicit val oFormat: OFormat[ViewColumnUsageRow] = new OFormat[ViewColumnUsageRow]{
    override def writes(o: ViewColumnUsageRow): JsObject =
      Json.obj(
        "view_catalog" -> o.viewCatalog,
      "view_schema" -> o.viewSchema,
      "view_name" -> o.viewName,
      "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "column_name" -> o.columnName
      )

    override def reads(json: JsValue): JsResult[ViewColumnUsageRow] = {
      JsResult.fromTry(
        Try(
          ViewColumnUsageRow(
            viewCatalog = json.\("view_catalog").toOption.map(_.as[String]),
            viewSchema = json.\("view_schema").toOption.map(_.as[String]),
            viewName = json.\("view_name").toOption.map(_.as[String]),
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            columnName = json.\("column_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
