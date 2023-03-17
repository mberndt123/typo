package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatsExtExprsRepoImpl extends PgStatsExtExprsRepo {
  override def selectAll(implicit c: Connection): List[PgStatsExtExprsRow] = {
    SQL"""select schemaname, tablename, statistics_schemaname, statistics_name, statistics_owner, expr, null_frac, avg_width, n_distinct, most_common_vals, most_common_freqs, histogram_bounds, correlation, most_common_elems, most_common_elem_freqs, elem_count_histogram from pg_catalog.pg_stats_ext_exprs""".as(PgStatsExtExprsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatsExtExprsFieldValue[_]])(implicit c: Connection): List[PgStatsExtExprsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatsExtExprsFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.tablename(value) => NamedParameter("tablename", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.statisticsSchemaname(value) => NamedParameter("statistics_schemaname", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.statisticsName(value) => NamedParameter("statistics_name", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.statisticsOwner(value) => NamedParameter("statistics_owner", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.expr(value) => NamedParameter("expr", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.nullFrac(value) => NamedParameter("null_frac", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.avgWidth(value) => NamedParameter("avg_width", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.nDistinct(value) => NamedParameter("n_distinct", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.mostCommonVals(value) => NamedParameter("most_common_vals", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.mostCommonFreqs(value) => NamedParameter("most_common_freqs", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.histogramBounds(value) => NamedParameter("histogram_bounds", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.correlation(value) => NamedParameter("correlation", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.mostCommonElems(value) => NamedParameter("most_common_elems", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.mostCommonElemFreqs(value) => NamedParameter("most_common_elem_freqs", ParameterValue.from(value))
          case PgStatsExtExprsFieldValue.elemCountHistogram(value) => NamedParameter("elem_count_histogram", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stats_ext_exprs where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatsExtExprsRow.rowParser.*)
    }

  }
}
