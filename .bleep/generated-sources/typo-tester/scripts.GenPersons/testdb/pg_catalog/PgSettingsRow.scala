package testdb.pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class PgSettingsRow(
  name: /* unknown nullability */ Option[String],
  setting: /* unknown nullability */ Option[String],
  unit: /* unknown nullability */ Option[String],
  category: /* unknown nullability */ Option[String],
  shortDesc: /* unknown nullability */ Option[String],
  extraDesc: /* unknown nullability */ Option[String],
  context: /* unknown nullability */ Option[String],
  vartype: /* unknown nullability */ Option[String],
  source: /* unknown nullability */ Option[String],
  minVal: /* unknown nullability */ Option[String],
  maxVal: /* unknown nullability */ Option[String],
  enumvals: /* unknown nullability */ Option[Array[String]],
  bootVal: /* unknown nullability */ Option[String],
  resetVal: /* unknown nullability */ Option[String],
  sourcefile: /* unknown nullability */ Option[String],
  sourceline: /* unknown nullability */ Option[Int],
  pendingRestart: /* unknown nullability */ Option[Boolean]
)

object PgSettingsRow {
  implicit val rowParser: RowParser[PgSettingsRow] = { row =>
    Success(
      PgSettingsRow(
        name = row[/* unknown nullability */ Option[String]]("name"),
        setting = row[/* unknown nullability */ Option[String]]("setting"),
        unit = row[/* unknown nullability */ Option[String]]("unit"),
        category = row[/* unknown nullability */ Option[String]]("category"),
        shortDesc = row[/* unknown nullability */ Option[String]]("short_desc"),
        extraDesc = row[/* unknown nullability */ Option[String]]("extra_desc"),
        context = row[/* unknown nullability */ Option[String]]("context"),
        vartype = row[/* unknown nullability */ Option[String]]("vartype"),
        source = row[/* unknown nullability */ Option[String]]("source"),
        minVal = row[/* unknown nullability */ Option[String]]("min_val"),
        maxVal = row[/* unknown nullability */ Option[String]]("max_val"),
        enumvals = row[/* unknown nullability */ Option[Array[String]]]("enumvals"),
        bootVal = row[/* unknown nullability */ Option[String]]("boot_val"),
        resetVal = row[/* unknown nullability */ Option[String]]("reset_val"),
        sourcefile = row[/* unknown nullability */ Option[String]]("sourcefile"),
        sourceline = row[/* unknown nullability */ Option[Int]]("sourceline"),
        pendingRestart = row[/* unknown nullability */ Option[Boolean]]("pending_restart")
      )
    )
  }

  implicit val oFormat: OFormat[PgSettingsRow] = Json.format
}
