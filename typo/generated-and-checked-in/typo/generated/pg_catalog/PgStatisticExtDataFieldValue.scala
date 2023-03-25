/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog



sealed abstract class PgStatisticExtDataFieldValue[T](val name: String, val value: T)

object PgStatisticExtDataFieldValue {
  case class stxoid(override val value: PgStatisticExtDataId) extends PgStatisticExtDataFieldValue("stxoid", value)
  case class stxdndistinct(override val value: Option[String]) extends PgStatisticExtDataFieldValue("stxdndistinct", value)
  case class stxddependencies(override val value: Option[String]) extends PgStatisticExtDataFieldValue("stxddependencies", value)
  case class stxdmcv(override val value: Option[String]) extends PgStatisticExtDataFieldValue("stxdmcv", value)
  case class stxdexpr(override val value: Option[String]) extends PgStatisticExtDataFieldValue("stxdexpr", value)
}
