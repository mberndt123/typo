package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgTimezoneNamesRepoImpl extends PgTimezoneNamesRepo {
  override def selectAll(implicit c: Connection): List[PgTimezoneNamesRow] = {
    SQL"""select name, abbrev, utc_offset, is_dst from pg_catalog.pg_timezone_names""".as(PgTimezoneNamesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgTimezoneNamesFieldValue[_]])(implicit c: Connection): List[PgTimezoneNamesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTimezoneNamesFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PgTimezoneNamesFieldValue.abbrev(value) => NamedParameter("abbrev", ParameterValue.from(value))
          case PgTimezoneNamesFieldValue.utcOffset(value) => NamedParameter("utc_offset", ParameterValue.from(value))
          case PgTimezoneNamesFieldValue.isDst(value) => NamedParameter("is_dst", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_timezone_names where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgTimezoneNamesRow.rowParser.*)
    }

  }
}
