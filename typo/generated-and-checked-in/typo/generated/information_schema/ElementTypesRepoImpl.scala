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

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object ElementTypesRepoImpl extends ElementTypesRepo {
  override def selectAll(implicit c: Connection): List[ElementTypesRow] = {
    SQL"""select object_catalog, object_schema, object_name, object_type, collection_type_identifier, data_type, character_maximum_length, character_octet_length, character_set_catalog, character_set_schema, character_set_name, collation_catalog, collation_schema, collation_name, numeric_precision, numeric_precision_radix, numeric_scale, datetime_precision, interval_type, interval_precision, domain_default, udt_catalog, udt_schema, udt_name, scope_catalog, scope_schema, scope_name, maximum_cardinality, dtd_identifier from information_schema.element_types""".as(ElementTypesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ElementTypesFieldValue[_]])(implicit c: Connection): List[ElementTypesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ElementTypesFieldValue.objectCatalog(value) => NamedParameter("object_catalog", ParameterValue.from(value))
          case ElementTypesFieldValue.objectSchema(value) => NamedParameter("object_schema", ParameterValue.from(value))
          case ElementTypesFieldValue.objectName(value) => NamedParameter("object_name", ParameterValue.from(value))
          case ElementTypesFieldValue.objectType(value) => NamedParameter("object_type", ParameterValue.from(value))
          case ElementTypesFieldValue.collectionTypeIdentifier(value) => NamedParameter("collection_type_identifier", ParameterValue.from(value))
          case ElementTypesFieldValue.dataType(value) => NamedParameter("data_type", ParameterValue.from(value))
          case ElementTypesFieldValue.characterMaximumLength(value) => NamedParameter("character_maximum_length", ParameterValue.from(value))
          case ElementTypesFieldValue.characterOctetLength(value) => NamedParameter("character_octet_length", ParameterValue.from(value))
          case ElementTypesFieldValue.characterSetCatalog(value) => NamedParameter("character_set_catalog", ParameterValue.from(value))
          case ElementTypesFieldValue.characterSetSchema(value) => NamedParameter("character_set_schema", ParameterValue.from(value))
          case ElementTypesFieldValue.characterSetName(value) => NamedParameter("character_set_name", ParameterValue.from(value))
          case ElementTypesFieldValue.collationCatalog(value) => NamedParameter("collation_catalog", ParameterValue.from(value))
          case ElementTypesFieldValue.collationSchema(value) => NamedParameter("collation_schema", ParameterValue.from(value))
          case ElementTypesFieldValue.collationName(value) => NamedParameter("collation_name", ParameterValue.from(value))
          case ElementTypesFieldValue.numericPrecision(value) => NamedParameter("numeric_precision", ParameterValue.from(value))
          case ElementTypesFieldValue.numericPrecisionRadix(value) => NamedParameter("numeric_precision_radix", ParameterValue.from(value))
          case ElementTypesFieldValue.numericScale(value) => NamedParameter("numeric_scale", ParameterValue.from(value))
          case ElementTypesFieldValue.datetimePrecision(value) => NamedParameter("datetime_precision", ParameterValue.from(value))
          case ElementTypesFieldValue.intervalType(value) => NamedParameter("interval_type", ParameterValue.from(value))
          case ElementTypesFieldValue.intervalPrecision(value) => NamedParameter("interval_precision", ParameterValue.from(value))
          case ElementTypesFieldValue.domainDefault(value) => NamedParameter("domain_default", ParameterValue.from(value))
          case ElementTypesFieldValue.udtCatalog(value) => NamedParameter("udt_catalog", ParameterValue.from(value))
          case ElementTypesFieldValue.udtSchema(value) => NamedParameter("udt_schema", ParameterValue.from(value))
          case ElementTypesFieldValue.udtName(value) => NamedParameter("udt_name", ParameterValue.from(value))
          case ElementTypesFieldValue.scopeCatalog(value) => NamedParameter("scope_catalog", ParameterValue.from(value))
          case ElementTypesFieldValue.scopeSchema(value) => NamedParameter("scope_schema", ParameterValue.from(value))
          case ElementTypesFieldValue.scopeName(value) => NamedParameter("scope_name", ParameterValue.from(value))
          case ElementTypesFieldValue.maximumCardinality(value) => NamedParameter("maximum_cardinality", ParameterValue.from(value))
          case ElementTypesFieldValue.dtdIdentifier(value) => NamedParameter("dtd_identifier", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.element_types where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(ElementTypesRow.rowParser.*)
    }

  }
}
