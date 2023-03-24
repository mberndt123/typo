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

case class UdtPrivilegesRow(
  grantor: Option[String],
  grantee: Option[String],
  udtCatalog: Option[String],
  udtSchema: Option[String],
  udtName: Option[String],
  privilegeType: Option[String],
  isGrantable: Option[String]
)

object UdtPrivilegesRow {
  implicit val rowParser: RowParser[UdtPrivilegesRow] = { row =>
    Success(
      UdtPrivilegesRow(
        grantor = row[Option[String]]("grantor"),
        grantee = row[Option[String]]("grantee"),
        udtCatalog = row[Option[String]]("udt_catalog"),
        udtSchema = row[Option[String]]("udt_schema"),
        udtName = row[Option[String]]("udt_name"),
        privilegeType = row[Option[String]]("privilege_type"),
        isGrantable = row[Option[String]]("is_grantable")
      )
    )
  }

  implicit val oFormat: OFormat[UdtPrivilegesRow] = new OFormat[UdtPrivilegesRow]{
    override def writes(o: UdtPrivilegesRow): JsObject =
      Json.obj(
        "grantor" -> o.grantor,
      "grantee" -> o.grantee,
      "udt_catalog" -> o.udtCatalog,
      "udt_schema" -> o.udtSchema,
      "udt_name" -> o.udtName,
      "privilege_type" -> o.privilegeType,
      "is_grantable" -> o.isGrantable
      )

    override def reads(json: JsValue): JsResult[UdtPrivilegesRow] = {
      JsResult.fromTry(
        Try(
          UdtPrivilegesRow(
            grantor = json.\("grantor").toOption.map(_.as[String]),
            grantee = json.\("grantee").toOption.map(_.as[String]),
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[String]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[String]),
            udtName = json.\("udt_name").toOption.map(_.as[String]),
            privilegeType = json.\("privilege_type").toOption.map(_.as[String]),
            isGrantable = json.\("is_grantable").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
