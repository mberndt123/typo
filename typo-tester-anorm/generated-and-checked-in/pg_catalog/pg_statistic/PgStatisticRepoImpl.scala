/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic

import adventureworks.TypoAnyArray
import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgStatisticRepoImpl extends PgStatisticRepo {
  override def delete(compositeId: PgStatisticId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_statistic where starelid = ${ParameterValue(compositeId.starelid, null, ToStatement.longToStatement)} AND staattnum = ${ParameterValue(compositeId.staattnum, null, ToStatement.intToStatement)} AND stainherit = ${ParameterValue(compositeId.stainherit, null, ToStatement.booleanToStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgStatisticFields, PgStatisticRow] = {
    DeleteBuilder("pg_catalog.pg_statistic", PgStatisticFields)
  }
  override def insert(unsaved: PgStatisticRow)(implicit c: Connection): PgStatisticRow = {
    SQL"""insert into pg_catalog.pg_statistic(starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5)
          values (${ParameterValue(unsaved.starelid, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.staattnum, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.stainherit, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.stanullfrac, null, ToStatement.floatToStatement)}::float4, ${ParameterValue(unsaved.stawidth, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.stadistinct, null, ToStatement.floatToStatement)}::float4, ${ParameterValue(unsaved.stakind1, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.stakind2, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.stakind3, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.stakind4, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.stakind5, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.staop1, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.staop2, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.staop3, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.staop4, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.staop5, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.stacoll1, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.stacoll2, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.stacoll3, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.stacoll4, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.stacoll5, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.stanumbers1, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4, ${ParameterValue(unsaved.stanumbers2, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4, ${ParameterValue(unsaved.stanumbers3, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4, ${ParameterValue(unsaved.stanumbers4, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4, ${ParameterValue(unsaved.stanumbers5, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4, ${ParameterValue(unsaved.stavalues1, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray, ${ParameterValue(unsaved.stavalues2, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray, ${ParameterValue(unsaved.stavalues3, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray, ${ParameterValue(unsaved.stavalues4, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray, ${ParameterValue(unsaved.stavalues5, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray)
          returning starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5
       """
      .executeInsert(PgStatisticRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgStatisticFields, PgStatisticRow] = {
    SelectBuilderSql("pg_catalog.pg_statistic", PgStatisticFields, PgStatisticRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatisticRow] = {
    SQL"""select starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5
          from pg_catalog.pg_statistic
       """.as(PgStatisticRow.rowParser(1).*)
  }
  override def selectById(compositeId: PgStatisticId)(implicit c: Connection): Option[PgStatisticRow] = {
    SQL"""select starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5
          from pg_catalog.pg_statistic
          where starelid = ${ParameterValue(compositeId.starelid, null, ToStatement.longToStatement)} AND staattnum = ${ParameterValue(compositeId.staattnum, null, ToStatement.intToStatement)} AND stainherit = ${ParameterValue(compositeId.stainherit, null, ToStatement.booleanToStatement)}
       """.as(PgStatisticRow.rowParser(1).singleOpt)
  }
  override def update(row: PgStatisticRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update pg_catalog.pg_statistic
          set stanullfrac = ${ParameterValue(row.stanullfrac, null, ToStatement.floatToStatement)}::float4,
              stawidth = ${ParameterValue(row.stawidth, null, ToStatement.intToStatement)}::int4,
              stadistinct = ${ParameterValue(row.stadistinct, null, ToStatement.floatToStatement)}::float4,
              stakind1 = ${ParameterValue(row.stakind1, null, ToStatement.intToStatement)}::int2,
              stakind2 = ${ParameterValue(row.stakind2, null, ToStatement.intToStatement)}::int2,
              stakind3 = ${ParameterValue(row.stakind3, null, ToStatement.intToStatement)}::int2,
              stakind4 = ${ParameterValue(row.stakind4, null, ToStatement.intToStatement)}::int2,
              stakind5 = ${ParameterValue(row.stakind5, null, ToStatement.intToStatement)}::int2,
              staop1 = ${ParameterValue(row.staop1, null, ToStatement.longToStatement)}::oid,
              staop2 = ${ParameterValue(row.staop2, null, ToStatement.longToStatement)}::oid,
              staop3 = ${ParameterValue(row.staop3, null, ToStatement.longToStatement)}::oid,
              staop4 = ${ParameterValue(row.staop4, null, ToStatement.longToStatement)}::oid,
              staop5 = ${ParameterValue(row.staop5, null, ToStatement.longToStatement)}::oid,
              stacoll1 = ${ParameterValue(row.stacoll1, null, ToStatement.longToStatement)}::oid,
              stacoll2 = ${ParameterValue(row.stacoll2, null, ToStatement.longToStatement)}::oid,
              stacoll3 = ${ParameterValue(row.stacoll3, null, ToStatement.longToStatement)}::oid,
              stacoll4 = ${ParameterValue(row.stacoll4, null, ToStatement.longToStatement)}::oid,
              stacoll5 = ${ParameterValue(row.stacoll5, null, ToStatement.longToStatement)}::oid,
              stanumbers1 = ${ParameterValue(row.stanumbers1, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4,
              stanumbers2 = ${ParameterValue(row.stanumbers2, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4,
              stanumbers3 = ${ParameterValue(row.stanumbers3, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4,
              stanumbers4 = ${ParameterValue(row.stanumbers4, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4,
              stanumbers5 = ${ParameterValue(row.stanumbers5, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4,
              stavalues1 = ${ParameterValue(row.stavalues1, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray,
              stavalues2 = ${ParameterValue(row.stavalues2, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray,
              stavalues3 = ${ParameterValue(row.stavalues3, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray,
              stavalues4 = ${ParameterValue(row.stavalues4, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray,
              stavalues5 = ${ParameterValue(row.stavalues5, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray
          where starelid = ${ParameterValue(compositeId.starelid, null, ToStatement.longToStatement)} AND staattnum = ${ParameterValue(compositeId.staattnum, null, ToStatement.intToStatement)} AND stainherit = ${ParameterValue(compositeId.stainherit, null, ToStatement.booleanToStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgStatisticFields, PgStatisticRow] = {
    UpdateBuilder("pg_catalog.pg_statistic", PgStatisticFields, PgStatisticRow.rowParser)
  }
  override def upsert(unsaved: PgStatisticRow)(implicit c: Connection): PgStatisticRow = {
    SQL"""insert into pg_catalog.pg_statistic(starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5)
          values (
            ${ParameterValue(unsaved.starelid, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.staattnum, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.stainherit, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.stanullfrac, null, ToStatement.floatToStatement)}::float4,
            ${ParameterValue(unsaved.stawidth, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.stadistinct, null, ToStatement.floatToStatement)}::float4,
            ${ParameterValue(unsaved.stakind1, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.stakind2, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.stakind3, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.stakind4, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.stakind5, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.staop1, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.staop2, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.staop3, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.staop4, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.staop5, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.stacoll1, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.stacoll2, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.stacoll3, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.stacoll4, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.stacoll5, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.stanumbers1, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4,
            ${ParameterValue(unsaved.stanumbers2, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4,
            ${ParameterValue(unsaved.stanumbers3, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4,
            ${ParameterValue(unsaved.stanumbers4, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4,
            ${ParameterValue(unsaved.stanumbers5, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4,
            ${ParameterValue(unsaved.stavalues1, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray,
            ${ParameterValue(unsaved.stavalues2, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray,
            ${ParameterValue(unsaved.stavalues3, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray,
            ${ParameterValue(unsaved.stavalues4, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray,
            ${ParameterValue(unsaved.stavalues5, null, ToStatement.optionToStatement(TypoAnyArray.toStatement, TypoAnyArray.parameterMetadata))}::anyarray
          )
          on conflict (starelid, staattnum, stainherit)
          do update set
            stanullfrac = EXCLUDED.stanullfrac,
            stawidth = EXCLUDED.stawidth,
            stadistinct = EXCLUDED.stadistinct,
            stakind1 = EXCLUDED.stakind1,
            stakind2 = EXCLUDED.stakind2,
            stakind3 = EXCLUDED.stakind3,
            stakind4 = EXCLUDED.stakind4,
            stakind5 = EXCLUDED.stakind5,
            staop1 = EXCLUDED.staop1,
            staop2 = EXCLUDED.staop2,
            staop3 = EXCLUDED.staop3,
            staop4 = EXCLUDED.staop4,
            staop5 = EXCLUDED.staop5,
            stacoll1 = EXCLUDED.stacoll1,
            stacoll2 = EXCLUDED.stacoll2,
            stacoll3 = EXCLUDED.stacoll3,
            stacoll4 = EXCLUDED.stacoll4,
            stacoll5 = EXCLUDED.stacoll5,
            stanumbers1 = EXCLUDED.stanumbers1,
            stanumbers2 = EXCLUDED.stanumbers2,
            stanumbers3 = EXCLUDED.stanumbers3,
            stanumbers4 = EXCLUDED.stanumbers4,
            stanumbers5 = EXCLUDED.stanumbers5,
            stavalues1 = EXCLUDED.stavalues1,
            stavalues2 = EXCLUDED.stavalues2,
            stavalues3 = EXCLUDED.stavalues3,
            stavalues4 = EXCLUDED.stavalues4,
            stavalues5 = EXCLUDED.stavalues5
          returning starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5
       """
      .executeInsert(PgStatisticRow.rowParser(1).single)
    
  }
}
