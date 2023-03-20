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

object PgSubscriptionRelRepoImpl extends PgSubscriptionRelRepo {
  override def selectAll(implicit c: Connection): List[PgSubscriptionRelRow] = {
    SQL"""select srsubid, srrelid, srsubstate, srsublsn from pg_catalog.pg_subscription_rel""".as(PgSubscriptionRelRow.rowParser.*)
  }
  override def selectById(compositeId: PgSubscriptionRelId)(implicit c: Connection): Option[PgSubscriptionRelRow] = {
    SQL"""select srsubid, srrelid, srsubstate, srsublsn from pg_catalog.pg_subscription_rel where srrelid = ${compositeId.srrelid}, srsubid = ${compositeId.srsubid}""".as(PgSubscriptionRelRow.rowParser.singleOpt)
  }
  override def selectByFieldValues(fieldValues: List[PgSubscriptionRelFieldValue[_]])(implicit c: Connection): List[PgSubscriptionRelRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgSubscriptionRelFieldValue.srsubid(value) => NamedParameter("srsubid", ParameterValue.from(value))
          case PgSubscriptionRelFieldValue.srrelid(value) => NamedParameter("srrelid", ParameterValue.from(value))
          case PgSubscriptionRelFieldValue.srsubstate(value) => NamedParameter("srsubstate", ParameterValue.from(value))
          case PgSubscriptionRelFieldValue.srsublsn(value) => NamedParameter("srsublsn", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_subscription_rel where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgSubscriptionRelRow.rowParser.*)
    }

  }
  override def updateFieldValues(compositeId: PgSubscriptionRelId, fieldValues: List[PgSubscriptionRelFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgSubscriptionRelFieldValue.srsubid(value) => NamedParameter("srsubid", ParameterValue.from(value))
          case PgSubscriptionRelFieldValue.srrelid(value) => NamedParameter("srrelid", ParameterValue.from(value))
          case PgSubscriptionRelFieldValue.srsubstate(value) => NamedParameter("srsubstate", ParameterValue.from(value))
          case PgSubscriptionRelFieldValue.srsublsn(value) => NamedParameter("srsublsn", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_subscription_rel
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where srrelid = ${compositeId.srrelid}, srsubid = ${compositeId.srsubid}"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(compositeId: PgSubscriptionRelId, unsaved: PgSubscriptionRelRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("srsubstate", ParameterValue.from(unsaved.srsubstate))),
      Some(NamedParameter("srsublsn", ParameterValue.from(unsaved.srsublsn)))
    ).flatten

    SQL"""insert into pg_catalog.pg_subscription_rel(srrelid, srsubid, ${namedParameters.map(_.name).mkString(", ")})
      values (${compositeId.srrelid}, ${compositeId.srsubid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(compositeId: PgSubscriptionRelId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_subscription_rel where srrelid = ${compositeId.srrelid}, srsubid = ${compositeId.srsubid}""".executeUpdate() > 0
  }
}
