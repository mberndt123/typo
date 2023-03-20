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
import java.time.LocalDateTime

case class RoutinesRow(
  specificCatalog: /* unknown nullability */ Option[String],
  specificSchema: /* unknown nullability */ Option[String],
  specificName: /* unknown nullability */ Option[String],
  routineCatalog: /* unknown nullability */ Option[String],
  routineSchema: /* unknown nullability */ Option[String],
  routineName: /* unknown nullability */ Option[String],
  routineType: /* unknown nullability */ Option[String],
  moduleCatalog: /* unknown nullability */ Option[String],
  moduleSchema: /* unknown nullability */ Option[String],
  moduleName: /* unknown nullability */ Option[String],
  udtCatalog: /* unknown nullability */ Option[String],
  udtSchema: /* unknown nullability */ Option[String],
  udtName: /* unknown nullability */ Option[String],
  dataType: /* unknown nullability */ Option[String],
  characterMaximumLength: /* unknown nullability */ Option[Int],
  characterOctetLength: /* unknown nullability */ Option[Int],
  characterSetCatalog: /* unknown nullability */ Option[String],
  characterSetSchema: /* unknown nullability */ Option[String],
  characterSetName: /* unknown nullability */ Option[String],
  collationCatalog: /* unknown nullability */ Option[String],
  collationSchema: /* unknown nullability */ Option[String],
  collationName: /* unknown nullability */ Option[String],
  numericPrecision: /* unknown nullability */ Option[Int],
  numericPrecisionRadix: /* unknown nullability */ Option[Int],
  numericScale: /* unknown nullability */ Option[Int],
  datetimePrecision: /* unknown nullability */ Option[Int],
  intervalType: /* unknown nullability */ Option[String],
  intervalPrecision: /* unknown nullability */ Option[Int],
  typeUdtCatalog: /* unknown nullability */ Option[String],
  typeUdtSchema: /* unknown nullability */ Option[String],
  typeUdtName: /* unknown nullability */ Option[String],
  scopeCatalog: /* unknown nullability */ Option[String],
  scopeSchema: /* unknown nullability */ Option[String],
  scopeName: /* unknown nullability */ Option[String],
  maximumCardinality: /* unknown nullability */ Option[Int],
  dtdIdentifier: /* unknown nullability */ Option[String],
  routineBody: /* unknown nullability */ Option[String],
  routineDefinition: /* unknown nullability */ Option[String],
  externalName: /* unknown nullability */ Option[String],
  externalLanguage: /* unknown nullability */ Option[String],
  parameterStyle: /* unknown nullability */ Option[String],
  isDeterministic: /* unknown nullability */ Option[String],
  sqlDataAccess: /* unknown nullability */ Option[String],
  isNullCall: /* unknown nullability */ Option[String],
  sqlPath: /* unknown nullability */ Option[String],
  schemaLevelRoutine: /* unknown nullability */ Option[String],
  maxDynamicResultSets: /* unknown nullability */ Option[Int],
  isUserDefinedCast: /* unknown nullability */ Option[String],
  isImplicitlyInvocable: /* unknown nullability */ Option[String],
  securityType: /* unknown nullability */ Option[String],
  toSqlSpecificCatalog: /* unknown nullability */ Option[String],
  toSqlSpecificSchema: /* unknown nullability */ Option[String],
  toSqlSpecificName: /* unknown nullability */ Option[String],
  asLocator: /* unknown nullability */ Option[String],
  created: /* unknown nullability */ Option[LocalDateTime],
  lastAltered: /* unknown nullability */ Option[LocalDateTime],
  newSavepointLevel: /* unknown nullability */ Option[String],
  isUdtDependent: /* unknown nullability */ Option[String],
  resultCastFromDataType: /* unknown nullability */ Option[String],
  resultCastAsLocator: /* unknown nullability */ Option[String],
  resultCastCharMaxLength: /* unknown nullability */ Option[Int],
  resultCastCharOctetLength: /* unknown nullability */ Option[Int],
  resultCastCharSetCatalog: /* unknown nullability */ Option[String],
  resultCastCharSetSchema: /* unknown nullability */ Option[String],
  resultCastCharSetName: /* unknown nullability */ Option[String],
  resultCastCollationCatalog: /* unknown nullability */ Option[String],
  resultCastCollationSchema: /* unknown nullability */ Option[String],
  resultCastCollationName: /* unknown nullability */ Option[String],
  resultCastNumericPrecision: /* unknown nullability */ Option[Int],
  resultCastNumericPrecisionRadix: /* unknown nullability */ Option[Int],
  resultCastNumericScale: /* unknown nullability */ Option[Int],
  resultCastDatetimePrecision: /* unknown nullability */ Option[Int],
  resultCastIntervalType: /* unknown nullability */ Option[String],
  resultCastIntervalPrecision: /* unknown nullability */ Option[Int],
  resultCastTypeUdtCatalog: /* unknown nullability */ Option[String],
  resultCastTypeUdtSchema: /* unknown nullability */ Option[String],
  resultCastTypeUdtName: /* unknown nullability */ Option[String],
  resultCastScopeCatalog: /* unknown nullability */ Option[String],
  resultCastScopeSchema: /* unknown nullability */ Option[String],
  resultCastScopeName: /* unknown nullability */ Option[String],
  resultCastMaximumCardinality: /* unknown nullability */ Option[Int],
  resultCastDtdIdentifier: /* unknown nullability */ Option[String]
)

object RoutinesRow {
  implicit val rowParser: RowParser[RoutinesRow] = { row =>
    Success(
      RoutinesRow(
        specificCatalog = row[/* unknown nullability */ Option[String]]("specific_catalog"),
        specificSchema = row[/* unknown nullability */ Option[String]]("specific_schema"),
        specificName = row[/* unknown nullability */ Option[String]]("specific_name"),
        routineCatalog = row[/* unknown nullability */ Option[String]]("routine_catalog"),
        routineSchema = row[/* unknown nullability */ Option[String]]("routine_schema"),
        routineName = row[/* unknown nullability */ Option[String]]("routine_name"),
        routineType = row[/* unknown nullability */ Option[String]]("routine_type"),
        moduleCatalog = row[/* unknown nullability */ Option[String]]("module_catalog"),
        moduleSchema = row[/* unknown nullability */ Option[String]]("module_schema"),
        moduleName = row[/* unknown nullability */ Option[String]]("module_name"),
        udtCatalog = row[/* unknown nullability */ Option[String]]("udt_catalog"),
        udtSchema = row[/* unknown nullability */ Option[String]]("udt_schema"),
        udtName = row[/* unknown nullability */ Option[String]]("udt_name"),
        dataType = row[/* unknown nullability */ Option[String]]("data_type"),
        characterMaximumLength = row[/* unknown nullability */ Option[Int]]("character_maximum_length"),
        characterOctetLength = row[/* unknown nullability */ Option[Int]]("character_octet_length"),
        characterSetCatalog = row[/* unknown nullability */ Option[String]]("character_set_catalog"),
        characterSetSchema = row[/* unknown nullability */ Option[String]]("character_set_schema"),
        characterSetName = row[/* unknown nullability */ Option[String]]("character_set_name"),
        collationCatalog = row[/* unknown nullability */ Option[String]]("collation_catalog"),
        collationSchema = row[/* unknown nullability */ Option[String]]("collation_schema"),
        collationName = row[/* unknown nullability */ Option[String]]("collation_name"),
        numericPrecision = row[/* unknown nullability */ Option[Int]]("numeric_precision"),
        numericPrecisionRadix = row[/* unknown nullability */ Option[Int]]("numeric_precision_radix"),
        numericScale = row[/* unknown nullability */ Option[Int]]("numeric_scale"),
        datetimePrecision = row[/* unknown nullability */ Option[Int]]("datetime_precision"),
        intervalType = row[/* unknown nullability */ Option[String]]("interval_type"),
        intervalPrecision = row[/* unknown nullability */ Option[Int]]("interval_precision"),
        typeUdtCatalog = row[/* unknown nullability */ Option[String]]("type_udt_catalog"),
        typeUdtSchema = row[/* unknown nullability */ Option[String]]("type_udt_schema"),
        typeUdtName = row[/* unknown nullability */ Option[String]]("type_udt_name"),
        scopeCatalog = row[/* unknown nullability */ Option[String]]("scope_catalog"),
        scopeSchema = row[/* unknown nullability */ Option[String]]("scope_schema"),
        scopeName = row[/* unknown nullability */ Option[String]]("scope_name"),
        maximumCardinality = row[/* unknown nullability */ Option[Int]]("maximum_cardinality"),
        dtdIdentifier = row[/* unknown nullability */ Option[String]]("dtd_identifier"),
        routineBody = row[/* unknown nullability */ Option[String]]("routine_body"),
        routineDefinition = row[/* unknown nullability */ Option[String]]("routine_definition"),
        externalName = row[/* unknown nullability */ Option[String]]("external_name"),
        externalLanguage = row[/* unknown nullability */ Option[String]]("external_language"),
        parameterStyle = row[/* unknown nullability */ Option[String]]("parameter_style"),
        isDeterministic = row[/* unknown nullability */ Option[String]]("is_deterministic"),
        sqlDataAccess = row[/* unknown nullability */ Option[String]]("sql_data_access"),
        isNullCall = row[/* unknown nullability */ Option[String]]("is_null_call"),
        sqlPath = row[/* unknown nullability */ Option[String]]("sql_path"),
        schemaLevelRoutine = row[/* unknown nullability */ Option[String]]("schema_level_routine"),
        maxDynamicResultSets = row[/* unknown nullability */ Option[Int]]("max_dynamic_result_sets"),
        isUserDefinedCast = row[/* unknown nullability */ Option[String]]("is_user_defined_cast"),
        isImplicitlyInvocable = row[/* unknown nullability */ Option[String]]("is_implicitly_invocable"),
        securityType = row[/* unknown nullability */ Option[String]]("security_type"),
        toSqlSpecificCatalog = row[/* unknown nullability */ Option[String]]("to_sql_specific_catalog"),
        toSqlSpecificSchema = row[/* unknown nullability */ Option[String]]("to_sql_specific_schema"),
        toSqlSpecificName = row[/* unknown nullability */ Option[String]]("to_sql_specific_name"),
        asLocator = row[/* unknown nullability */ Option[String]]("as_locator"),
        created = row[/* unknown nullability */ Option[LocalDateTime]]("created"),
        lastAltered = row[/* unknown nullability */ Option[LocalDateTime]]("last_altered"),
        newSavepointLevel = row[/* unknown nullability */ Option[String]]("new_savepoint_level"),
        isUdtDependent = row[/* unknown nullability */ Option[String]]("is_udt_dependent"),
        resultCastFromDataType = row[/* unknown nullability */ Option[String]]("result_cast_from_data_type"),
        resultCastAsLocator = row[/* unknown nullability */ Option[String]]("result_cast_as_locator"),
        resultCastCharMaxLength = row[/* unknown nullability */ Option[Int]]("result_cast_char_max_length"),
        resultCastCharOctetLength = row[/* unknown nullability */ Option[Int]]("result_cast_char_octet_length"),
        resultCastCharSetCatalog = row[/* unknown nullability */ Option[String]]("result_cast_char_set_catalog"),
        resultCastCharSetSchema = row[/* unknown nullability */ Option[String]]("result_cast_char_set_schema"),
        resultCastCharSetName = row[/* unknown nullability */ Option[String]]("result_cast_char_set_name"),
        resultCastCollationCatalog = row[/* unknown nullability */ Option[String]]("result_cast_collation_catalog"),
        resultCastCollationSchema = row[/* unknown nullability */ Option[String]]("result_cast_collation_schema"),
        resultCastCollationName = row[/* unknown nullability */ Option[String]]("result_cast_collation_name"),
        resultCastNumericPrecision = row[/* unknown nullability */ Option[Int]]("result_cast_numeric_precision"),
        resultCastNumericPrecisionRadix = row[/* unknown nullability */ Option[Int]]("result_cast_numeric_precision_radix"),
        resultCastNumericScale = row[/* unknown nullability */ Option[Int]]("result_cast_numeric_scale"),
        resultCastDatetimePrecision = row[/* unknown nullability */ Option[Int]]("result_cast_datetime_precision"),
        resultCastIntervalType = row[/* unknown nullability */ Option[String]]("result_cast_interval_type"),
        resultCastIntervalPrecision = row[/* unknown nullability */ Option[Int]]("result_cast_interval_precision"),
        resultCastTypeUdtCatalog = row[/* unknown nullability */ Option[String]]("result_cast_type_udt_catalog"),
        resultCastTypeUdtSchema = row[/* unknown nullability */ Option[String]]("result_cast_type_udt_schema"),
        resultCastTypeUdtName = row[/* unknown nullability */ Option[String]]("result_cast_type_udt_name"),
        resultCastScopeCatalog = row[/* unknown nullability */ Option[String]]("result_cast_scope_catalog"),
        resultCastScopeSchema = row[/* unknown nullability */ Option[String]]("result_cast_scope_schema"),
        resultCastScopeName = row[/* unknown nullability */ Option[String]]("result_cast_scope_name"),
        resultCastMaximumCardinality = row[/* unknown nullability */ Option[Int]]("result_cast_maximum_cardinality"),
        resultCastDtdIdentifier = row[/* unknown nullability */ Option[String]]("result_cast_dtd_identifier")
      )
    )
  }

  
}
