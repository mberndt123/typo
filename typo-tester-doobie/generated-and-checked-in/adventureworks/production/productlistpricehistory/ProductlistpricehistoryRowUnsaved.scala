/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.productlistpricehistory` which has not been persisted yet */
case class ProductlistpricehistoryRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** List price start date.
      Constraint CK_ProductListPriceHistory_EndDate affecting columns "enddate", "startdate":  (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** List price end date
      Constraint CK_ProductListPriceHistory_EndDate affecting columns "enddate", "startdate":  (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Product list price.
      Constraint CK_ProductListPriceHistory_ListPrice affecting columns "listprice":  ((listprice > 0.00)) */
  listprice: BigDecimal,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): ProductlistpricehistoryRow =
    ProductlistpricehistoryRow(
      productid = productid,
      startdate = startdate,
      enddate = enddate,
      listprice = listprice,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductlistpricehistoryRowUnsaved {
  implicit lazy val decoder: Decoder[ProductlistpricehistoryRowUnsaved] = Decoder.forProduct5[ProductlistpricehistoryRowUnsaved, ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, Defaulted[TypoLocalDateTime]]("productid", "startdate", "enddate", "listprice", "modifieddate")(ProductlistpricehistoryRowUnsaved.apply)(ProductId.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeBigDecimal, Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ProductlistpricehistoryRowUnsaved] = Encoder.forProduct5[ProductlistpricehistoryRowUnsaved, ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, Defaulted[TypoLocalDateTime]]("productid", "startdate", "enddate", "listprice", "modifieddate")(x => (x.productid, x.startdate, x.enddate, x.listprice, x.modifieddate))(ProductId.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeBigDecimal, Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[ProductlistpricehistoryRowUnsaved] = Text.instance[ProductlistpricehistoryRowUnsaved]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.listprice, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
