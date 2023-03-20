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



sealed abstract class PgCastFieldValue[T](val name: String, val value: T)

object PgCastFieldValue {
  case class oid(override val value: PgCastId) extends PgCastFieldValue("oid", value)
  case class castsource(override val value: Long) extends PgCastFieldValue("castsource", value)
  case class casttarget(override val value: Long) extends PgCastFieldValue("casttarget", value)
  case class castfunc(override val value: Long) extends PgCastFieldValue("castfunc", value)
  case class castcontext(override val value: String) extends PgCastFieldValue("castcontext", value)
  case class castmethod(override val value: String) extends PgCastFieldValue("castmethod", value)
}
