package testdb.pg_catalog

import java.time.LocalDateTime

sealed abstract class PgStatSysTablesFieldValue[T](val name: String, val value: T)

object PgStatSysTablesFieldValue {
  case class relid(override val value: Option[Long]) extends PgStatSysTablesFieldValue("relid", value)
  case class schemaname(override val value: Option[String]) extends PgStatSysTablesFieldValue("schemaname", value)
  case class relname(override val value: Option[String]) extends PgStatSysTablesFieldValue("relname", value)
  case class seqScan(override val value: Option[Long]) extends PgStatSysTablesFieldValue("seq_scan", value)
  case class seqTupRead(override val value: Option[Long]) extends PgStatSysTablesFieldValue("seq_tup_read", value)
  case class idxScan(override val value: Option[Long]) extends PgStatSysTablesFieldValue("idx_scan", value)
  case class idxTupFetch(override val value: Option[Long]) extends PgStatSysTablesFieldValue("idx_tup_fetch", value)
  case class nTupIns(override val value: Option[Long]) extends PgStatSysTablesFieldValue("n_tup_ins", value)
  case class nTupUpd(override val value: Option[Long]) extends PgStatSysTablesFieldValue("n_tup_upd", value)
  case class nTupDel(override val value: Option[Long]) extends PgStatSysTablesFieldValue("n_tup_del", value)
  case class nTupHotUpd(override val value: Option[Long]) extends PgStatSysTablesFieldValue("n_tup_hot_upd", value)
  case class nLiveTup(override val value: Option[Long]) extends PgStatSysTablesFieldValue("n_live_tup", value)
  case class nDeadTup(override val value: Option[Long]) extends PgStatSysTablesFieldValue("n_dead_tup", value)
  case class nModSinceAnalyze(override val value: Option[Long]) extends PgStatSysTablesFieldValue("n_mod_since_analyze", value)
  case class nInsSinceVacuum(override val value: Option[Long]) extends PgStatSysTablesFieldValue("n_ins_since_vacuum", value)
  case class lastVacuum(override val value: Option[LocalDateTime]) extends PgStatSysTablesFieldValue("last_vacuum", value)
  case class lastAutovacuum(override val value: Option[LocalDateTime]) extends PgStatSysTablesFieldValue("last_autovacuum", value)
  case class lastAnalyze(override val value: Option[LocalDateTime]) extends PgStatSysTablesFieldValue("last_analyze", value)
  case class lastAutoanalyze(override val value: Option[LocalDateTime]) extends PgStatSysTablesFieldValue("last_autoanalyze", value)
  case class vacuumCount(override val value: Option[Long]) extends PgStatSysTablesFieldValue("vacuum_count", value)
  case class autovacuumCount(override val value: Option[Long]) extends PgStatSysTablesFieldValue("autovacuum_count", value)
  case class analyzeCount(override val value: Option[Long]) extends PgStatSysTablesFieldValue("analyze_count", value)
  case class autoanalyzeCount(override val value: Option[Long]) extends PgStatSysTablesFieldValue("autoanalyze_count", value)
}
