/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesreason;

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

/** This class corresponds to a row in table `sales.salesreason` which has not been persisted yet */
case class SalesreasonRowUnsaved(
  /** Sales reason description. */
  name: Name,
  /** Category the sales reason belongs to. */
  reasontype: Name,
  /** Default: nextval('sales.salesreason_salesreasonid_seq'::regclass)
    * Primary key for SalesReason records.
    */
  salesreasonid: Defaulted[SalesreasonId] = Defaulted.UseDefault(),
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault()
) {
  def toRow(salesreasonidDefault: => SalesreasonId, modifieddateDefault: => TypoLocalDateTime): SalesreasonRow = {
    new SalesreasonRow(
      salesreasonid = salesreasonid.getOrElse(salesreasonidDefault),
      name = name,
      reasontype = reasontype,
      modifieddate = modifieddate.getOrElse(modifieddateDefault)
    )
  }
}

object SalesreasonRowUnsaved {
  implicit lazy val reads: Reads[SalesreasonRowUnsaved] = {
    Reads[SalesreasonRowUnsaved](json => JsResult.fromTry(
        Try(
          SalesreasonRowUnsaved(
            name = json.\("name").as(Name.reads),
            reasontype = json.\("reasontype").as(Name.reads),
            salesreasonid = json.\("salesreasonid").as(Defaulted.reads(SalesreasonId.reads)),
            modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
          )
        )
      ),
    )
  }
  implicit lazy val text: Text[SalesreasonRowUnsaved] = {
    Text.instance[SalesreasonRowUnsaved]{ (row, sb) =>
      Name.text.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      Name.text.unsafeEncode(row.reasontype, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(SalesreasonId.text).unsafeEncode(row.salesreasonid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val writes: OWrites[SalesreasonRowUnsaved] = {
    OWrites[SalesreasonRowUnsaved](o =>
      new JsObject(ListMap[String, JsValue](
        "name" -> Name.writes.writes(o.name),
        "reasontype" -> Name.writes.writes(o.reasontype),
        "salesreasonid" -> Defaulted.writes(SalesreasonId.writes).writes(o.salesreasonid),
        "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
      ))
    )
  }
}