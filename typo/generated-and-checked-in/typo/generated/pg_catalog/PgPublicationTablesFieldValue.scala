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



sealed abstract class PgPublicationTablesFieldValue[T](val name: String, val value: T)

object PgPublicationTablesFieldValue {
  case class pubname(override val value: Option[String]) extends PgPublicationTablesFieldValue("pubname", value)
  case class schemaname(override val value: Option[String]) extends PgPublicationTablesFieldValue("schemaname", value)
  case class tablename(override val value: Option[String]) extends PgPublicationTablesFieldValue("tablename", value)
}
