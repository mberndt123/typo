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

import java.time.ZonedDateTime

sealed abstract class PgStatUserTablesFieldValue[T](val name: String, val value: T)

object PgStatUserTablesFieldValue {
  case class relid(override val value: Option[Long]) extends PgStatUserTablesFieldValue("relid", value)
  case class schemaname(override val value: Option[String]) extends PgStatUserTablesFieldValue("schemaname", value)
  case class relname(override val value: Option[String]) extends PgStatUserTablesFieldValue("relname", value)
  case class seqScan(override val value: Option[Long]) extends PgStatUserTablesFieldValue("seq_scan", value)
  case class seqTupRead(override val value: Option[Long]) extends PgStatUserTablesFieldValue("seq_tup_read", value)
  case class idxScan(override val value: Option[Long]) extends PgStatUserTablesFieldValue("idx_scan", value)
  case class idxTupFetch(override val value: Option[Long]) extends PgStatUserTablesFieldValue("idx_tup_fetch", value)
  case class nTupIns(override val value: Option[Long]) extends PgStatUserTablesFieldValue("n_tup_ins", value)
  case class nTupUpd(override val value: Option[Long]) extends PgStatUserTablesFieldValue("n_tup_upd", value)
  case class nTupDel(override val value: Option[Long]) extends PgStatUserTablesFieldValue("n_tup_del", value)
  case class nTupHotUpd(override val value: Option[Long]) extends PgStatUserTablesFieldValue("n_tup_hot_upd", value)
  case class nLiveTup(override val value: Option[Long]) extends PgStatUserTablesFieldValue("n_live_tup", value)
  case class nDeadTup(override val value: Option[Long]) extends PgStatUserTablesFieldValue("n_dead_tup", value)
  case class nModSinceAnalyze(override val value: Option[Long]) extends PgStatUserTablesFieldValue("n_mod_since_analyze", value)
  case class nInsSinceVacuum(override val value: Option[Long]) extends PgStatUserTablesFieldValue("n_ins_since_vacuum", value)
  case class lastVacuum(override val value: Option[ZonedDateTime]) extends PgStatUserTablesFieldValue("last_vacuum", value)
  case class lastAutovacuum(override val value: Option[ZonedDateTime]) extends PgStatUserTablesFieldValue("last_autovacuum", value)
  case class lastAnalyze(override val value: Option[ZonedDateTime]) extends PgStatUserTablesFieldValue("last_analyze", value)
  case class lastAutoanalyze(override val value: Option[ZonedDateTime]) extends PgStatUserTablesFieldValue("last_autoanalyze", value)
  case class vacuumCount(override val value: Option[Long]) extends PgStatUserTablesFieldValue("vacuum_count", value)
  case class autovacuumCount(override val value: Option[Long]) extends PgStatUserTablesFieldValue("autovacuum_count", value)
  case class analyzeCount(override val value: Option[Long]) extends PgStatUserTablesFieldValue("analyze_count", value)
  case class autoanalyzeCount(override val value: Option[Long]) extends PgStatUserTablesFieldValue("autoanalyze_count", value)
}
