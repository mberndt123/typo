/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog



sealed abstract class PgStatXactUserFunctionsFieldValue[T](val name: String, val value: T)

object PgStatXactUserFunctionsFieldValue {
  case class funcid(override val value: Option[Long]) extends PgStatXactUserFunctionsFieldValue("funcid", value)
  case class schemaname(override val value: Option[String]) extends PgStatXactUserFunctionsFieldValue("schemaname", value)
  case class funcname(override val value: Option[String]) extends PgStatXactUserFunctionsFieldValue("funcname", value)
  case class calls(override val value: Option[Long]) extends PgStatXactUserFunctionsFieldValue("calls", value)
  case class totalTime(override val value: Option[Double]) extends PgStatXactUserFunctionsFieldValue("total_time", value)
  case class selfTime(override val value: Option[Double]) extends PgStatXactUserFunctionsFieldValue("self_time", value)
}
