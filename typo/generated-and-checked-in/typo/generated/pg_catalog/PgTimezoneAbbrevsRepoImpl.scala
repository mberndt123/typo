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

object PgTimezoneAbbrevsRepoImpl extends PgTimezoneAbbrevsRepo {
  override def selectAll(implicit c: Connection): List[PgTimezoneAbbrevsRow] = {
    SQL"""select abbrev, utc_offset, is_dst from pg_catalog.pg_timezone_abbrevs""".as(PgTimezoneAbbrevsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgTimezoneAbbrevsFieldValue[_]])(implicit c: Connection): List[PgTimezoneAbbrevsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTimezoneAbbrevsFieldValue.abbrev(value) => NamedParameter("abbrev", ParameterValue.from(value))
          case PgTimezoneAbbrevsFieldValue.utcOffset(value) => NamedParameter("utc_offset", ParameterValue.from(value))
          case PgTimezoneAbbrevsFieldValue.isDst(value) => NamedParameter("is_dst", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_timezone_abbrevs where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgTimezoneAbbrevsRow.rowParser.*)
    }

  }
}
