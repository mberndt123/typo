/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pm

import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import org.postgresql.jdbc.PgSQLXML

sealed abstract class PmFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PmFieldValue[T](name: String, value: T) extends PmFieldOrIdValue(name, value)

object PmFieldValue {
  case class id(override val value: Option[Int]) extends PmFieldValue("id", value)
  case class productmodelid(override val value: Option[ProductmodelId]) extends PmFieldValue("productmodelid", value)
  case class name(override val value: Option[Name]) extends PmFieldValue("name", value)
  case class catalogdescription(override val value: Option[PgSQLXML]) extends PmFieldValue("catalogdescription", value)
  case class instructions(override val value: Option[PgSQLXML]) extends PmFieldValue("instructions", value)
  case class rowguid(override val value: Option[UUID]) extends PmFieldValue("rowguid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends PmFieldValue("modifieddate", value)
}
