package testdb.information_schema



sealed abstract class ForeignServerOptionsFieldValue[T](val name: String, val value: T)

object ForeignServerOptionsFieldValue {
  case class foreignServerCatalog(override val value: Option[String]) extends ForeignServerOptionsFieldValue("foreign_server_catalog", value)
  case class foreignServerName(override val value: Option[String]) extends ForeignServerOptionsFieldValue("foreign_server_name", value)
  case class optionName(override val value: /* unknown nullability */ Option[String]) extends ForeignServerOptionsFieldValue("option_name", value)
  case class optionValue(override val value: /* unknown nullability */ Option[String]) extends ForeignServerOptionsFieldValue("option_value", value)
}
