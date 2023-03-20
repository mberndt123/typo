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



sealed abstract class PgAuthMembersFieldValue[T](val name: String, val value: T)

object PgAuthMembersFieldValue {
  case class roleid(override val value: Long) extends PgAuthMembersFieldValue("roleid", value)
  case class member(override val value: Long) extends PgAuthMembersFieldValue("member", value)
  case class grantor(override val value: Long) extends PgAuthMembersFieldValue("grantor", value)
  case class adminOption(override val value: Boolean) extends PgAuthMembersFieldValue("admin_option", value)
}
