package testdb.information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class ColumnsRow(
  tableCatalog: /* unknown nullability */ Option[String],
  tableSchema: /* unknown nullability */ Option[String],
  tableName: /* unknown nullability */ Option[String],
  columnName: /* unknown nullability */ Option[String],
  ordinalPosition: /* unknown nullability */ Option[Int],
  columnDefault: /* unknown nullability */ Option[String],
  isNullable: /* unknown nullability */ Option[String],
  dataType: /* unknown nullability */ Option[String],
  characterMaximumLength: /* unknown nullability */ Option[Int],
  characterOctetLength: /* unknown nullability */ Option[Int],
  numericPrecision: /* unknown nullability */ Option[Int],
  numericPrecisionRadix: /* unknown nullability */ Option[Int],
  numericScale: /* unknown nullability */ Option[Int],
  datetimePrecision: /* unknown nullability */ Option[Int],
  intervalType: /* unknown nullability */ Option[String],
  intervalPrecision: /* unknown nullability */ Option[Int],
  characterSetCatalog: /* unknown nullability */ Option[String],
  characterSetSchema: /* unknown nullability */ Option[String],
  characterSetName: /* unknown nullability */ Option[String],
  collationCatalog: /* unknown nullability */ Option[String],
  collationSchema: /* unknown nullability */ Option[String],
  collationName: /* unknown nullability */ Option[String],
  domainCatalog: /* unknown nullability */ Option[String],
  domainSchema: /* unknown nullability */ Option[String],
  domainName: /* unknown nullability */ Option[String],
  udtCatalog: /* unknown nullability */ Option[String],
  udtSchema: /* unknown nullability */ Option[String],
  udtName: /* unknown nullability */ Option[String],
  scopeCatalog: /* unknown nullability */ Option[String],
  scopeSchema: /* unknown nullability */ Option[String],
  scopeName: /* unknown nullability */ Option[String],
  maximumCardinality: /* unknown nullability */ Option[Int],
  dtdIdentifier: /* unknown nullability */ Option[String],
  isSelfReferencing: /* unknown nullability */ Option[String],
  isIdentity: /* unknown nullability */ Option[String],
  identityGeneration: /* unknown nullability */ Option[String],
  identityStart: /* unknown nullability */ Option[String],
  identityIncrement: /* unknown nullability */ Option[String],
  identityMaximum: /* unknown nullability */ Option[String],
  identityMinimum: /* unknown nullability */ Option[String],
  identityCycle: /* unknown nullability */ Option[String],
  isGenerated: /* unknown nullability */ Option[String],
  generationExpression: /* unknown nullability */ Option[String],
  isUpdatable: /* unknown nullability */ Option[String]
)

object ColumnsRow {
  implicit val rowParser: RowParser[ColumnsRow] = { row =>
    Success(
      ColumnsRow(
        tableCatalog = row[/* unknown nullability */ Option[String]]("table_catalog"),
        tableSchema = row[/* unknown nullability */ Option[String]]("table_schema"),
        tableName = row[/* unknown nullability */ Option[String]]("table_name"),
        columnName = row[/* unknown nullability */ Option[String]]("column_name"),
        ordinalPosition = row[/* unknown nullability */ Option[Int]]("ordinal_position"),
        columnDefault = row[/* unknown nullability */ Option[String]]("column_default"),
        isNullable = row[/* unknown nullability */ Option[String]]("is_nullable"),
        dataType = row[/* unknown nullability */ Option[String]]("data_type"),
        characterMaximumLength = row[/* unknown nullability */ Option[Int]]("character_maximum_length"),
        characterOctetLength = row[/* unknown nullability */ Option[Int]]("character_octet_length"),
        numericPrecision = row[/* unknown nullability */ Option[Int]]("numeric_precision"),
        numericPrecisionRadix = row[/* unknown nullability */ Option[Int]]("numeric_precision_radix"),
        numericScale = row[/* unknown nullability */ Option[Int]]("numeric_scale"),
        datetimePrecision = row[/* unknown nullability */ Option[Int]]("datetime_precision"),
        intervalType = row[/* unknown nullability */ Option[String]]("interval_type"),
        intervalPrecision = row[/* unknown nullability */ Option[Int]]("interval_precision"),
        characterSetCatalog = row[/* unknown nullability */ Option[String]]("character_set_catalog"),
        characterSetSchema = row[/* unknown nullability */ Option[String]]("character_set_schema"),
        characterSetName = row[/* unknown nullability */ Option[String]]("character_set_name"),
        collationCatalog = row[/* unknown nullability */ Option[String]]("collation_catalog"),
        collationSchema = row[/* unknown nullability */ Option[String]]("collation_schema"),
        collationName = row[/* unknown nullability */ Option[String]]("collation_name"),
        domainCatalog = row[/* unknown nullability */ Option[String]]("domain_catalog"),
        domainSchema = row[/* unknown nullability */ Option[String]]("domain_schema"),
        domainName = row[/* unknown nullability */ Option[String]]("domain_name"),
        udtCatalog = row[/* unknown nullability */ Option[String]]("udt_catalog"),
        udtSchema = row[/* unknown nullability */ Option[String]]("udt_schema"),
        udtName = row[/* unknown nullability */ Option[String]]("udt_name"),
        scopeCatalog = row[/* unknown nullability */ Option[String]]("scope_catalog"),
        scopeSchema = row[/* unknown nullability */ Option[String]]("scope_schema"),
        scopeName = row[/* unknown nullability */ Option[String]]("scope_name"),
        maximumCardinality = row[/* unknown nullability */ Option[Int]]("maximum_cardinality"),
        dtdIdentifier = row[/* unknown nullability */ Option[String]]("dtd_identifier"),
        isSelfReferencing = row[/* unknown nullability */ Option[String]]("is_self_referencing"),
        isIdentity = row[/* unknown nullability */ Option[String]]("is_identity"),
        identityGeneration = row[/* unknown nullability */ Option[String]]("identity_generation"),
        identityStart = row[/* unknown nullability */ Option[String]]("identity_start"),
        identityIncrement = row[/* unknown nullability */ Option[String]]("identity_increment"),
        identityMaximum = row[/* unknown nullability */ Option[String]]("identity_maximum"),
        identityMinimum = row[/* unknown nullability */ Option[String]]("identity_minimum"),
        identityCycle = row[/* unknown nullability */ Option[String]]("identity_cycle"),
        isGenerated = row[/* unknown nullability */ Option[String]]("is_generated"),
        generationExpression = row[/* unknown nullability */ Option[String]]("generation_expression"),
        isUpdatable = row[/* unknown nullability */ Option[String]]("is_updatable")
      )
    )
  }

  implicit val oFormat: OFormat[ColumnsRow] = Json.format
}
