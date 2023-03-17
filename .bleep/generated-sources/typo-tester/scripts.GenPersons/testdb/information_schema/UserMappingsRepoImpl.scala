package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait UserMappingsRepoImpl extends UserMappingsRepo {
  override def selectAll(implicit c: Connection): List[UserMappingsRow] = {
    SQL"""select authorization_identifier, foreign_server_catalog, foreign_server_name from information_schema.user_mappings""".as(UserMappingsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[UserMappingsFieldValue[_]])(implicit c: Connection): List[UserMappingsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case UserMappingsFieldValue.authorizationIdentifier(value) => NamedParameter("authorization_identifier", ParameterValue.from(value))
          case UserMappingsFieldValue.foreignServerCatalog(value) => NamedParameter("foreign_server_catalog", ParameterValue.from(value))
          case UserMappingsFieldValue.foreignServerName(value) => NamedParameter("foreign_server_name", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.user_mappings where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(UserMappingsRow.rowParser.*)
    }

  }
}
