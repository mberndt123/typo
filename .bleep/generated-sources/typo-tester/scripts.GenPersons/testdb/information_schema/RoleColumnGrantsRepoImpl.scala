package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait RoleColumnGrantsRepoImpl extends RoleColumnGrantsRepo {
  override def selectAll(implicit c: Connection): List[RoleColumnGrantsRow] = {
    SQL"""select grantor, grantee, table_catalog, table_schema, table_name, column_name, privilege_type, is_grantable from information_schema.role_column_grants""".as(RoleColumnGrantsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[RoleColumnGrantsFieldValue[_]])(implicit c: Connection): List[RoleColumnGrantsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case RoleColumnGrantsFieldValue.grantor(value) => NamedParameter("grantor", ParameterValue.from(value))
          case RoleColumnGrantsFieldValue.grantee(value) => NamedParameter("grantee", ParameterValue.from(value))
          case RoleColumnGrantsFieldValue.tableCatalog(value) => NamedParameter("table_catalog", ParameterValue.from(value))
          case RoleColumnGrantsFieldValue.tableSchema(value) => NamedParameter("table_schema", ParameterValue.from(value))
          case RoleColumnGrantsFieldValue.tableName(value) => NamedParameter("table_name", ParameterValue.from(value))
          case RoleColumnGrantsFieldValue.columnName(value) => NamedParameter("column_name", ParameterValue.from(value))
          case RoleColumnGrantsFieldValue.privilegeType(value) => NamedParameter("privilege_type", ParameterValue.from(value))
          case RoleColumnGrantsFieldValue.isGrantable(value) => NamedParameter("is_grantable", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.role_column_grants where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(RoleColumnGrantsRow.rowParser.*)
    }

  }
}
