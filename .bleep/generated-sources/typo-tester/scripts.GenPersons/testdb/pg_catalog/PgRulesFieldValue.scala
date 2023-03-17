package testdb.pg_catalog



sealed abstract class PgRulesFieldValue[T](val name: String, val value: T)

object PgRulesFieldValue {
  case class schemaname(override val value: String) extends PgRulesFieldValue("schemaname", value)
  case class tablename(override val value: String) extends PgRulesFieldValue("tablename", value)
  case class rulename(override val value: String) extends PgRulesFieldValue("rulename", value)
  case class definition(override val value: /* unknown nullability */ Option[String]) extends PgRulesFieldValue("definition", value)
}
