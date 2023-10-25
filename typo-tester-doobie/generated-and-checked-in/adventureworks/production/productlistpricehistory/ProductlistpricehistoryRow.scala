/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ProductlistpricehistoryRow(
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
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductlistpricehistoryId = ProductlistpricehistoryId(productid, startdate)
 }

object ProductlistpricehistoryRow {
  implicit lazy val decoder: Decoder[ProductlistpricehistoryRow] = Decoder.forProduct5[ProductlistpricehistoryRow, ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, TypoLocalDateTime]("productid", "startdate", "enddate", "listprice", "modifieddate")(ProductlistpricehistoryRow.apply)(ProductId.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ProductlistpricehistoryRow] = Encoder.forProduct5[ProductlistpricehistoryRow, ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, TypoLocalDateTime]("productid", "startdate", "enddate", "listprice", "modifieddate")(x => (x.productid, x.startdate, x.enddate, x.listprice, x.modifieddate))(ProductId.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ProductlistpricehistoryRow] = new Read[ProductlistpricehistoryRow](
    gets = List(
      (ProductId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductlistpricehistoryRow(
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 0),
      startdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 1),
      enddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 2),
      listprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
  implicit lazy val text: Text[ProductlistpricehistoryRow] = Text.instance[ProductlistpricehistoryRow]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.listprice, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
