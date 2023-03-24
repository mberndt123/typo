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



sealed abstract class PgUserMappingsFieldValue[T](val name: String, val value: T)

object PgUserMappingsFieldValue {
  case class umid(override val value: Option[Long]) extends PgUserMappingsFieldValue("umid", value)
  case class srvid(override val value: Option[Long]) extends PgUserMappingsFieldValue("srvid", value)
  case class srvname(override val value: Option[String]) extends PgUserMappingsFieldValue("srvname", value)
  case class umuser(override val value: Option[Long]) extends PgUserMappingsFieldValue("umuser", value)
  case class usename(override val value: Option[String]) extends PgUserMappingsFieldValue("usename", value)
  case class umoptions(override val value: Option[Array[String]]) extends PgUserMappingsFieldValue("umoptions", value)
}
