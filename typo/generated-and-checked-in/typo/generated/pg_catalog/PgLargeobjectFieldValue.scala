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



sealed abstract class PgLargeobjectFieldValue[T](val name: String, val value: T)

object PgLargeobjectFieldValue {
  case class loid(override val value: Long) extends PgLargeobjectFieldValue("loid", value)
  case class pageno(override val value: Int) extends PgLargeobjectFieldValue("pageno", value)
  case class data(override val value: String) extends PgLargeobjectFieldValue("data", value)
}
