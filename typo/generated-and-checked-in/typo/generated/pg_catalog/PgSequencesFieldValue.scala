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



sealed abstract class PgSequencesFieldValue[T](val name: String, val value: T)

object PgSequencesFieldValue {
  case class schemaname(override val value: String) extends PgSequencesFieldValue("schemaname", value)
  case class sequencename(override val value: String) extends PgSequencesFieldValue("sequencename", value)
  case class sequenceowner(override val value: /* unknown nullability */ Option[String]) extends PgSequencesFieldValue("sequenceowner", value)
  case class dataType(override val value: /* unknown nullability */ Option[/* regtype */ String]) extends PgSequencesFieldValue("data_type", value)
  case class startValue(override val value: Long) extends PgSequencesFieldValue("start_value", value)
  case class minValue(override val value: Long) extends PgSequencesFieldValue("min_value", value)
  case class maxValue(override val value: Long) extends PgSequencesFieldValue("max_value", value)
  case class incrementBy(override val value: Long) extends PgSequencesFieldValue("increment_by", value)
  case class cycle(override val value: Boolean) extends PgSequencesFieldValue("cycle", value)
  case class cacheSize(override val value: Long) extends PgSequencesFieldValue("cache_size", value)
  case class lastValue(override val value: /* unknown nullability */ Option[Long]) extends PgSequencesFieldValue("last_value", value)
}
