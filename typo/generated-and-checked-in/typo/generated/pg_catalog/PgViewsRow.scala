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

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgViewsRow(
  schemaname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_views","column_name":"schemaname","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  viewname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_views","column_name":"viewname","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  viewowner: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_views","column_name":"viewowner","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  definition: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_views","column_name":"definition","ordinal_position":4,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgViewsRow {
  implicit val rowParser: RowParser[PgViewsRow] = { row =>
    Success(
      PgViewsRow(
        schemaname = row[Option[String]]("schemaname"),
        viewname = row[Option[String]]("viewname"),
        viewowner = row[Option[String]]("viewowner"),
        definition = row[Option[String]]("definition")
      )
    )
  }

  implicit val oFormat: OFormat[PgViewsRow] = new OFormat[PgViewsRow]{
    override def writes(o: PgViewsRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "viewname" -> o.viewname,
      "viewowner" -> o.viewowner,
      "definition" -> o.definition
      )

    override def reads(json: JsValue): JsResult[PgViewsRow] = {
      JsResult.fromTry(
        Try(
          PgViewsRow(
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            viewname = json.\("viewname").toOption.map(_.as[String]),
            viewowner = json.\("viewowner").toOption.map(_.as[String]),
            definition = json.\("definition").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
