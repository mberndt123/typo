/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgPoliciesRepoImpl extends PgPoliciesRepo {
  override def selectAll(implicit c: Connection): List[PgPoliciesRow] = {
    SQL"""select schemaname, tablename, policyname, permissive, roles, cmd, qual, with_check from pg_catalog.pg_policies""".as(PgPoliciesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgPoliciesFieldValue[_]])(implicit c: Connection): List[PgPoliciesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPoliciesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgPoliciesFieldValue.tablename(value) => NamedParameter("tablename", ParameterValue.from(value))
          case PgPoliciesFieldValue.policyname(value) => NamedParameter("policyname", ParameterValue.from(value))
          case PgPoliciesFieldValue.permissive(value) => NamedParameter("permissive", ParameterValue.from(value))
          case PgPoliciesFieldValue.roles(value) => NamedParameter("roles", ParameterValue.from(value))
          case PgPoliciesFieldValue.cmd(value) => NamedParameter("cmd", ParameterValue.from(value))
          case PgPoliciesFieldValue.qual(value) => NamedParameter("qual", ParameterValue.from(value))
          case PgPoliciesFieldValue.withCheck(value) => NamedParameter("with_check", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_policies where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgPoliciesRow.rowParser.*)
    }

  }
}
