package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatAllTablesRepoImpl extends PgStatAllTablesRepo {
  override def selectAll(implicit c: Connection): List[PgStatAllTablesRow] = {
    SQL"""select relid, schemaname, relname, seq_scan, seq_tup_read, idx_scan, idx_tup_fetch, n_tup_ins, n_tup_upd, n_tup_del, n_tup_hot_upd, n_live_tup, n_dead_tup, n_mod_since_analyze, n_ins_since_vacuum, last_vacuum, last_autovacuum, last_analyze, last_autoanalyze, vacuum_count, autovacuum_count, analyze_count, autoanalyze_count from pg_catalog.pg_stat_all_tables""".as(PgStatAllTablesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatAllTablesFieldValue[_]])(implicit c: Connection): List[PgStatAllTablesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatAllTablesFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.seqScan(value) => NamedParameter("seq_scan", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.seqTupRead(value) => NamedParameter("seq_tup_read", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.idxScan(value) => NamedParameter("idx_scan", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.idxTupFetch(value) => NamedParameter("idx_tup_fetch", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.nTupIns(value) => NamedParameter("n_tup_ins", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.nTupUpd(value) => NamedParameter("n_tup_upd", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.nTupDel(value) => NamedParameter("n_tup_del", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.nTupHotUpd(value) => NamedParameter("n_tup_hot_upd", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.nLiveTup(value) => NamedParameter("n_live_tup", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.nDeadTup(value) => NamedParameter("n_dead_tup", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.nModSinceAnalyze(value) => NamedParameter("n_mod_since_analyze", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.nInsSinceVacuum(value) => NamedParameter("n_ins_since_vacuum", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.lastVacuum(value) => NamedParameter("last_vacuum", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.lastAutovacuum(value) => NamedParameter("last_autovacuum", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.lastAnalyze(value) => NamedParameter("last_analyze", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.lastAutoanalyze(value) => NamedParameter("last_autoanalyze", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.vacuumCount(value) => NamedParameter("vacuum_count", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.autovacuumCount(value) => NamedParameter("autovacuum_count", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.analyzeCount(value) => NamedParameter("analyze_count", ParameterValue.from(value))
          case PgStatAllTablesFieldValue.autoanalyzeCount(value) => NamedParameter("autoanalyze_count", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_all_tables where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatAllTablesRow.rowParser.*)
    }

  }
}
