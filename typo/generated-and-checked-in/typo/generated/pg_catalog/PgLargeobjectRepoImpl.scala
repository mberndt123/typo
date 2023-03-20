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

object PgLargeobjectRepoImpl extends PgLargeobjectRepo {
  override def selectAll(implicit c: Connection): List[PgLargeobjectRow] = {
    SQL"""select loid, pageno, data from pg_catalog.pg_largeobject""".as(PgLargeobjectRow.rowParser.*)
  }
  override def selectById(compositeId: PgLargeobjectId)(implicit c: Connection): Option[PgLargeobjectRow] = {
    SQL"""select loid, pageno, data from pg_catalog.pg_largeobject where loid = ${compositeId.loid}, pageno = ${compositeId.pageno}""".as(PgLargeobjectRow.rowParser.singleOpt)
  }
  override def selectByFieldValues(fieldValues: List[PgLargeobjectFieldValue[_]])(implicit c: Connection): List[PgLargeobjectRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgLargeobjectFieldValue.loid(value) => NamedParameter("loid", ParameterValue.from(value))
          case PgLargeobjectFieldValue.pageno(value) => NamedParameter("pageno", ParameterValue.from(value))
          case PgLargeobjectFieldValue.data(value) => NamedParameter("data", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_largeobject where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgLargeobjectRow.rowParser.*)
    }

  }
  override def updateFieldValues(compositeId: PgLargeobjectId, fieldValues: List[PgLargeobjectFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgLargeobjectFieldValue.loid(value) => NamedParameter("loid", ParameterValue.from(value))
          case PgLargeobjectFieldValue.pageno(value) => NamedParameter("pageno", ParameterValue.from(value))
          case PgLargeobjectFieldValue.data(value) => NamedParameter("data", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_largeobject
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where loid = ${compositeId.loid}, pageno = ${compositeId.pageno}"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(compositeId: PgLargeobjectId, unsaved: PgLargeobjectRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("data", ParameterValue.from(unsaved.data)))
    ).flatten

    SQL"""insert into pg_catalog.pg_largeobject(loid, pageno, ${namedParameters.map(_.name).mkString(", ")})
      values (${compositeId.loid}, ${compositeId.pageno}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(compositeId: PgLargeobjectId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_largeobject where loid = ${compositeId.loid}, pageno = ${compositeId.pageno}""".executeUpdate() > 0
  }
}
