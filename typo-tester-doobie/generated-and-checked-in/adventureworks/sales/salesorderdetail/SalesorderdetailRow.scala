/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class SalesorderdetailRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. One incremental unique number per product sold. */
  salesorderdetailid: Int,
  /** Shipment tracking number supplied by the shipper. */
  carriertrackingnumber: Option[/* max 25 chars */ String],
  /** Quantity ordered per product.
      Constraint CK_SalesOrderDetail_OrderQty affecting columns "orderqty":  ((orderqty > 0)) */
  orderqty: TypoShort,
  /** Product sold to customer. Foreign key to Product.ProductID.
      Points to [[specialofferproduct.SpecialofferproductRow.productid]] */
  productid: ProductId,
  /** Promotional code. Foreign key to SpecialOffer.SpecialOfferID.
      Points to [[specialofferproduct.SpecialofferproductRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Selling price of a single product.
      Constraint CK_SalesOrderDetail_UnitPrice affecting columns "unitprice":  ((unitprice >= 0.00)) */
  unitprice: BigDecimal,
  /** Discount amount.
      Constraint CK_SalesOrderDetail_UnitPriceDiscount affecting columns "unitpricediscount":  ((unitpricediscount >= 0.00)) */
  unitpricediscount: BigDecimal,
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesorderdetailId = SalesorderdetailId(salesorderid, salesorderdetailid)
 }

object SalesorderdetailRow {
  implicit lazy val decoder: Decoder[SalesorderdetailRow] = Decoder.forProduct10[SalesorderdetailRow, SalesorderheaderId, Int, Option[/* max 25 chars */ String], TypoShort, ProductId, SpecialofferId, BigDecimal, BigDecimal, TypoUUID, TypoLocalDateTime]("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate")(SalesorderdetailRow.apply)(SalesorderheaderId.decoder, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeString), TypoShort.decoder, ProductId.decoder, SpecialofferId.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SalesorderdetailRow] = Encoder.forProduct10[SalesorderdetailRow, SalesorderheaderId, Int, Option[/* max 25 chars */ String], TypoShort, ProductId, SpecialofferId, BigDecimal, BigDecimal, TypoUUID, TypoLocalDateTime]("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate")(x => (x.salesorderid, x.salesorderdetailid, x.carriertrackingnumber, x.orderqty, x.productid, x.specialofferid, x.unitprice, x.unitpricediscount, x.rowguid, x.modifieddate))(SalesorderheaderId.encoder, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeString), TypoShort.encoder, ProductId.encoder, SpecialofferId.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SalesorderdetailRow] = new Read[SalesorderdetailRow](
    gets = List(
      (SalesorderheaderId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoShort.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (SpecialofferId.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalesorderdetailRow(
      salesorderid = SalesorderheaderId.get.unsafeGetNonNullable(rs, i + 0),
      salesorderdetailid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 1),
      carriertrackingnumber = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      orderqty = TypoShort.get.unsafeGetNonNullable(rs, i + 3),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 4),
      specialofferid = SpecialofferId.get.unsafeGetNonNullable(rs, i + 5),
      unitprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 6),
      unitpricediscount = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 8),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 9)
    )
  )
  implicit lazy val text: Text[SalesorderdetailRow] = Text.instance[SalesorderdetailRow]{ (row, sb) =>
    SalesorderheaderId.text.unsafeEncode(row.salesorderid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.salesorderdetailid, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.carriertrackingnumber, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.orderqty, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    SpecialofferId.text.unsafeEncode(row.specialofferid, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.unitprice, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.unitpricediscount, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
