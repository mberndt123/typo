package testdb.information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class TriggeredUpdateColumnsRow(
  triggerCatalog: /* unknown nullability */ Option[String],
  triggerSchema: /* unknown nullability */ Option[String],
  triggerName: /* unknown nullability */ Option[String],
  eventObjectCatalog: /* unknown nullability */ Option[String],
  eventObjectSchema: /* unknown nullability */ Option[String],
  eventObjectTable: /* unknown nullability */ Option[String],
  eventObjectColumn: /* unknown nullability */ Option[String]
)

object TriggeredUpdateColumnsRow {
  implicit val rowParser: RowParser[TriggeredUpdateColumnsRow] = { row =>
    Success(
      TriggeredUpdateColumnsRow(
        triggerCatalog = row[/* unknown nullability */ Option[String]]("trigger_catalog"),
        triggerSchema = row[/* unknown nullability */ Option[String]]("trigger_schema"),
        triggerName = row[/* unknown nullability */ Option[String]]("trigger_name"),
        eventObjectCatalog = row[/* unknown nullability */ Option[String]]("event_object_catalog"),
        eventObjectSchema = row[/* unknown nullability */ Option[String]]("event_object_schema"),
        eventObjectTable = row[/* unknown nullability */ Option[String]]("event_object_table"),
        eventObjectColumn = row[/* unknown nullability */ Option[String]]("event_object_column")
      )
    )
  }

  implicit val oFormat: OFormat[TriggeredUpdateColumnsRow] = Json.format
}
