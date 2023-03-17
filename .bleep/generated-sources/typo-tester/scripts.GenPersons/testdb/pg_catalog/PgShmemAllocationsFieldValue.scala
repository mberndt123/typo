package testdb.pg_catalog



sealed abstract class PgShmemAllocationsFieldValue[T](val name: String, val value: T)

object PgShmemAllocationsFieldValue {
  case class name(override val value: /* unknown nullability */ Option[String]) extends PgShmemAllocationsFieldValue("name", value)
  case class off(override val value: /* unknown nullability */ Option[Long]) extends PgShmemAllocationsFieldValue("off", value)
  case class size(override val value: /* unknown nullability */ Option[Long]) extends PgShmemAllocationsFieldValue("size", value)
  case class allocatedSize(override val value: /* unknown nullability */ Option[Long]) extends PgShmemAllocationsFieldValue("allocated_size", value)
}
