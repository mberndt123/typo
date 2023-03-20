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

object PgDatabaseRepoImpl extends PgDatabaseRepo {
  override def selectAll(implicit c: Connection): List[PgDatabaseRow] = {
    SQL"""select oid, datname, datdba, encoding, datcollate, datctype, datistemplate, datallowconn, datconnlimit, datlastsysoid, datfrozenxid, datminmxid, dattablespace, datacl from pg_catalog.pg_database""".as(PgDatabaseRow.rowParser.*)
  }
  override def selectById(oid: PgDatabaseId)(implicit c: Connection): Option[PgDatabaseRow] = {
    SQL"""select oid, datname, datdba, encoding, datcollate, datctype, datistemplate, datallowconn, datconnlimit, datlastsysoid, datfrozenxid, datminmxid, dattablespace, datacl from pg_catalog.pg_database where oid = $oid""".as(PgDatabaseRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgDatabaseId])(implicit c: Connection): List[PgDatabaseRow] = {
    SQL"""select oid, datname, datdba, encoding, datcollate, datctype, datistemplate, datallowconn, datconnlimit, datlastsysoid, datfrozenxid, datminmxid, dattablespace, datacl from pg_catalog.pg_database where oid in $oids""".as(PgDatabaseRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgDatabaseFieldValue[_]])(implicit c: Connection): List[PgDatabaseRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgDatabaseFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgDatabaseFieldValue.datname(value) => NamedParameter("datname", ParameterValue.from(value))
          case PgDatabaseFieldValue.datdba(value) => NamedParameter("datdba", ParameterValue.from(value))
          case PgDatabaseFieldValue.encoding(value) => NamedParameter("encoding", ParameterValue.from(value))
          case PgDatabaseFieldValue.datcollate(value) => NamedParameter("datcollate", ParameterValue.from(value))
          case PgDatabaseFieldValue.datctype(value) => NamedParameter("datctype", ParameterValue.from(value))
          case PgDatabaseFieldValue.datistemplate(value) => NamedParameter("datistemplate", ParameterValue.from(value))
          case PgDatabaseFieldValue.datallowconn(value) => NamedParameter("datallowconn", ParameterValue.from(value))
          case PgDatabaseFieldValue.datconnlimit(value) => NamedParameter("datconnlimit", ParameterValue.from(value))
          case PgDatabaseFieldValue.datlastsysoid(value) => NamedParameter("datlastsysoid", ParameterValue.from(value))
          case PgDatabaseFieldValue.datfrozenxid(value) => NamedParameter("datfrozenxid", ParameterValue.from(value))
          case PgDatabaseFieldValue.datminmxid(value) => NamedParameter("datminmxid", ParameterValue.from(value))
          case PgDatabaseFieldValue.dattablespace(value) => NamedParameter("dattablespace", ParameterValue.from(value))
          case PgDatabaseFieldValue.datacl(value) => NamedParameter("datacl", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_database where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgDatabaseRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgDatabaseId, fieldValues: List[PgDatabaseFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgDatabaseFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgDatabaseFieldValue.datname(value) => NamedParameter("datname", ParameterValue.from(value))
          case PgDatabaseFieldValue.datdba(value) => NamedParameter("datdba", ParameterValue.from(value))
          case PgDatabaseFieldValue.encoding(value) => NamedParameter("encoding", ParameterValue.from(value))
          case PgDatabaseFieldValue.datcollate(value) => NamedParameter("datcollate", ParameterValue.from(value))
          case PgDatabaseFieldValue.datctype(value) => NamedParameter("datctype", ParameterValue.from(value))
          case PgDatabaseFieldValue.datistemplate(value) => NamedParameter("datistemplate", ParameterValue.from(value))
          case PgDatabaseFieldValue.datallowconn(value) => NamedParameter("datallowconn", ParameterValue.from(value))
          case PgDatabaseFieldValue.datconnlimit(value) => NamedParameter("datconnlimit", ParameterValue.from(value))
          case PgDatabaseFieldValue.datlastsysoid(value) => NamedParameter("datlastsysoid", ParameterValue.from(value))
          case PgDatabaseFieldValue.datfrozenxid(value) => NamedParameter("datfrozenxid", ParameterValue.from(value))
          case PgDatabaseFieldValue.datminmxid(value) => NamedParameter("datminmxid", ParameterValue.from(value))
          case PgDatabaseFieldValue.dattablespace(value) => NamedParameter("dattablespace", ParameterValue.from(value))
          case PgDatabaseFieldValue.datacl(value) => NamedParameter("datacl", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_database
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgDatabaseId, unsaved: PgDatabaseRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("datname", ParameterValue.from(unsaved.datname))),
      Some(NamedParameter("datdba", ParameterValue.from(unsaved.datdba))),
      Some(NamedParameter("encoding", ParameterValue.from(unsaved.encoding))),
      Some(NamedParameter("datcollate", ParameterValue.from(unsaved.datcollate))),
      Some(NamedParameter("datctype", ParameterValue.from(unsaved.datctype))),
      Some(NamedParameter("datistemplate", ParameterValue.from(unsaved.datistemplate))),
      Some(NamedParameter("datallowconn", ParameterValue.from(unsaved.datallowconn))),
      Some(NamedParameter("datconnlimit", ParameterValue.from(unsaved.datconnlimit))),
      Some(NamedParameter("datlastsysoid", ParameterValue.from(unsaved.datlastsysoid))),
      Some(NamedParameter("datfrozenxid", ParameterValue.from(unsaved.datfrozenxid))),
      Some(NamedParameter("datminmxid", ParameterValue.from(unsaved.datminmxid))),
      Some(NamedParameter("dattablespace", ParameterValue.from(unsaved.dattablespace))),
      Some(NamedParameter("datacl", ParameterValue.from(unsaved.datacl)))
    ).flatten

    SQL"""insert into pg_catalog.pg_database(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgDatabaseId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_database where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(datname: String)(implicit c: Connection): Option[PgDatabaseRow] = {
    ???
  }
}
