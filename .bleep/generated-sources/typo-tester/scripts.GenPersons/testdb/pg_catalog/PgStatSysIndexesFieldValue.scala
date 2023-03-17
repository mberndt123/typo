package testdb.pg_catalog



sealed abstract class PgStatSysIndexesFieldValue[T](val name: String, val value: T)

object PgStatSysIndexesFieldValue {
  case class relid(override val value: Option[Long]) extends PgStatSysIndexesFieldValue("relid", value)
  case class indexrelid(override val value: Option[Long]) extends PgStatSysIndexesFieldValue("indexrelid", value)
  case class schemaname(override val value: Option[String]) extends PgStatSysIndexesFieldValue("schemaname", value)
  case class relname(override val value: Option[String]) extends PgStatSysIndexesFieldValue("relname", value)
  case class indexrelname(override val value: Option[String]) extends PgStatSysIndexesFieldValue("indexrelname", value)
  case class idxScan(override val value: Option[Long]) extends PgStatSysIndexesFieldValue("idx_scan", value)
  case class idxTupRead(override val value: Option[Long]) extends PgStatSysIndexesFieldValue("idx_tup_read", value)
  case class idxTupFetch(override val value: Option[Long]) extends PgStatSysIndexesFieldValue("idx_tup_fetch", value)
}
