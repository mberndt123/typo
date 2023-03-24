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
import java.time.ZonedDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class RoutinesRow(
  specificCatalog: Option[String],
  specificSchema: Option[String],
  specificName: Option[String],
  routineCatalog: Option[String],
  routineSchema: Option[String],
  routineName: Option[String],
  routineType: Option[String],
  moduleCatalog: Option[String],
  moduleSchema: Option[String],
  moduleName: Option[String],
  udtCatalog: Option[String],
  udtSchema: Option[String],
  udtName: Option[String],
  dataType: Option[String],
  characterMaximumLength: Option[Int],
  characterOctetLength: Option[Int],
  characterSetCatalog: Option[String],
  characterSetSchema: Option[String],
  characterSetName: Option[String],
  collationCatalog: Option[String],
  collationSchema: Option[String],
  collationName: Option[String],
  numericPrecision: Option[Int],
  numericPrecisionRadix: Option[Int],
  numericScale: Option[Int],
  datetimePrecision: Option[Int],
  intervalType: Option[String],
  intervalPrecision: Option[Int],
  typeUdtCatalog: Option[String],
  typeUdtSchema: Option[String],
  typeUdtName: Option[String],
  scopeCatalog: Option[String],
  scopeSchema: Option[String],
  scopeName: Option[String],
  maximumCardinality: Option[Int],
  dtdIdentifier: Option[String],
  routineBody: Option[String],
  routineDefinition: Option[String],
  externalName: Option[String],
  externalLanguage: Option[String],
  parameterStyle: Option[String],
  isDeterministic: Option[String],
  sqlDataAccess: Option[String],
  isNullCall: Option[String],
  sqlPath: Option[String],
  schemaLevelRoutine: Option[String],
  maxDynamicResultSets: Option[Int],
  isUserDefinedCast: Option[String],
  isImplicitlyInvocable: Option[String],
  securityType: Option[String],
  toSqlSpecificCatalog: Option[String],
  toSqlSpecificSchema: Option[String],
  toSqlSpecificName: Option[String],
  asLocator: Option[String],
  created: Option[ZonedDateTime],
  lastAltered: Option[ZonedDateTime],
  newSavepointLevel: Option[String],
  isUdtDependent: Option[String],
  resultCastFromDataType: Option[String],
  resultCastAsLocator: Option[String],
  resultCastCharMaxLength: Option[Int],
  resultCastCharOctetLength: Option[Int],
  resultCastCharSetCatalog: Option[String],
  resultCastCharSetSchema: Option[String],
  resultCastCharSetName: Option[String],
  resultCastCollationCatalog: Option[String],
  resultCastCollationSchema: Option[String],
  resultCastCollationName: Option[String],
  resultCastNumericPrecision: Option[Int],
  resultCastNumericPrecisionRadix: Option[Int],
  resultCastNumericScale: Option[Int],
  resultCastDatetimePrecision: Option[Int],
  resultCastIntervalType: Option[String],
  resultCastIntervalPrecision: Option[Int],
  resultCastTypeUdtCatalog: Option[String],
  resultCastTypeUdtSchema: Option[String],
  resultCastTypeUdtName: Option[String],
  resultCastScopeCatalog: Option[String],
  resultCastScopeSchema: Option[String],
  resultCastScopeName: Option[String],
  resultCastMaximumCardinality: Option[Int],
  resultCastDtdIdentifier: Option[String]
)

object RoutinesRow {
  implicit val rowParser: RowParser[RoutinesRow] = { row =>
    Success(
      RoutinesRow(
        specificCatalog = row[Option[String]]("specific_catalog"),
        specificSchema = row[Option[String]]("specific_schema"),
        specificName = row[Option[String]]("specific_name"),
        routineCatalog = row[Option[String]]("routine_catalog"),
        routineSchema = row[Option[String]]("routine_schema"),
        routineName = row[Option[String]]("routine_name"),
        routineType = row[Option[String]]("routine_type"),
        moduleCatalog = row[Option[String]]("module_catalog"),
        moduleSchema = row[Option[String]]("module_schema"),
        moduleName = row[Option[String]]("module_name"),
        udtCatalog = row[Option[String]]("udt_catalog"),
        udtSchema = row[Option[String]]("udt_schema"),
        udtName = row[Option[String]]("udt_name"),
        dataType = row[Option[String]]("data_type"),
        characterMaximumLength = row[Option[Int]]("character_maximum_length"),
        characterOctetLength = row[Option[Int]]("character_octet_length"),
        characterSetCatalog = row[Option[String]]("character_set_catalog"),
        characterSetSchema = row[Option[String]]("character_set_schema"),
        characterSetName = row[Option[String]]("character_set_name"),
        collationCatalog = row[Option[String]]("collation_catalog"),
        collationSchema = row[Option[String]]("collation_schema"),
        collationName = row[Option[String]]("collation_name"),
        numericPrecision = row[Option[Int]]("numeric_precision"),
        numericPrecisionRadix = row[Option[Int]]("numeric_precision_radix"),
        numericScale = row[Option[Int]]("numeric_scale"),
        datetimePrecision = row[Option[Int]]("datetime_precision"),
        intervalType = row[Option[String]]("interval_type"),
        intervalPrecision = row[Option[Int]]("interval_precision"),
        typeUdtCatalog = row[Option[String]]("type_udt_catalog"),
        typeUdtSchema = row[Option[String]]("type_udt_schema"),
        typeUdtName = row[Option[String]]("type_udt_name"),
        scopeCatalog = row[Option[String]]("scope_catalog"),
        scopeSchema = row[Option[String]]("scope_schema"),
        scopeName = row[Option[String]]("scope_name"),
        maximumCardinality = row[Option[Int]]("maximum_cardinality"),
        dtdIdentifier = row[Option[String]]("dtd_identifier"),
        routineBody = row[Option[String]]("routine_body"),
        routineDefinition = row[Option[String]]("routine_definition"),
        externalName = row[Option[String]]("external_name"),
        externalLanguage = row[Option[String]]("external_language"),
        parameterStyle = row[Option[String]]("parameter_style"),
        isDeterministic = row[Option[String]]("is_deterministic"),
        sqlDataAccess = row[Option[String]]("sql_data_access"),
        isNullCall = row[Option[String]]("is_null_call"),
        sqlPath = row[Option[String]]("sql_path"),
        schemaLevelRoutine = row[Option[String]]("schema_level_routine"),
        maxDynamicResultSets = row[Option[Int]]("max_dynamic_result_sets"),
        isUserDefinedCast = row[Option[String]]("is_user_defined_cast"),
        isImplicitlyInvocable = row[Option[String]]("is_implicitly_invocable"),
        securityType = row[Option[String]]("security_type"),
        toSqlSpecificCatalog = row[Option[String]]("to_sql_specific_catalog"),
        toSqlSpecificSchema = row[Option[String]]("to_sql_specific_schema"),
        toSqlSpecificName = row[Option[String]]("to_sql_specific_name"),
        asLocator = row[Option[String]]("as_locator"),
        created = row[Option[ZonedDateTime]]("created"),
        lastAltered = row[Option[ZonedDateTime]]("last_altered"),
        newSavepointLevel = row[Option[String]]("new_savepoint_level"),
        isUdtDependent = row[Option[String]]("is_udt_dependent"),
        resultCastFromDataType = row[Option[String]]("result_cast_from_data_type"),
        resultCastAsLocator = row[Option[String]]("result_cast_as_locator"),
        resultCastCharMaxLength = row[Option[Int]]("result_cast_char_max_length"),
        resultCastCharOctetLength = row[Option[Int]]("result_cast_char_octet_length"),
        resultCastCharSetCatalog = row[Option[String]]("result_cast_char_set_catalog"),
        resultCastCharSetSchema = row[Option[String]]("result_cast_char_set_schema"),
        resultCastCharSetName = row[Option[String]]("result_cast_char_set_name"),
        resultCastCollationCatalog = row[Option[String]]("result_cast_collation_catalog"),
        resultCastCollationSchema = row[Option[String]]("result_cast_collation_schema"),
        resultCastCollationName = row[Option[String]]("result_cast_collation_name"),
        resultCastNumericPrecision = row[Option[Int]]("result_cast_numeric_precision"),
        resultCastNumericPrecisionRadix = row[Option[Int]]("result_cast_numeric_precision_radix"),
        resultCastNumericScale = row[Option[Int]]("result_cast_numeric_scale"),
        resultCastDatetimePrecision = row[Option[Int]]("result_cast_datetime_precision"),
        resultCastIntervalType = row[Option[String]]("result_cast_interval_type"),
        resultCastIntervalPrecision = row[Option[Int]]("result_cast_interval_precision"),
        resultCastTypeUdtCatalog = row[Option[String]]("result_cast_type_udt_catalog"),
        resultCastTypeUdtSchema = row[Option[String]]("result_cast_type_udt_schema"),
        resultCastTypeUdtName = row[Option[String]]("result_cast_type_udt_name"),
        resultCastScopeCatalog = row[Option[String]]("result_cast_scope_catalog"),
        resultCastScopeSchema = row[Option[String]]("result_cast_scope_schema"),
        resultCastScopeName = row[Option[String]]("result_cast_scope_name"),
        resultCastMaximumCardinality = row[Option[Int]]("result_cast_maximum_cardinality"),
        resultCastDtdIdentifier = row[Option[String]]("result_cast_dtd_identifier")
      )
    )
  }

  implicit val oFormat: OFormat[RoutinesRow] = new OFormat[RoutinesRow]{
    override def writes(o: RoutinesRow): JsObject =
      Json.obj(
        "specific_catalog" -> o.specificCatalog,
      "specific_schema" -> o.specificSchema,
      "specific_name" -> o.specificName,
      "routine_catalog" -> o.routineCatalog,
      "routine_schema" -> o.routineSchema,
      "routine_name" -> o.routineName,
      "routine_type" -> o.routineType,
      "module_catalog" -> o.moduleCatalog,
      "module_schema" -> o.moduleSchema,
      "module_name" -> o.moduleName,
      "udt_catalog" -> o.udtCatalog,
      "udt_schema" -> o.udtSchema,
      "udt_name" -> o.udtName,
      "data_type" -> o.dataType,
      "character_maximum_length" -> o.characterMaximumLength,
      "character_octet_length" -> o.characterOctetLength,
      "character_set_catalog" -> o.characterSetCatalog,
      "character_set_schema" -> o.characterSetSchema,
      "character_set_name" -> o.characterSetName,
      "collation_catalog" -> o.collationCatalog,
      "collation_schema" -> o.collationSchema,
      "collation_name" -> o.collationName,
      "numeric_precision" -> o.numericPrecision,
      "numeric_precision_radix" -> o.numericPrecisionRadix,
      "numeric_scale" -> o.numericScale,
      "datetime_precision" -> o.datetimePrecision,
      "interval_type" -> o.intervalType,
      "interval_precision" -> o.intervalPrecision,
      "type_udt_catalog" -> o.typeUdtCatalog,
      "type_udt_schema" -> o.typeUdtSchema,
      "type_udt_name" -> o.typeUdtName,
      "scope_catalog" -> o.scopeCatalog,
      "scope_schema" -> o.scopeSchema,
      "scope_name" -> o.scopeName,
      "maximum_cardinality" -> o.maximumCardinality,
      "dtd_identifier" -> o.dtdIdentifier,
      "routine_body" -> o.routineBody,
      "routine_definition" -> o.routineDefinition,
      "external_name" -> o.externalName,
      "external_language" -> o.externalLanguage,
      "parameter_style" -> o.parameterStyle,
      "is_deterministic" -> o.isDeterministic,
      "sql_data_access" -> o.sqlDataAccess,
      "is_null_call" -> o.isNullCall,
      "sql_path" -> o.sqlPath,
      "schema_level_routine" -> o.schemaLevelRoutine,
      "max_dynamic_result_sets" -> o.maxDynamicResultSets,
      "is_user_defined_cast" -> o.isUserDefinedCast,
      "is_implicitly_invocable" -> o.isImplicitlyInvocable,
      "security_type" -> o.securityType,
      "to_sql_specific_catalog" -> o.toSqlSpecificCatalog,
      "to_sql_specific_schema" -> o.toSqlSpecificSchema,
      "to_sql_specific_name" -> o.toSqlSpecificName,
      "as_locator" -> o.asLocator,
      "created" -> o.created,
      "last_altered" -> o.lastAltered,
      "new_savepoint_level" -> o.newSavepointLevel,
      "is_udt_dependent" -> o.isUdtDependent,
      "result_cast_from_data_type" -> o.resultCastFromDataType,
      "result_cast_as_locator" -> o.resultCastAsLocator,
      "result_cast_char_max_length" -> o.resultCastCharMaxLength,
      "result_cast_char_octet_length" -> o.resultCastCharOctetLength,
      "result_cast_char_set_catalog" -> o.resultCastCharSetCatalog,
      "result_cast_char_set_schema" -> o.resultCastCharSetSchema,
      "result_cast_char_set_name" -> o.resultCastCharSetName,
      "result_cast_collation_catalog" -> o.resultCastCollationCatalog,
      "result_cast_collation_schema" -> o.resultCastCollationSchema,
      "result_cast_collation_name" -> o.resultCastCollationName,
      "result_cast_numeric_precision" -> o.resultCastNumericPrecision,
      "result_cast_numeric_precision_radix" -> o.resultCastNumericPrecisionRadix,
      "result_cast_numeric_scale" -> o.resultCastNumericScale,
      "result_cast_datetime_precision" -> o.resultCastDatetimePrecision,
      "result_cast_interval_type" -> o.resultCastIntervalType,
      "result_cast_interval_precision" -> o.resultCastIntervalPrecision,
      "result_cast_type_udt_catalog" -> o.resultCastTypeUdtCatalog,
      "result_cast_type_udt_schema" -> o.resultCastTypeUdtSchema,
      "result_cast_type_udt_name" -> o.resultCastTypeUdtName,
      "result_cast_scope_catalog" -> o.resultCastScopeCatalog,
      "result_cast_scope_schema" -> o.resultCastScopeSchema,
      "result_cast_scope_name" -> o.resultCastScopeName,
      "result_cast_maximum_cardinality" -> o.resultCastMaximumCardinality,
      "result_cast_dtd_identifier" -> o.resultCastDtdIdentifier
      )

    override def reads(json: JsValue): JsResult[RoutinesRow] = {
      JsResult.fromTry(
        Try(
          RoutinesRow(
            specificCatalog = json.\("specific_catalog").toOption.map(_.as[String]),
            specificSchema = json.\("specific_schema").toOption.map(_.as[String]),
            specificName = json.\("specific_name").toOption.map(_.as[String]),
            routineCatalog = json.\("routine_catalog").toOption.map(_.as[String]),
            routineSchema = json.\("routine_schema").toOption.map(_.as[String]),
            routineName = json.\("routine_name").toOption.map(_.as[String]),
            routineType = json.\("routine_type").toOption.map(_.as[String]),
            moduleCatalog = json.\("module_catalog").toOption.map(_.as[String]),
            moduleSchema = json.\("module_schema").toOption.map(_.as[String]),
            moduleName = json.\("module_name").toOption.map(_.as[String]),
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[String]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[String]),
            udtName = json.\("udt_name").toOption.map(_.as[String]),
            dataType = json.\("data_type").toOption.map(_.as[String]),
            characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as[Int]),
            characterOctetLength = json.\("character_octet_length").toOption.map(_.as[Int]),
            characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[String]),
            characterSetSchema = json.\("character_set_schema").toOption.map(_.as[String]),
            characterSetName = json.\("character_set_name").toOption.map(_.as[String]),
            collationCatalog = json.\("collation_catalog").toOption.map(_.as[String]),
            collationSchema = json.\("collation_schema").toOption.map(_.as[String]),
            collationName = json.\("collation_name").toOption.map(_.as[String]),
            numericPrecision = json.\("numeric_precision").toOption.map(_.as[Int]),
            numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as[Int]),
            numericScale = json.\("numeric_scale").toOption.map(_.as[Int]),
            datetimePrecision = json.\("datetime_precision").toOption.map(_.as[Int]),
            intervalType = json.\("interval_type").toOption.map(_.as[String]),
            intervalPrecision = json.\("interval_precision").toOption.map(_.as[Int]),
            typeUdtCatalog = json.\("type_udt_catalog").toOption.map(_.as[String]),
            typeUdtSchema = json.\("type_udt_schema").toOption.map(_.as[String]),
            typeUdtName = json.\("type_udt_name").toOption.map(_.as[String]),
            scopeCatalog = json.\("scope_catalog").toOption.map(_.as[String]),
            scopeSchema = json.\("scope_schema").toOption.map(_.as[String]),
            scopeName = json.\("scope_name").toOption.map(_.as[String]),
            maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as[Int]),
            dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[String]),
            routineBody = json.\("routine_body").toOption.map(_.as[String]),
            routineDefinition = json.\("routine_definition").toOption.map(_.as[String]),
            externalName = json.\("external_name").toOption.map(_.as[String]),
            externalLanguage = json.\("external_language").toOption.map(_.as[String]),
            parameterStyle = json.\("parameter_style").toOption.map(_.as[String]),
            isDeterministic = json.\("is_deterministic").toOption.map(_.as[String]),
            sqlDataAccess = json.\("sql_data_access").toOption.map(_.as[String]),
            isNullCall = json.\("is_null_call").toOption.map(_.as[String]),
            sqlPath = json.\("sql_path").toOption.map(_.as[String]),
            schemaLevelRoutine = json.\("schema_level_routine").toOption.map(_.as[String]),
            maxDynamicResultSets = json.\("max_dynamic_result_sets").toOption.map(_.as[Int]),
            isUserDefinedCast = json.\("is_user_defined_cast").toOption.map(_.as[String]),
            isImplicitlyInvocable = json.\("is_implicitly_invocable").toOption.map(_.as[String]),
            securityType = json.\("security_type").toOption.map(_.as[String]),
            toSqlSpecificCatalog = json.\("to_sql_specific_catalog").toOption.map(_.as[String]),
            toSqlSpecificSchema = json.\("to_sql_specific_schema").toOption.map(_.as[String]),
            toSqlSpecificName = json.\("to_sql_specific_name").toOption.map(_.as[String]),
            asLocator = json.\("as_locator").toOption.map(_.as[String]),
            created = json.\("created").toOption.map(_.as[ZonedDateTime]),
            lastAltered = json.\("last_altered").toOption.map(_.as[ZonedDateTime]),
            newSavepointLevel = json.\("new_savepoint_level").toOption.map(_.as[String]),
            isUdtDependent = json.\("is_udt_dependent").toOption.map(_.as[String]),
            resultCastFromDataType = json.\("result_cast_from_data_type").toOption.map(_.as[String]),
            resultCastAsLocator = json.\("result_cast_as_locator").toOption.map(_.as[String]),
            resultCastCharMaxLength = json.\("result_cast_char_max_length").toOption.map(_.as[Int]),
            resultCastCharOctetLength = json.\("result_cast_char_octet_length").toOption.map(_.as[Int]),
            resultCastCharSetCatalog = json.\("result_cast_char_set_catalog").toOption.map(_.as[String]),
            resultCastCharSetSchema = json.\("result_cast_char_set_schema").toOption.map(_.as[String]),
            resultCastCharSetName = json.\("result_cast_char_set_name").toOption.map(_.as[String]),
            resultCastCollationCatalog = json.\("result_cast_collation_catalog").toOption.map(_.as[String]),
            resultCastCollationSchema = json.\("result_cast_collation_schema").toOption.map(_.as[String]),
            resultCastCollationName = json.\("result_cast_collation_name").toOption.map(_.as[String]),
            resultCastNumericPrecision = json.\("result_cast_numeric_precision").toOption.map(_.as[Int]),
            resultCastNumericPrecisionRadix = json.\("result_cast_numeric_precision_radix").toOption.map(_.as[Int]),
            resultCastNumericScale = json.\("result_cast_numeric_scale").toOption.map(_.as[Int]),
            resultCastDatetimePrecision = json.\("result_cast_datetime_precision").toOption.map(_.as[Int]),
            resultCastIntervalType = json.\("result_cast_interval_type").toOption.map(_.as[String]),
            resultCastIntervalPrecision = json.\("result_cast_interval_precision").toOption.map(_.as[Int]),
            resultCastTypeUdtCatalog = json.\("result_cast_type_udt_catalog").toOption.map(_.as[String]),
            resultCastTypeUdtSchema = json.\("result_cast_type_udt_schema").toOption.map(_.as[String]),
            resultCastTypeUdtName = json.\("result_cast_type_udt_name").toOption.map(_.as[String]),
            resultCastScopeCatalog = json.\("result_cast_scope_catalog").toOption.map(_.as[String]),
            resultCastScopeSchema = json.\("result_cast_scope_schema").toOption.map(_.as[String]),
            resultCastScopeName = json.\("result_cast_scope_name").toOption.map(_.as[String]),
            resultCastMaximumCardinality = json.\("result_cast_maximum_cardinality").toOption.map(_.as[Int]),
            resultCastDtdIdentifier = json.\("result_cast_dtd_identifier").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
