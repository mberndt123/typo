package testdb.information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class SequencesRow(
  sequenceCatalog: /* unknown nullability */ Option[String],
  sequenceSchema: /* unknown nullability */ Option[String],
  sequenceName: /* unknown nullability */ Option[String],
  dataType: /* unknown nullability */ Option[String],
  numericPrecision: /* unknown nullability */ Option[Int],
  numericPrecisionRadix: /* unknown nullability */ Option[Int],
  numericScale: /* unknown nullability */ Option[Int],
  startValue: /* unknown nullability */ Option[String],
  minimumValue: /* unknown nullability */ Option[String],
  maximumValue: /* unknown nullability */ Option[String],
  increment: /* unknown nullability */ Option[String],
  cycleOption: /* unknown nullability */ Option[String]
)

object SequencesRow {
  implicit val rowParser: RowParser[SequencesRow] = { row =>
    Success(
      SequencesRow(
        sequenceCatalog = row[/* unknown nullability */ Option[String]]("sequence_catalog"),
        sequenceSchema = row[/* unknown nullability */ Option[String]]("sequence_schema"),
        sequenceName = row[/* unknown nullability */ Option[String]]("sequence_name"),
        dataType = row[/* unknown nullability */ Option[String]]("data_type"),
        numericPrecision = row[/* unknown nullability */ Option[Int]]("numeric_precision"),
        numericPrecisionRadix = row[/* unknown nullability */ Option[Int]]("numeric_precision_radix"),
        numericScale = row[/* unknown nullability */ Option[Int]]("numeric_scale"),
        startValue = row[/* unknown nullability */ Option[String]]("start_value"),
        minimumValue = row[/* unknown nullability */ Option[String]]("minimum_value"),
        maximumValue = row[/* unknown nullability */ Option[String]]("maximum_value"),
        increment = row[/* unknown nullability */ Option[String]]("increment"),
        cycleOption = row[/* unknown nullability */ Option[String]]("cycle_option")
      )
    )
  }

  implicit val oFormat: OFormat[SequencesRow] = Json.format
}
