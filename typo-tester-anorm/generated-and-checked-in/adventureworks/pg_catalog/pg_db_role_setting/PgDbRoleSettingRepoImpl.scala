/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_db_role_setting

import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgDbRoleSettingRepoImpl extends PgDbRoleSettingRepo {
  override def delete(compositeId: PgDbRoleSettingId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_db_role_setting where "setdatabase" = ${ParameterValue(compositeId.setdatabase, null, ToStatement.longToStatement)} AND "setrole" = ${ParameterValue(compositeId.setrole, null, ToStatement.longToStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgDbRoleSettingFields, PgDbRoleSettingRow] = {
    DeleteBuilder("pg_catalog.pg_db_role_setting", PgDbRoleSettingFields)
  }
  override def insert(unsaved: PgDbRoleSettingRow)(implicit c: Connection): PgDbRoleSettingRow = {
    SQL"""insert into pg_catalog.pg_db_role_setting("setdatabase", "setrole", "setconfig")
          values (${ParameterValue(unsaved.setdatabase, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.setrole, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.setconfig, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_text)
          returning "setdatabase", "setrole", "setconfig"
       """
      .executeInsert(PgDbRoleSettingRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgDbRoleSettingFields, PgDbRoleSettingRow] = {
    SelectBuilderSql("pg_catalog.pg_db_role_setting", PgDbRoleSettingFields, PgDbRoleSettingRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgDbRoleSettingRow] = {
    SQL"""select "setdatabase", "setrole", "setconfig"
          from pg_catalog.pg_db_role_setting
       """.as(PgDbRoleSettingRow.rowParser(1).*)
  }
  override def selectById(compositeId: PgDbRoleSettingId)(implicit c: Connection): Option[PgDbRoleSettingRow] = {
    SQL"""select "setdatabase", "setrole", "setconfig"
          from pg_catalog.pg_db_role_setting
          where "setdatabase" = ${ParameterValue(compositeId.setdatabase, null, ToStatement.longToStatement)} AND "setrole" = ${ParameterValue(compositeId.setrole, null, ToStatement.longToStatement)}
       """.as(PgDbRoleSettingRow.rowParser(1).singleOpt)
  }
  override def update(row: PgDbRoleSettingRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update pg_catalog.pg_db_role_setting
          set "setconfig" = ${ParameterValue(row.setconfig, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_text
          where "setdatabase" = ${ParameterValue(compositeId.setdatabase, null, ToStatement.longToStatement)} AND "setrole" = ${ParameterValue(compositeId.setrole, null, ToStatement.longToStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgDbRoleSettingFields, PgDbRoleSettingRow] = {
    UpdateBuilder("pg_catalog.pg_db_role_setting", PgDbRoleSettingFields, PgDbRoleSettingRow.rowParser)
  }
  override def upsert(unsaved: PgDbRoleSettingRow)(implicit c: Connection): PgDbRoleSettingRow = {
    SQL"""insert into pg_catalog.pg_db_role_setting("setdatabase", "setrole", "setconfig")
          values (
            ${ParameterValue(unsaved.setdatabase, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.setrole, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.setconfig, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_text
          )
          on conflict ("setdatabase", "setrole")
          do update set
            "setconfig" = EXCLUDED."setconfig"
          returning "setdatabase", "setrole", "setconfig"
       """
      .executeInsert(PgDbRoleSettingRow.rowParser(1).single)
    
  }
}
