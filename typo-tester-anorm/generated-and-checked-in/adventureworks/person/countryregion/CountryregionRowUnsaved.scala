/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.countryregion;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.public.Name;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** This class corresponds to a row in table `person.countryregion` which has not been persisted yet */
case class CountryregionRowUnsaved(/** ISO standard code for countries and regions. */
                                   countryregioncode: CountryregionId, /** Country or region name. */
                                   name: Name, /** Default: now() */
                                   modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault()) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): CountryregionRow = new CountryregionRow(countryregioncode = countryregioncode, name = name, modifieddate = modifieddate.getOrElse(modifieddateDefault))
}

object CountryregionRowUnsaved {
  implicit lazy val reads: Reads[CountryregionRowUnsaved] = {
    Reads[CountryregionRowUnsaved](json => JsResult.fromTry(
        Try(
          CountryregionRowUnsaved(
            countryregioncode = json.\("countryregioncode").as(CountryregionId.reads),
            name = json.\("name").as(Name.reads),
            modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
          )
        )
      ),
    )
  }
  implicit lazy val text: Text[CountryregionRowUnsaved] = {
    Text.instance[CountryregionRowUnsaved]{ (row, sb) =>
      CountryregionId.text.unsafeEncode(row.countryregioncode, sb)
      sb.append(Text.DELIMETER)
      Name.text.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val writes: OWrites[CountryregionRowUnsaved] = {
    OWrites[CountryregionRowUnsaved](o =>
      new JsObject(ListMap[String, JsValue](
        "countryregioncode" -> CountryregionId.writes.writes(o.countryregioncode),
        "name" -> Name.writes.writes(o.name),
        "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
      ))
    )
  }
}