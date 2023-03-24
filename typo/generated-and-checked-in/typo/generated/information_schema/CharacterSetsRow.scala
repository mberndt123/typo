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

case class CharacterSetsRow(
  characterSetCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"character_sets","column_name":"character_set_catalog","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterSetSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"character_sets","column_name":"character_set_schema","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterSetName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"character_sets","column_name":"character_set_name","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterRepertoire: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"character_sets","column_name":"character_repertoire","ordinal_position":4,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  formOfUse: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"character_sets","column_name":"form_of_use","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  defaultCollateCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"character_sets","column_name":"default_collate_catalog","ordinal_position":6,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  defaultCollateSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"character_sets","column_name":"default_collate_schema","ordinal_position":7,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  defaultCollateName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"character_sets","column_name":"default_collate_name","ordinal_position":8,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object CharacterSetsRow {
  implicit val rowParser: RowParser[CharacterSetsRow] = { row =>
    Success(
      CharacterSetsRow(
        characterSetCatalog = row[Option[String]]("character_set_catalog"),
        characterSetSchema = row[Option[String]]("character_set_schema"),
        characterSetName = row[Option[String]]("character_set_name"),
        characterRepertoire = row[Option[String]]("character_repertoire"),
        formOfUse = row[Option[String]]("form_of_use"),
        defaultCollateCatalog = row[Option[String]]("default_collate_catalog"),
        defaultCollateSchema = row[Option[String]]("default_collate_schema"),
        defaultCollateName = row[Option[String]]("default_collate_name")
      )
    )
  }

  implicit val oFormat: OFormat[CharacterSetsRow] = new OFormat[CharacterSetsRow]{
    override def writes(o: CharacterSetsRow): JsObject =
      Json.obj(
        "character_set_catalog" -> o.characterSetCatalog,
      "character_set_schema" -> o.characterSetSchema,
      "character_set_name" -> o.characterSetName,
      "character_repertoire" -> o.characterRepertoire,
      "form_of_use" -> o.formOfUse,
      "default_collate_catalog" -> o.defaultCollateCatalog,
      "default_collate_schema" -> o.defaultCollateSchema,
      "default_collate_name" -> o.defaultCollateName
      )

    override def reads(json: JsValue): JsResult[CharacterSetsRow] = {
      JsResult.fromTry(
        Try(
          CharacterSetsRow(
            characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[String]),
            characterSetSchema = json.\("character_set_schema").toOption.map(_.as[String]),
            characterSetName = json.\("character_set_name").toOption.map(_.as[String]),
            characterRepertoire = json.\("character_repertoire").toOption.map(_.as[String]),
            formOfUse = json.\("form_of_use").toOption.map(_.as[String]),
            defaultCollateCatalog = json.\("default_collate_catalog").toOption.map(_.as[String]),
            defaultCollateSchema = json.\("default_collate_schema").toOption.map(_.as[String]),
            defaultCollateName = json.\("default_collate_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
