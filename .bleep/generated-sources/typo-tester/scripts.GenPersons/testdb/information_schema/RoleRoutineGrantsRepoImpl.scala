package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait RoleRoutineGrantsRepoImpl extends RoleRoutineGrantsRepo {
  override def selectAll(implicit c: Connection): List[RoleRoutineGrantsRow] = {
    SQL"""select grantor, grantee, specific_catalog, specific_schema, specific_name, routine_catalog, routine_schema, routine_name, privilege_type, is_grantable from information_schema.role_routine_grants""".as(RoleRoutineGrantsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[RoleRoutineGrantsFieldValue[_]])(implicit c: Connection): List[RoleRoutineGrantsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case RoleRoutineGrantsFieldValue.grantor(value) => NamedParameter("grantor", ParameterValue.from(value))
          case RoleRoutineGrantsFieldValue.grantee(value) => NamedParameter("grantee", ParameterValue.from(value))
          case RoleRoutineGrantsFieldValue.specificCatalog(value) => NamedParameter("specific_catalog", ParameterValue.from(value))
          case RoleRoutineGrantsFieldValue.specificSchema(value) => NamedParameter("specific_schema", ParameterValue.from(value))
          case RoleRoutineGrantsFieldValue.specificName(value) => NamedParameter("specific_name", ParameterValue.from(value))
          case RoleRoutineGrantsFieldValue.routineCatalog(value) => NamedParameter("routine_catalog", ParameterValue.from(value))
          case RoleRoutineGrantsFieldValue.routineSchema(value) => NamedParameter("routine_schema", ParameterValue.from(value))
          case RoleRoutineGrantsFieldValue.routineName(value) => NamedParameter("routine_name", ParameterValue.from(value))
          case RoleRoutineGrantsFieldValue.privilegeType(value) => NamedParameter("privilege_type", ParameterValue.from(value))
          case RoleRoutineGrantsFieldValue.isGrantable(value) => NamedParameter("is_grantable", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.role_routine_grants where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(RoleRoutineGrantsRow.rowParser.*)
    }

  }
}
