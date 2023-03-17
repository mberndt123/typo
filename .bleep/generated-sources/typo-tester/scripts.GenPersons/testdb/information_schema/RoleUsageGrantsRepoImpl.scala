package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait RoleUsageGrantsRepoImpl extends RoleUsageGrantsRepo {
  override def selectAll(implicit c: Connection): List[RoleUsageGrantsRow] = {
    SQL"""select grantor, grantee, object_catalog, object_schema, object_name, object_type, privilege_type, is_grantable from information_schema.role_usage_grants""".as(RoleUsageGrantsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[RoleUsageGrantsFieldValue[_]])(implicit c: Connection): List[RoleUsageGrantsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case RoleUsageGrantsFieldValue.grantor(value) => NamedParameter("grantor", ParameterValue.from(value))
          case RoleUsageGrantsFieldValue.grantee(value) => NamedParameter("grantee", ParameterValue.from(value))
          case RoleUsageGrantsFieldValue.objectCatalog(value) => NamedParameter("object_catalog", ParameterValue.from(value))
          case RoleUsageGrantsFieldValue.objectSchema(value) => NamedParameter("object_schema", ParameterValue.from(value))
          case RoleUsageGrantsFieldValue.objectName(value) => NamedParameter("object_name", ParameterValue.from(value))
          case RoleUsageGrantsFieldValue.objectType(value) => NamedParameter("object_type", ParameterValue.from(value))
          case RoleUsageGrantsFieldValue.privilegeType(value) => NamedParameter("privilege_type", ParameterValue.from(value))
          case RoleUsageGrantsFieldValue.isGrantable(value) => NamedParameter("is_grantable", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.role_usage_grants where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(RoleUsageGrantsRow.rowParser.*)
    }

  }
}
