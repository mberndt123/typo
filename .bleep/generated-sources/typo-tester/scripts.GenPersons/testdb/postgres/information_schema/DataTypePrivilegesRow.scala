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

case class DataTypePrivilegesRow(
  objectCatalog: Option[String],
  objectSchema: Option[String],
  objectName: Option[String],
  objectType: Option[String],
  dtdIdentifier: Option[String]
)

object DataTypePrivilegesRow {
  implicit val rowParser: RowParser[DataTypePrivilegesRow] = { row =>
    Success(
      DataTypePrivilegesRow(
        objectCatalog = row[Option[String]]("object_catalog"),
        objectSchema = row[Option[String]]("object_schema"),
        objectName = row[Option[String]]("object_name"),
        objectType = row[Option[String]]("object_type"),
        dtdIdentifier = row[Option[String]]("dtd_identifier")
      )
    )
  }

  implicit val oFormat: OFormat[DataTypePrivilegesRow] = new OFormat[DataTypePrivilegesRow]{
    override def writes(o: DataTypePrivilegesRow): JsObject =
      Json.obj(
        "object_catalog" -> o.objectCatalog,
      "object_schema" -> o.objectSchema,
      "object_name" -> o.objectName,
      "object_type" -> o.objectType,
      "dtd_identifier" -> o.dtdIdentifier
      )

    override def reads(json: JsValue): JsResult[DataTypePrivilegesRow] = {
      JsResult.fromTry(
        Try(
          DataTypePrivilegesRow(
            objectCatalog = json.\("object_catalog").toOption.map(_.as[String]),
            objectSchema = json.\("object_schema").toOption.map(_.as[String]),
            objectName = json.\("object_name").toOption.map(_.as[String]),
            objectType = json.\("object_type").toOption.map(_.as[String]),
            dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
