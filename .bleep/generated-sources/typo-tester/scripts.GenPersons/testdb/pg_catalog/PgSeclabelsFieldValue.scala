package testdb.pg_catalog



sealed abstract class PgSeclabelsFieldValue[T](val name: String, val value: T)

object PgSeclabelsFieldValue {
  case class objoid(override val value: /* unknown nullability */ Option[Long]) extends PgSeclabelsFieldValue("objoid", value)
  case class classoid(override val value: /* unknown nullability */ Option[Long]) extends PgSeclabelsFieldValue("classoid", value)
  case class objsubid(override val value: /* unknown nullability */ Option[Int]) extends PgSeclabelsFieldValue("objsubid", value)
  case class objtype(override val value: /* unknown nullability */ Option[String]) extends PgSeclabelsFieldValue("objtype", value)
  case class objnamespace(override val value: /* unknown nullability */ Option[Long]) extends PgSeclabelsFieldValue("objnamespace", value)
  case class objname(override val value: /* unknown nullability */ Option[String]) extends PgSeclabelsFieldValue("objname", value)
  case class provider(override val value: /* unknown nullability */ Option[String]) extends PgSeclabelsFieldValue("provider", value)
  case class label(override val value: /* unknown nullability */ Option[String]) extends PgSeclabelsFieldValue("label", value)
}
