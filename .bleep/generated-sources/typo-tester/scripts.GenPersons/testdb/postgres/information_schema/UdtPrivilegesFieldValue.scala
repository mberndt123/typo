/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema



sealed abstract class UdtPrivilegesFieldValue[T](val name: String, val value: T)

object UdtPrivilegesFieldValue {
  case class grantor(override val value: Option[String]) extends UdtPrivilegesFieldValue("grantor", value)
  case class grantee(override val value: Option[String]) extends UdtPrivilegesFieldValue("grantee", value)
  case class udtCatalog(override val value: Option[String]) extends UdtPrivilegesFieldValue("udt_catalog", value)
  case class udtSchema(override val value: Option[String]) extends UdtPrivilegesFieldValue("udt_schema", value)
  case class udtName(override val value: Option[String]) extends UdtPrivilegesFieldValue("udt_name", value)
  case class privilegeType(override val value: Option[String]) extends UdtPrivilegesFieldValue("privilege_type", value)
  case class isGrantable(override val value: Option[String]) extends UdtPrivilegesFieldValue("is_grantable", value)
}
