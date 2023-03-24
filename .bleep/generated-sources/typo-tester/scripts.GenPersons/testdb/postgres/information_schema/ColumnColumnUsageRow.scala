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

case class ColumnColumnUsageRow(
  tableCatalog: Option[String],
  tableSchema: Option[String],
  tableName: Option[String],
  columnName: Option[String],
  dependentColumn: Option[String]
)

object ColumnColumnUsageRow {
  implicit val rowParser: RowParser[ColumnColumnUsageRow] = { row =>
    Success(
      ColumnColumnUsageRow(
        tableCatalog = row[Option[String]]("table_catalog"),
        tableSchema = row[Option[String]]("table_schema"),
        tableName = row[Option[String]]("table_name"),
        columnName = row[Option[String]]("column_name"),
        dependentColumn = row[Option[String]]("dependent_column")
      )
    )
  }

  implicit val oFormat: OFormat[ColumnColumnUsageRow] = new OFormat[ColumnColumnUsageRow]{
    override def writes(o: ColumnColumnUsageRow): JsObject =
      Json.obj(
        "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "column_name" -> o.columnName,
      "dependent_column" -> o.dependentColumn
      )

    override def reads(json: JsValue): JsResult[ColumnColumnUsageRow] = {
      JsResult.fromTry(
        Try(
          ColumnColumnUsageRow(
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            columnName = json.\("column_name").toOption.map(_.as[String]),
            dependentColumn = json.\("dependent_column").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
