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



sealed abstract class PgStatioAllIndexesFieldValue[T](val name: String, val value: T)

object PgStatioAllIndexesFieldValue {
  case class relid(override val value: Option[Long]) extends PgStatioAllIndexesFieldValue("relid", value)
  case class indexrelid(override val value: Option[Long]) extends PgStatioAllIndexesFieldValue("indexrelid", value)
  case class schemaname(override val value: Option[String]) extends PgStatioAllIndexesFieldValue("schemaname", value)
  case class relname(override val value: Option[String]) extends PgStatioAllIndexesFieldValue("relname", value)
  case class indexrelname(override val value: Option[String]) extends PgStatioAllIndexesFieldValue("indexrelname", value)
  case class idxBlksRead(override val value: Option[Long]) extends PgStatioAllIndexesFieldValue("idx_blks_read", value)
  case class idxBlksHit(override val value: Option[Long]) extends PgStatioAllIndexesFieldValue("idx_blks_hit", value)
}
