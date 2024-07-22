/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.specialofferproduct;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.production.product.ProductId;
import adventureworks.sales.specialoffer.SpecialofferId;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** This class corresponds to a row in table `sales.specialofferproduct` which has not been persisted yet */
case class SpecialofferproductRowUnsaved(
  /** Primary key for SpecialOfferProduct records.
    * Points to [[adventureworks.sales.specialoffer.SpecialofferRow.specialofferid]]
    */
  specialofferid: SpecialofferId,
  /** Product identification number. Foreign key to Product.ProductID.
    * Points to [[adventureworks.production.product.ProductRow.productid]]
    */
  productid: ProductId,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault(),
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault()
) {
  def toRow(rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): SpecialofferproductRow = {
    new SpecialofferproductRow(
      specialofferid = specialofferid,
      productid = productid,
      rowguid = rowguid.getOrElse(rowguidDefault),
      modifieddate = modifieddate.getOrElse(modifieddateDefault)
    )
  }
}

object SpecialofferproductRowUnsaved {
  implicit lazy val reads: Reads[SpecialofferproductRowUnsaved] = {
    Reads[SpecialofferproductRowUnsaved](json => JsResult.fromTry(
        Try(
          SpecialofferproductRowUnsaved(
            specialofferid = json.\("specialofferid").as(SpecialofferId.reads),
            productid = json.\("productid").as(ProductId.reads),
            rowguid = json.\("rowguid").as(Defaulted.reads(TypoUUID.reads)),
            modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
          )
        )
      ),
    )
  }
  implicit lazy val text: Text[SpecialofferproductRowUnsaved] = {
    Text.instance[SpecialofferproductRowUnsaved]{ (row, sb) =>
      SpecialofferId.text.unsafeEncode(row.specialofferid, sb)
      sb.append(Text.DELIMETER)
      ProductId.text.unsafeEncode(row.productid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val writes: OWrites[SpecialofferproductRowUnsaved] = {
    OWrites[SpecialofferproductRowUnsaved](o =>
      new JsObject(ListMap[String, JsValue](
        "specialofferid" -> SpecialofferId.writes.writes(o.specialofferid),
        "productid" -> ProductId.writes.writes(o.productid),
        "rowguid" -> Defaulted.writes(TypoUUID.writes).writes(o.rowguid),
        "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
      ))
    )
  }
}