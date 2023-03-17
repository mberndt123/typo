package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgSeclabelsRepoImpl extends PgSeclabelsRepo {
  override def selectAll(implicit c: Connection): List[PgSeclabelsRow] = {
    SQL"""select objoid, classoid, objsubid, objtype, objnamespace, objname, provider, label from pg_catalog.pg_seclabels""".as(PgSeclabelsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgSeclabelsFieldValue[_]])(implicit c: Connection): List[PgSeclabelsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgSeclabelsFieldValue.objoid(value) => NamedParameter("objoid", ParameterValue.from(value))
          case PgSeclabelsFieldValue.classoid(value) => NamedParameter("classoid", ParameterValue.from(value))
          case PgSeclabelsFieldValue.objsubid(value) => NamedParameter("objsubid", ParameterValue.from(value))
          case PgSeclabelsFieldValue.objtype(value) => NamedParameter("objtype", ParameterValue.from(value))
          case PgSeclabelsFieldValue.objnamespace(value) => NamedParameter("objnamespace", ParameterValue.from(value))
          case PgSeclabelsFieldValue.objname(value) => NamedParameter("objname", ParameterValue.from(value))
          case PgSeclabelsFieldValue.provider(value) => NamedParameter("provider", ParameterValue.from(value))
          case PgSeclabelsFieldValue.label(value) => NamedParameter("label", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_seclabels where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgSeclabelsRow.rowParser.*)
    }

  }
}
