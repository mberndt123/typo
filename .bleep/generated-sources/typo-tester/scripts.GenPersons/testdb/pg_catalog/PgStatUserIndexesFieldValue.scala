package testdb.pg_catalog



sealed abstract class PgStatUserIndexesFieldValue[T](val name: String, val value: T)

object PgStatUserIndexesFieldValue {
  case class relid(override val value: Option[Long]) extends PgStatUserIndexesFieldValue("relid", value)
  case class indexrelid(override val value: Option[Long]) extends PgStatUserIndexesFieldValue("indexrelid", value)
  case class schemaname(override val value: Option[String]) extends PgStatUserIndexesFieldValue("schemaname", value)
  case class relname(override val value: Option[String]) extends PgStatUserIndexesFieldValue("relname", value)
  case class indexrelname(override val value: Option[String]) extends PgStatUserIndexesFieldValue("indexrelname", value)
  case class idxScan(override val value: Option[Long]) extends PgStatUserIndexesFieldValue("idx_scan", value)
  case class idxTupRead(override val value: Option[Long]) extends PgStatUserIndexesFieldValue("idx_tup_read", value)
  case class idxTupFetch(override val value: Option[Long]) extends PgStatUserIndexesFieldValue("idx_tup_fetch", value)
}
