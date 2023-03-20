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

object PgEnumRepoImpl extends PgEnumRepo {
  override def selectAll(implicit c: Connection): List[PgEnumRow] = {
    SQL"""select oid, enumtypid, enumsortorder, enumlabel from pg_catalog.pg_enum""".as(PgEnumRow.rowParser.*)
  }
  override def selectById(oid: PgEnumId)(implicit c: Connection): Option[PgEnumRow] = {
    SQL"""select oid, enumtypid, enumsortorder, enumlabel from pg_catalog.pg_enum where oid = $oid""".as(PgEnumRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgEnumId])(implicit c: Connection): List[PgEnumRow] = {
    SQL"""select oid, enumtypid, enumsortorder, enumlabel from pg_catalog.pg_enum where oid in $oids""".as(PgEnumRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgEnumFieldValue[_]])(implicit c: Connection): List[PgEnumRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgEnumFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgEnumFieldValue.enumtypid(value) => NamedParameter("enumtypid", ParameterValue.from(value))
          case PgEnumFieldValue.enumsortorder(value) => NamedParameter("enumsortorder", ParameterValue.from(value))
          case PgEnumFieldValue.enumlabel(value) => NamedParameter("enumlabel", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_enum where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgEnumRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgEnumId, fieldValues: List[PgEnumFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgEnumFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgEnumFieldValue.enumtypid(value) => NamedParameter("enumtypid", ParameterValue.from(value))
          case PgEnumFieldValue.enumsortorder(value) => NamedParameter("enumsortorder", ParameterValue.from(value))
          case PgEnumFieldValue.enumlabel(value) => NamedParameter("enumlabel", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_enum
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgEnumId, unsaved: PgEnumRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("enumtypid", ParameterValue.from(unsaved.enumtypid))),
      Some(NamedParameter("enumsortorder", ParameterValue.from(unsaved.enumsortorder))),
      Some(NamedParameter("enumlabel", ParameterValue.from(unsaved.enumlabel)))
    ).flatten

    SQL"""insert into pg_catalog.pg_enum(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgEnumId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_enum where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(enumtypid: Long, enumlabel: String)(implicit c: Connection): Option[PgEnumRow] = {
    ???
  }
  override def selectByUnique(enumtypid: Long, enumsortorder: Float)(implicit c: Connection): Option[PgEnumRow] = {
    ???
  }
}
