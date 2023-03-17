package testdb.pg_catalog



sealed abstract class PgPoliciesFieldValue[T](val name: String, val value: T)

object PgPoliciesFieldValue {
  case class schemaname(override val value: String) extends PgPoliciesFieldValue("schemaname", value)
  case class tablename(override val value: String) extends PgPoliciesFieldValue("tablename", value)
  case class policyname(override val value: String) extends PgPoliciesFieldValue("policyname", value)
  case class permissive(override val value: /* unknown nullability */ Option[String]) extends PgPoliciesFieldValue("permissive", value)
  case class roles(override val value: /* typo doesn't know how to translate: columnType: Array, columnTypeName: _name, columnClassName: java.sql.Array */ Any) extends PgPoliciesFieldValue("roles", value)
  case class cmd(override val value: /* unknown nullability */ Option[String]) extends PgPoliciesFieldValue("cmd", value)
  case class qual(override val value: /* unknown nullability */ Option[String]) extends PgPoliciesFieldValue("qual", value)
  case class withCheck(override val value: /* unknown nullability */ Option[String]) extends PgPoliciesFieldValue("with_check", value)
}
