/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_subscription_rel

import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgSubscriptionRelRepoImpl extends PgSubscriptionRelRepo {
  override def delete(compositeId: PgSubscriptionRelId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_subscription_rel where "srrelid" = ${ParameterValue(compositeId.srrelid, null, ToStatement.longToStatement)} AND "srsubid" = ${ParameterValue(compositeId.srsubid, null, ToStatement.longToStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgSubscriptionRelFields, PgSubscriptionRelRow] = {
    DeleteBuilder("pg_catalog.pg_subscription_rel", PgSubscriptionRelFields)
  }
  override def insert(unsaved: PgSubscriptionRelRow)(implicit c: Connection): PgSubscriptionRelRow = {
    SQL"""insert into pg_catalog.pg_subscription_rel("srsubid", "srrelid", "srsubstate", "srsublsn")
          values (${ParameterValue(unsaved.srsubid, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.srrelid, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.srsubstate, null, ToStatement.stringToStatement)}::char, ${ParameterValue(unsaved.srsublsn, null, ToStatement.optionToStatement(ToStatement.longToStatement, ParameterMetaData.LongParameterMetaData))}::pg_lsn)
          returning "srsubid", "srrelid", "srsubstate", "srsublsn"
       """
      .executeInsert(PgSubscriptionRelRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgSubscriptionRelFields, PgSubscriptionRelRow] = {
    SelectBuilderSql("pg_catalog.pg_subscription_rel", PgSubscriptionRelFields, PgSubscriptionRelRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgSubscriptionRelRow] = {
    SQL"""select "srsubid", "srrelid", "srsubstate", "srsublsn"
          from pg_catalog.pg_subscription_rel
       """.as(PgSubscriptionRelRow.rowParser(1).*)
  }
  override def selectById(compositeId: PgSubscriptionRelId)(implicit c: Connection): Option[PgSubscriptionRelRow] = {
    SQL"""select "srsubid", "srrelid", "srsubstate", "srsublsn"
          from pg_catalog.pg_subscription_rel
          where "srrelid" = ${ParameterValue(compositeId.srrelid, null, ToStatement.longToStatement)} AND "srsubid" = ${ParameterValue(compositeId.srsubid, null, ToStatement.longToStatement)}
       """.as(PgSubscriptionRelRow.rowParser(1).singleOpt)
  }
  override def update(row: PgSubscriptionRelRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update pg_catalog.pg_subscription_rel
          set "srsubstate" = ${ParameterValue(row.srsubstate, null, ToStatement.stringToStatement)}::char,
              "srsublsn" = ${ParameterValue(row.srsublsn, null, ToStatement.optionToStatement(ToStatement.longToStatement, ParameterMetaData.LongParameterMetaData))}::pg_lsn
          where "srrelid" = ${ParameterValue(compositeId.srrelid, null, ToStatement.longToStatement)} AND "srsubid" = ${ParameterValue(compositeId.srsubid, null, ToStatement.longToStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgSubscriptionRelFields, PgSubscriptionRelRow] = {
    UpdateBuilder("pg_catalog.pg_subscription_rel", PgSubscriptionRelFields, PgSubscriptionRelRow.rowParser)
  }
  override def upsert(unsaved: PgSubscriptionRelRow)(implicit c: Connection): PgSubscriptionRelRow = {
    SQL"""insert into pg_catalog.pg_subscription_rel("srsubid", "srrelid", "srsubstate", "srsublsn")
          values (
            ${ParameterValue(unsaved.srsubid, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.srrelid, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.srsubstate, null, ToStatement.stringToStatement)}::char,
            ${ParameterValue(unsaved.srsublsn, null, ToStatement.optionToStatement(ToStatement.longToStatement, ParameterMetaData.LongParameterMetaData))}::pg_lsn
          )
          on conflict ("srrelid", "srsubid")
          do update set
            "srsubstate" = EXCLUDED."srsubstate",
            "srsublsn" = EXCLUDED."srsublsn"
          returning "srsubid", "srrelid", "srsubstate", "srsublsn"
       """
      .executeInsert(PgSubscriptionRelRow.rowParser(1).single)
    
  }
}
