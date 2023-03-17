package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatProgressAnalyzeRepoImpl extends PgStatProgressAnalyzeRepo {
  override def selectAll(implicit c: Connection): List[PgStatProgressAnalyzeRow] = {
    SQL"""select pid, datid, datname, relid, phase, sample_blks_total, sample_blks_scanned, ext_stats_total, ext_stats_computed, child_tables_total, child_tables_done, current_child_table_relid from pg_catalog.pg_stat_progress_analyze""".as(PgStatProgressAnalyzeRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatProgressAnalyzeFieldValue[_]])(implicit c: Connection): List[PgStatProgressAnalyzeRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatProgressAnalyzeFieldValue.pid(value) => NamedParameter("pid", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.datid(value) => NamedParameter("datid", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.datname(value) => NamedParameter("datname", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.phase(value) => NamedParameter("phase", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.sampleBlksTotal(value) => NamedParameter("sample_blks_total", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.sampleBlksScanned(value) => NamedParameter("sample_blks_scanned", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.extStatsTotal(value) => NamedParameter("ext_stats_total", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.extStatsComputed(value) => NamedParameter("ext_stats_computed", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.childTablesTotal(value) => NamedParameter("child_tables_total", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.childTablesDone(value) => NamedParameter("child_tables_done", ParameterValue.from(value))
          case PgStatProgressAnalyzeFieldValue.currentChildTableRelid(value) => NamedParameter("current_child_table_relid", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_progress_analyze where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatProgressAnalyzeRow.rowParser.*)
    }

  }
}
