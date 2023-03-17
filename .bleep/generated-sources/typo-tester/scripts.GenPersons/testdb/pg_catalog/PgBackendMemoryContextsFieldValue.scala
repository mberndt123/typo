package testdb.pg_catalog



sealed abstract class PgBackendMemoryContextsFieldValue[T](val name: String, val value: T)

object PgBackendMemoryContextsFieldValue {
  case class name(override val value: /* unknown nullability */ Option[String]) extends PgBackendMemoryContextsFieldValue("name", value)
  case class ident(override val value: /* unknown nullability */ Option[String]) extends PgBackendMemoryContextsFieldValue("ident", value)
  case class parent(override val value: /* unknown nullability */ Option[String]) extends PgBackendMemoryContextsFieldValue("parent", value)
  case class level(override val value: /* unknown nullability */ Option[Int]) extends PgBackendMemoryContextsFieldValue("level", value)
  case class totalBytes(override val value: /* unknown nullability */ Option[Long]) extends PgBackendMemoryContextsFieldValue("total_bytes", value)
  case class totalNblocks(override val value: /* unknown nullability */ Option[Long]) extends PgBackendMemoryContextsFieldValue("total_nblocks", value)
  case class freeBytes(override val value: /* unknown nullability */ Option[Long]) extends PgBackendMemoryContextsFieldValue("free_bytes", value)
  case class freeChunks(override val value: /* unknown nullability */ Option[Long]) extends PgBackendMemoryContextsFieldValue("free_chunks", value)
  case class usedBytes(override val value: /* unknown nullability */ Option[Long]) extends PgBackendMemoryContextsFieldValue("used_bytes", value)
}
