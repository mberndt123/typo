package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait DomainsRepoImpl extends DomainsRepo {
  override def selectAll(implicit c: Connection): List[DomainsRow] = {
    SQL"""select domain_catalog, domain_schema, domain_name, data_type, character_maximum_length, character_octet_length, character_set_catalog, character_set_schema, character_set_name, collation_catalog, collation_schema, collation_name, numeric_precision, numeric_precision_radix, numeric_scale, datetime_precision, interval_type, interval_precision, domain_default, udt_catalog, udt_schema, udt_name, scope_catalog, scope_schema, scope_name, maximum_cardinality, dtd_identifier from information_schema.domains""".as(DomainsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[DomainsFieldValue[_]])(implicit c: Connection): List[DomainsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case DomainsFieldValue.domainCatalog(value) => NamedParameter("domain_catalog", ParameterValue.from(value))
          case DomainsFieldValue.domainSchema(value) => NamedParameter("domain_schema", ParameterValue.from(value))
          case DomainsFieldValue.domainName(value) => NamedParameter("domain_name", ParameterValue.from(value))
          case DomainsFieldValue.dataType(value) => NamedParameter("data_type", ParameterValue.from(value))
          case DomainsFieldValue.characterMaximumLength(value) => NamedParameter("character_maximum_length", ParameterValue.from(value))
          case DomainsFieldValue.characterOctetLength(value) => NamedParameter("character_octet_length", ParameterValue.from(value))
          case DomainsFieldValue.characterSetCatalog(value) => NamedParameter("character_set_catalog", ParameterValue.from(value))
          case DomainsFieldValue.characterSetSchema(value) => NamedParameter("character_set_schema", ParameterValue.from(value))
          case DomainsFieldValue.characterSetName(value) => NamedParameter("character_set_name", ParameterValue.from(value))
          case DomainsFieldValue.collationCatalog(value) => NamedParameter("collation_catalog", ParameterValue.from(value))
          case DomainsFieldValue.collationSchema(value) => NamedParameter("collation_schema", ParameterValue.from(value))
          case DomainsFieldValue.collationName(value) => NamedParameter("collation_name", ParameterValue.from(value))
          case DomainsFieldValue.numericPrecision(value) => NamedParameter("numeric_precision", ParameterValue.from(value))
          case DomainsFieldValue.numericPrecisionRadix(value) => NamedParameter("numeric_precision_radix", ParameterValue.from(value))
          case DomainsFieldValue.numericScale(value) => NamedParameter("numeric_scale", ParameterValue.from(value))
          case DomainsFieldValue.datetimePrecision(value) => NamedParameter("datetime_precision", ParameterValue.from(value))
          case DomainsFieldValue.intervalType(value) => NamedParameter("interval_type", ParameterValue.from(value))
          case DomainsFieldValue.intervalPrecision(value) => NamedParameter("interval_precision", ParameterValue.from(value))
          case DomainsFieldValue.domainDefault(value) => NamedParameter("domain_default", ParameterValue.from(value))
          case DomainsFieldValue.udtCatalog(value) => NamedParameter("udt_catalog", ParameterValue.from(value))
          case DomainsFieldValue.udtSchema(value) => NamedParameter("udt_schema", ParameterValue.from(value))
          case DomainsFieldValue.udtName(value) => NamedParameter("udt_name", ParameterValue.from(value))
          case DomainsFieldValue.scopeCatalog(value) => NamedParameter("scope_catalog", ParameterValue.from(value))
          case DomainsFieldValue.scopeSchema(value) => NamedParameter("scope_schema", ParameterValue.from(value))
          case DomainsFieldValue.scopeName(value) => NamedParameter("scope_name", ParameterValue.from(value))
          case DomainsFieldValue.maximumCardinality(value) => NamedParameter("maximum_cardinality", ParameterValue.from(value))
          case DomainsFieldValue.dtdIdentifier(value) => NamedParameter("dtd_identifier", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.domains where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(DomainsRow.rowParser.*)
    }

  }
}
