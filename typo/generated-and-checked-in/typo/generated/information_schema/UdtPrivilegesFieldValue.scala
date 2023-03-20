/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema



sealed abstract class UdtPrivilegesFieldValue[T](val name: String, val value: T)

object UdtPrivilegesFieldValue {
  case class grantor(override val value: /* unknown nullability */ Option[String]) extends UdtPrivilegesFieldValue("grantor", value)
  case class grantee(override val value: /* unknown nullability */ Option[String]) extends UdtPrivilegesFieldValue("grantee", value)
  case class udtCatalog(override val value: /* unknown nullability */ Option[String]) extends UdtPrivilegesFieldValue("udt_catalog", value)
  case class udtSchema(override val value: /* unknown nullability */ Option[String]) extends UdtPrivilegesFieldValue("udt_schema", value)
  case class udtName(override val value: /* unknown nullability */ Option[String]) extends UdtPrivilegesFieldValue("udt_name", value)
  case class privilegeType(override val value: /* unknown nullability */ Option[String]) extends UdtPrivilegesFieldValue("privilege_type", value)
  case class isGrantable(override val value: /* unknown nullability */ Option[String]) extends UdtPrivilegesFieldValue("is_grantable", value)
}
