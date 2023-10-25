/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class CountryregionRow(
  /** ISO standard code for countries and regions. */
  countryregioncode: CountryregionId,
  /** Country or region name. */
  name: Name,
  modifieddate: TypoLocalDateTime
)

object CountryregionRow {
  implicit lazy val reads: Reads[CountryregionRow] = Reads[CountryregionRow](json => JsResult.fromTry(
      Try(
        CountryregionRow(
          countryregioncode = json.\("countryregioncode").as(CountryregionId.reads),
          name = json.\("name").as(Name.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CountryregionRow] = RowParser[CountryregionRow] { row =>
    Success(
      CountryregionRow(
        countryregioncode = row(idx + 0)(CountryregionId.column),
        name = row(idx + 1)(Name.column),
        modifieddate = row(idx + 2)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[CountryregionRow] = Text.instance[CountryregionRow]{ (row, sb) =>
    CountryregionId.text.unsafeEncode(row.countryregioncode, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[CountryregionRow] = OWrites[CountryregionRow](o =>
    new JsObject(ListMap[String, JsValue](
      "countryregioncode" -> CountryregionId.writes.writes(o.countryregioncode),
      "name" -> Name.writes.writes(o.name),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
