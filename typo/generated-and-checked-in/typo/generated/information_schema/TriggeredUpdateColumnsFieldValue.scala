/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema



sealed abstract class TriggeredUpdateColumnsFieldValue[T](val name: String, val value: T)

object TriggeredUpdateColumnsFieldValue {
  case class triggerCatalog(override val value: Option[String]) extends TriggeredUpdateColumnsFieldValue("trigger_catalog", value)
  case class triggerSchema(override val value: Option[String]) extends TriggeredUpdateColumnsFieldValue("trigger_schema", value)
  case class triggerName(override val value: Option[String]) extends TriggeredUpdateColumnsFieldValue("trigger_name", value)
  case class eventObjectCatalog(override val value: Option[String]) extends TriggeredUpdateColumnsFieldValue("event_object_catalog", value)
  case class eventObjectSchema(override val value: Option[String]) extends TriggeredUpdateColumnsFieldValue("event_object_schema", value)
  case class eventObjectTable(override val value: Option[String]) extends TriggeredUpdateColumnsFieldValue("event_object_table", value)
  case class eventObjectColumn(override val value: Option[String]) extends TriggeredUpdateColumnsFieldValue("event_object_column", value)
}
