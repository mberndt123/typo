package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatsExtRepoImpl extends PgStatsExtRepo {
  override def selectAll(implicit c: Connection): List[PgStatsExtRow] = {
    SQL"""select schemaname, tablename, statistics_schemaname, statistics_name, statistics_owner, attnames, exprs, kinds, n_distinct, dependencies, most_common_vals, most_common_val_nulls, most_common_freqs, most_common_base_freqs from pg_catalog.pg_stats_ext""".as(PgStatsExtRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatsExtFieldValue[_]])(implicit c: Connection): List[PgStatsExtRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatsExtFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatsExtFieldValue.tablename(value) => NamedParameter("tablename", ParameterValue.from(value))
          case PgStatsExtFieldValue.statisticsSchemaname(value) => NamedParameter("statistics_schemaname", ParameterValue.from(value))
          case PgStatsExtFieldValue.statisticsName(value) => NamedParameter("statistics_name", ParameterValue.from(value))
          case PgStatsExtFieldValue.statisticsOwner(value) => NamedParameter("statistics_owner", ParameterValue.from(value))
          case PgStatsExtFieldValue.attnames(value) => NamedParameter("attnames", ParameterValue.from(value))
          case PgStatsExtFieldValue.exprs(value) => NamedParameter("exprs", ParameterValue.from(value))
          case PgStatsExtFieldValue.kinds(value) => NamedParameter("kinds", ParameterValue.from(value))
          case PgStatsExtFieldValue.nDistinct(value) => NamedParameter("n_distinct", ParameterValue.from(value))
          case PgStatsExtFieldValue.dependencies(value) => NamedParameter("dependencies", ParameterValue.from(value))
          case PgStatsExtFieldValue.mostCommonVals(value) => NamedParameter("most_common_vals", ParameterValue.from(value))
          case PgStatsExtFieldValue.mostCommonValNulls(value) => NamedParameter("most_common_val_nulls", ParameterValue.from(value))
          case PgStatsExtFieldValue.mostCommonFreqs(value) => NamedParameter("most_common_freqs", ParameterValue.from(value))
          case PgStatsExtFieldValue.mostCommonBaseFreqs(value) => NamedParameter("most_common_base_freqs", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stats_ext where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatsExtRow.rowParser.*)
    }

  }
}
