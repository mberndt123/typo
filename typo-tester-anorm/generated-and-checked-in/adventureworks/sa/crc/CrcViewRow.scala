/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.crc;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.person.countryregion.CountryregionId;
import adventureworks.sales.currency.CurrencyId;
import anorm.RowParser;
import anorm.Success;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** View: sa.crc */
case class CrcViewRow(/** Points to [[adventureworks.sales.countryregioncurrency.CountryregioncurrencyRow.countryregioncode]] */
                      countryregioncode: CountryregionId, /** Points to [[adventureworks.sales.countryregioncurrency.CountryregioncurrencyRow.currencycode]] */
                      currencycode: CurrencyId, /** Points to [[adventureworks.sales.countryregioncurrency.CountryregioncurrencyRow.modifieddate]] */
                      modifieddate: TypoLocalDateTime)

object CrcViewRow {
  implicit lazy val reads: Reads[CrcViewRow] = {
    Reads[CrcViewRow](json => JsResult.fromTry(
        Try(
          CrcViewRow(
            countryregioncode = json.\("countryregioncode").as(CountryregionId.reads),
            currencycode = json.\("currencycode").as(CurrencyId.reads),
            modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[CrcViewRow] = {
    RowParser[CrcViewRow] { row =>
      Success(
        CrcViewRow(
          countryregioncode = row(idx + 0)(CountryregionId.column),
          currencycode = row(idx + 1)(CurrencyId.column),
          modifieddate = row(idx + 2)(TypoLocalDateTime.column)
        )
      )
    }
  }
  implicit lazy val writes: OWrites[CrcViewRow] = {
    OWrites[CrcViewRow](o =>
      new JsObject(ListMap[String, JsValue](
        "countryregioncode" -> CountryregionId.writes.writes(o.countryregioncode),
        "currencycode" -> CurrencyId.writes.writes(o.currencycode),
        "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
      ))
    )
  }
}