package testdb.information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class TransformsRow(
  udtCatalog: /* unknown nullability */ Option[String],
  udtSchema: /* unknown nullability */ Option[String],
  udtName: /* unknown nullability */ Option[String],
  specificCatalog: /* unknown nullability */ Option[String],
  specificSchema: /* unknown nullability */ Option[String],
  specificName: /* unknown nullability */ Option[String],
  groupName: /* unknown nullability */ Option[String],
  transformType: /* unknown nullability */ Option[String]
)

object TransformsRow {
  implicit val rowParser: RowParser[TransformsRow] = { row =>
    Success(
      TransformsRow(
        udtCatalog = row[/* unknown nullability */ Option[String]]("udt_catalog"),
        udtSchema = row[/* unknown nullability */ Option[String]]("udt_schema"),
        udtName = row[/* unknown nullability */ Option[String]]("udt_name"),
        specificCatalog = row[/* unknown nullability */ Option[String]]("specific_catalog"),
        specificSchema = row[/* unknown nullability */ Option[String]]("specific_schema"),
        specificName = row[/* unknown nullability */ Option[String]]("specific_name"),
        groupName = row[/* unknown nullability */ Option[String]]("group_name"),
        transformType = row[/* unknown nullability */ Option[String]]("transform_type")
      )
    )
  }

  implicit val oFormat: OFormat[TransformsRow] = Json.format
}
