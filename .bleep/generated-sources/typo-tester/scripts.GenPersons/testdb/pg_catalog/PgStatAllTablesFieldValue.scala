package testdb.pg_catalog

import java.time.LocalDateTime

sealed abstract class PgStatAllTablesFieldValue[T](val name: String, val value: T)

object PgStatAllTablesFieldValue {
  case class relid(override val value: Long) extends PgStatAllTablesFieldValue("relid", value)
  case class schemaname(override val value: String) extends PgStatAllTablesFieldValue("schemaname", value)
  case class relname(override val value: String) extends PgStatAllTablesFieldValue("relname", value)
  case class seqScan(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("seq_scan", value)
  case class seqTupRead(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("seq_tup_read", value)
  case class idxScan(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("idx_scan", value)
  case class idxTupFetch(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("idx_tup_fetch", value)
  case class nTupIns(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("n_tup_ins", value)
  case class nTupUpd(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("n_tup_upd", value)
  case class nTupDel(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("n_tup_del", value)
  case class nTupHotUpd(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("n_tup_hot_upd", value)
  case class nLiveTup(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("n_live_tup", value)
  case class nDeadTup(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("n_dead_tup", value)
  case class nModSinceAnalyze(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("n_mod_since_analyze", value)
  case class nInsSinceVacuum(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("n_ins_since_vacuum", value)
  case class lastVacuum(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgStatAllTablesFieldValue("last_vacuum", value)
  case class lastAutovacuum(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgStatAllTablesFieldValue("last_autovacuum", value)
  case class lastAnalyze(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgStatAllTablesFieldValue("last_analyze", value)
  case class lastAutoanalyze(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgStatAllTablesFieldValue("last_autoanalyze", value)
  case class vacuumCount(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("vacuum_count", value)
  case class autovacuumCount(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("autovacuum_count", value)
  case class analyzeCount(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("analyze_count", value)
  case class autoanalyzeCount(override val value: /* unknown nullability */ Option[Long]) extends PgStatAllTablesFieldValue("autoanalyze_count", value)
}
