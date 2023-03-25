/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgNamespaceRepoImpl extends PgNamespaceRepo {
  override def selectAll(implicit c: Connection): List[PgNamespaceRow] = {
    SQL"""select oid, nspname, nspowner, nspacl from pg_catalog.pg_namespace""".as(PgNamespaceRow.rowParser("").*)
  }
  override def selectById(oid: PgNamespaceId)(implicit c: Connection): Option[PgNamespaceRow] = {
    SQL"""select oid, nspname, nspowner, nspacl from pg_catalog.pg_namespace where oid = $oid""".as(PgNamespaceRow.rowParser("").singleOpt)
  }
  override def selectByIds(oids: List[PgNamespaceId])(implicit c: Connection): List[PgNamespaceRow] = {
    SQL"""select oid, nspname, nspowner, nspacl from pg_catalog.pg_namespace where oid in $oids""".as(PgNamespaceRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgNamespaceFieldValue[_]])(implicit c: Connection): List[PgNamespaceRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgNamespaceFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspname(value) => NamedParameter("nspname", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspowner(value) => NamedParameter("nspowner", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspacl(value) => NamedParameter("nspacl", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_namespace where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgNamespaceRow.rowParser("").*)
    }

  }
  override def updateFieldValues(oid: PgNamespaceId, fieldValues: List[PgNamespaceFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgNamespaceFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspname(value) => NamedParameter("nspname", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspowner(value) => NamedParameter("nspowner", ParameterValue.from(value))
          case PgNamespaceFieldValue.nspacl(value) => NamedParameter("nspacl", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_namespace
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgNamespaceId, unsaved: PgNamespaceRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("nspname", ParameterValue.from(unsaved.nspname))),
      Some(NamedParameter("nspowner", ParameterValue.from(unsaved.nspowner))),
      Some(NamedParameter("nspacl", ParameterValue.from(unsaved.nspacl)))
    ).flatten

    SQL"""insert into pg_catalog.pg_namespace(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgNamespaceId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_namespace where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUniqueNspname(nspname: String)(implicit c: Connection): Option[PgNamespaceRow] = {
    selectByFieldValues(List(PgNamespaceFieldValue.nspname(nspname))).headOption
  }
}
