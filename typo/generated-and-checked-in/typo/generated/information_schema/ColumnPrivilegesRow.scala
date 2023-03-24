/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ColumnPrivilegesRow(
  grantor: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"column_privileges","column_name":"grantor","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  grantee: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"column_privileges","column_name":"grantee","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tableCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"column_privileges","column_name":"table_catalog","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tableSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"column_privileges","column_name":"table_schema","ordinal_position":4,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tableName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"column_privileges","column_name":"table_name","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  columnName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"column_privileges","column_name":"column_name","ordinal_position":6,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  privilegeType: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"column_privileges","column_name":"privilege_type","ordinal_position":7,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  isGrantable: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"column_privileges","column_name":"is_grantable","ordinal_position":8,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3,"character_octet_length":12,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"yes_or_no","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object ColumnPrivilegesRow {
  implicit val rowParser: RowParser[ColumnPrivilegesRow] = { row =>
    Success(
      ColumnPrivilegesRow(
        grantor = row[Option[String]]("grantor"),
        grantee = row[Option[String]]("grantee"),
        tableCatalog = row[Option[String]]("table_catalog"),
        tableSchema = row[Option[String]]("table_schema"),
        tableName = row[Option[String]]("table_name"),
        columnName = row[Option[String]]("column_name"),
        privilegeType = row[Option[String]]("privilege_type"),
        isGrantable = row[Option[String]]("is_grantable")
      )
    )
  }

  implicit val oFormat: OFormat[ColumnPrivilegesRow] = new OFormat[ColumnPrivilegesRow]{
    override def writes(o: ColumnPrivilegesRow): JsObject =
      Json.obj(
        "grantor" -> o.grantor,
      "grantee" -> o.grantee,
      "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "column_name" -> o.columnName,
      "privilege_type" -> o.privilegeType,
      "is_grantable" -> o.isGrantable
      )

    override def reads(json: JsValue): JsResult[ColumnPrivilegesRow] = {
      JsResult.fromTry(
        Try(
          ColumnPrivilegesRow(
            grantor = json.\("grantor").toOption.map(_.as[String]),
            grantee = json.\("grantee").toOption.map(_.as[String]),
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            columnName = json.\("column_name").toOption.map(_.as[String]),
            privilegeType = json.\("privilege_type").toOption.map(_.as[String]),
            isGrantable = json.\("is_grantable").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
