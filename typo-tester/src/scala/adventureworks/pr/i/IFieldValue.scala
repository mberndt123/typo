/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package i

import adventureworks.production.illustration.IllustrationId
import java.time.LocalDateTime
import org.postgresql.jdbc.PgSQLXML

sealed abstract class IFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class IFieldValue[T](name: String, value: T) extends IFieldOrIdValue(name, value)

object IFieldValue {
  case class id(override val value: Option[Int]) extends IFieldValue("id", value)
  case class illustrationid(override val value: Option[IllustrationId]) extends IFieldValue("illustrationid", value)
  case class diagram(override val value: Option[PgSQLXML]) extends IFieldValue("diagram", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends IFieldValue("modifieddate", value)
}
