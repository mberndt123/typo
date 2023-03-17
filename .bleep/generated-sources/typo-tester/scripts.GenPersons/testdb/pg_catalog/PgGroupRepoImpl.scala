package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgGroupRepoImpl extends PgGroupRepo {
  override def selectAll(implicit c: Connection): List[PgGroupRow] = {
    SQL"""select groname, grosysid, grolist from pg_catalog.pg_group""".as(PgGroupRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgGroupFieldValue[_]])(implicit c: Connection): List[PgGroupRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgGroupFieldValue.groname(value) => NamedParameter("groname", ParameterValue.from(value))
          case PgGroupFieldValue.grosysid(value) => NamedParameter("grosysid", ParameterValue.from(value))
          case PgGroupFieldValue.grolist(value) => NamedParameter("grolist", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_group where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgGroupRow.rowParser.*)
    }

  }
}
