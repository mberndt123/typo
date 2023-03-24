/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog



sealed abstract class PgShmemAllocationsFieldValue[T](val name: String, val value: T)

object PgShmemAllocationsFieldValue {
  case class name(override val value: Option[String]) extends PgShmemAllocationsFieldValue("name", value)
  case class off(override val value: Option[Long]) extends PgShmemAllocationsFieldValue("off", value)
  case class size(override val value: Option[Long]) extends PgShmemAllocationsFieldValue("size", value)
  case class allocatedSize(override val value: Option[Long]) extends PgShmemAllocationsFieldValue("allocated_size", value)
}
