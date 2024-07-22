/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesorderdetail

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import adventureworks.sales.specialofferproduct.SpecialofferproductId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: sales.salesorderdetail
    Individual products associated with a specific sales order. See SalesOrderHeader.
    Composite primary key: salesorderid, salesorderdetailid */
case class SalesorderdetailRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[adventureworks.sales.salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. One incremental unique number per product sold.
      Default: nextval('sales.salesorderdetail_salesorderdetailid_seq'::regclass) */
  salesorderdetailid: Int,
  /** Shipment tracking number supplied by the shipper. */
  carriertrackingnumber: Option[/* max 25 chars */ String],
  /** Quantity ordered per product.
      Constraint CK_SalesOrderDetail_OrderQty affecting columns orderqty: ((orderqty > 0)) */
  orderqty: TypoShort,
  /** Product sold to customer. Foreign key to Product.ProductID.
      Points to [[adventureworks.sales.specialofferproduct.SpecialofferproductRow.productid]] */
  productid: ProductId,
  /** Promotional code. Foreign key to SpecialOffer.SpecialOfferID.
      Points to [[adventureworks.sales.specialofferproduct.SpecialofferproductRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Selling price of a single product.
      Constraint CK_SalesOrderDetail_UnitPrice affecting columns unitprice: ((unitprice >= 0.00)) */
  unitprice: BigDecimal,
  /** Discount amount.
      Default: 0.0
      Constraint CK_SalesOrderDetail_UnitPriceDiscount affecting columns unitpricediscount: ((unitpricediscount >= 0.00)) */
  unitpricediscount: BigDecimal,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesorderdetailId = SalesorderdetailId(salesorderid, salesorderdetailid)
   val id = compositeId
   val extractSpecialofferproductId: SpecialofferproductId = SpecialofferproductId(
     specialofferid = specialofferid,
     productid = productid
   )
   def toUnsavedRow(salesorderdetailid: Defaulted[Int], unitpricediscount: Defaulted[BigDecimal] = Defaulted.Provided(this.unitpricediscount), rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): SalesorderdetailRowUnsaved =
     SalesorderdetailRowUnsaved(salesorderid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, salesorderdetailid, unitpricediscount, rowguid, modifieddate)
 }

object SalesorderdetailRow {
  def apply(compositeId: SalesorderdetailId, carriertrackingnumber: Option[/* max 25 chars */ String], orderqty: TypoShort, productid: ProductId, specialofferid: SpecialofferId, unitprice: BigDecimal, unitpricediscount: BigDecimal, rowguid: TypoUUID, modifieddate: TypoLocalDateTime) =
    new SalesorderdetailRow(compositeId.salesorderid, compositeId.salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate)
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
  implicit lazy val write: Write[SalesorderdetailRow] = new Write[SalesorderdetailRow](
    puts = List((SalesorderheaderId.put, Nullability.NoNulls),
                (Meta.IntMeta.put, Nullability.NoNulls),
                (Meta.StringMeta.put, Nullability.Nullable),
                (TypoShort.put, Nullability.NoNulls),
                (ProductId.put, Nullability.NoNulls),
                (SpecialofferId.put, Nullability.NoNulls),
                (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                (TypoUUID.put, Nullability.NoNulls),
                (TypoLocalDateTime.put, Nullability.NoNulls)),
    toList = x => List(x.salesorderid, x.salesorderdetailid, x.carriertrackingnumber, x.orderqty, x.productid, x.specialofferid, x.unitprice, x.unitpricediscount, x.rowguid, x.modifieddate),
    unsafeSet = (rs, i, a) => {
                  SalesorderheaderId.put.unsafeSetNonNullable(rs, i + 0, a.salesorderid)
                  Meta.IntMeta.put.unsafeSetNonNullable(rs, i + 1, a.salesorderdetailid)
                  Meta.StringMeta.put.unsafeSetNullable(rs, i + 2, a.carriertrackingnumber)
                  TypoShort.put.unsafeSetNonNullable(rs, i + 3, a.orderqty)
                  ProductId.put.unsafeSetNonNullable(rs, i + 4, a.productid)
                  SpecialofferId.put.unsafeSetNonNullable(rs, i + 5, a.specialofferid)
                  Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 6, a.unitprice)
                  Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 7, a.unitpricediscount)
                  TypoUUID.put.unsafeSetNonNullable(rs, i + 8, a.rowguid)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 9, a.modifieddate)
                },
    unsafeUpdate = (ps, i, a) => {
                     SalesorderheaderId.put.unsafeUpdateNonNullable(ps, i + 0, a.salesorderid)
                     Meta.IntMeta.put.unsafeUpdateNonNullable(ps, i + 1, a.salesorderdetailid)
                     Meta.StringMeta.put.unsafeUpdateNullable(ps, i + 2, a.carriertrackingnumber)
                     TypoShort.put.unsafeUpdateNonNullable(ps, i + 3, a.orderqty)
                     ProductId.put.unsafeUpdateNonNullable(ps, i + 4, a.productid)
                     SpecialofferId.put.unsafeUpdateNonNullable(ps, i + 5, a.specialofferid)
                     Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 6, a.unitprice)
                     Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 7, a.unitpricediscount)
                     TypoUUID.put.unsafeUpdateNonNullable(ps, i + 8, a.rowguid)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 9, a.modifieddate)
                   }
  )
}
