package testdb.pg_catalog



sealed abstract class PgStatXactSysTablesFieldValue[T](val name: String, val value: T)

object PgStatXactSysTablesFieldValue {
  case class relid(override val value: Option[Long]) extends PgStatXactSysTablesFieldValue("relid", value)
  case class schemaname(override val value: Option[String]) extends PgStatXactSysTablesFieldValue("schemaname", value)
  case class relname(override val value: Option[String]) extends PgStatXactSysTablesFieldValue("relname", value)
  case class seqScan(override val value: Option[Long]) extends PgStatXactSysTablesFieldValue("seq_scan", value)
  case class seqTupRead(override val value: Option[Long]) extends PgStatXactSysTablesFieldValue("seq_tup_read", value)
  case class idxScan(override val value: Option[Long]) extends PgStatXactSysTablesFieldValue("idx_scan", value)
  case class idxTupFetch(override val value: Option[Long]) extends PgStatXactSysTablesFieldValue("idx_tup_fetch", value)
  case class nTupIns(override val value: Option[Long]) extends PgStatXactSysTablesFieldValue("n_tup_ins", value)
  case class nTupUpd(override val value: Option[Long]) extends PgStatXactSysTablesFieldValue("n_tup_upd", value)
  case class nTupDel(override val value: Option[Long]) extends PgStatXactSysTablesFieldValue("n_tup_del", value)
  case class nTupHotUpd(override val value: Option[Long]) extends PgStatXactSysTablesFieldValue("n_tup_hot_upd", value)
}
