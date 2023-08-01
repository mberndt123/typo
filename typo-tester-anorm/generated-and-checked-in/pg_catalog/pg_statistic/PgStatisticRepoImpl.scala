/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgStatisticRepoImpl extends PgStatisticRepo {
  override def delete(compositeId: PgStatisticId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_statistic where starelid = ${compositeId.starelid} AND staattnum = ${compositeId.staattnum} AND stainherit = ${compositeId.stainherit}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgStatisticFields, PgStatisticRow] = {
    DeleteBuilder("pg_catalog.pg_statistic", PgStatisticFields)
  }
  override def insert(unsaved: PgStatisticRow)(implicit c: Connection): PgStatisticRow = {
    SQL"""insert into pg_catalog.pg_statistic(starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5)
          values (${unsaved.starelid}::oid, ${unsaved.staattnum}::int2, ${unsaved.stainherit}, ${unsaved.stanullfrac}::float4, ${unsaved.stawidth}::int4, ${unsaved.stadistinct}::float4, ${unsaved.stakind1}::int2, ${unsaved.stakind2}::int2, ${unsaved.stakind3}::int2, ${unsaved.stakind4}::int2, ${unsaved.stakind5}::int2, ${unsaved.staop1}::oid, ${unsaved.staop2}::oid, ${unsaved.staop3}::oid, ${unsaved.staop4}::oid, ${unsaved.staop5}::oid, ${unsaved.stacoll1}::oid, ${unsaved.stacoll2}::oid, ${unsaved.stacoll3}::oid, ${unsaved.stacoll4}::oid, ${unsaved.stacoll5}::oid, ${unsaved.stanumbers1}::_float4, ${unsaved.stanumbers2}::_float4, ${unsaved.stanumbers3}::_float4, ${unsaved.stanumbers4}::_float4, ${unsaved.stanumbers5}::_float4, ${unsaved.stavalues1}::anyarray, ${unsaved.stavalues2}::anyarray, ${unsaved.stavalues3}::anyarray, ${unsaved.stavalues4}::anyarray, ${unsaved.stavalues5}::anyarray)
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
          where starelid = ${compositeId.starelid} AND staattnum = ${compositeId.staattnum} AND stainherit = ${compositeId.stainherit}
       """.as(PgStatisticRow.rowParser(1).singleOpt)
  }
  override def update(row: PgStatisticRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update pg_catalog.pg_statistic
          set stanullfrac = ${row.stanullfrac}::float4,
              stawidth = ${row.stawidth}::int4,
              stadistinct = ${row.stadistinct}::float4,
              stakind1 = ${row.stakind1}::int2,
              stakind2 = ${row.stakind2}::int2,
              stakind3 = ${row.stakind3}::int2,
              stakind4 = ${row.stakind4}::int2,
              stakind5 = ${row.stakind5}::int2,
              staop1 = ${row.staop1}::oid,
              staop2 = ${row.staop2}::oid,
              staop3 = ${row.staop3}::oid,
              staop4 = ${row.staop4}::oid,
              staop5 = ${row.staop5}::oid,
              stacoll1 = ${row.stacoll1}::oid,
              stacoll2 = ${row.stacoll2}::oid,
              stacoll3 = ${row.stacoll3}::oid,
              stacoll4 = ${row.stacoll4}::oid,
              stacoll5 = ${row.stacoll5}::oid,
              stanumbers1 = ${row.stanumbers1}::_float4,
              stanumbers2 = ${row.stanumbers2}::_float4,
              stanumbers3 = ${row.stanumbers3}::_float4,
              stanumbers4 = ${row.stanumbers4}::_float4,
              stanumbers5 = ${row.stanumbers5}::_float4,
              stavalues1 = ${row.stavalues1}::anyarray,
              stavalues2 = ${row.stavalues2}::anyarray,
              stavalues3 = ${row.stavalues3}::anyarray,
              stavalues4 = ${row.stavalues4}::anyarray,
              stavalues5 = ${row.stavalues5}::anyarray
          where starelid = ${compositeId.starelid} AND staattnum = ${compositeId.staattnum} AND stainherit = ${compositeId.stainherit}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgStatisticFields, PgStatisticRow] = {
    UpdateBuilder("pg_catalog.pg_statistic", PgStatisticFields, PgStatisticRow.rowParser)
  }
  override def upsert(unsaved: PgStatisticRow)(implicit c: Connection): PgStatisticRow = {
    SQL"""insert into pg_catalog.pg_statistic(starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5)
          values (
            ${unsaved.starelid}::oid,
            ${unsaved.staattnum}::int2,
            ${unsaved.stainherit},
            ${unsaved.stanullfrac}::float4,
            ${unsaved.stawidth}::int4,
            ${unsaved.stadistinct}::float4,
            ${unsaved.stakind1}::int2,
            ${unsaved.stakind2}::int2,
            ${unsaved.stakind3}::int2,
            ${unsaved.stakind4}::int2,
            ${unsaved.stakind5}::int2,
            ${unsaved.staop1}::oid,
            ${unsaved.staop2}::oid,
            ${unsaved.staop3}::oid,
            ${unsaved.staop4}::oid,
            ${unsaved.staop5}::oid,
            ${unsaved.stacoll1}::oid,
            ${unsaved.stacoll2}::oid,
            ${unsaved.stacoll3}::oid,
            ${unsaved.stacoll4}::oid,
            ${unsaved.stacoll5}::oid,
            ${unsaved.stanumbers1}::_float4,
            ${unsaved.stanumbers2}::_float4,
            ${unsaved.stanumbers3}::_float4,
            ${unsaved.stanumbers4}::_float4,
            ${unsaved.stanumbers5}::_float4,
            ${unsaved.stavalues1}::anyarray,
            ${unsaved.stavalues2}::anyarray,
            ${unsaved.stavalues3}::anyarray,
            ${unsaved.stavalues4}::anyarray,
            ${unsaved.stavalues5}::anyarray
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
