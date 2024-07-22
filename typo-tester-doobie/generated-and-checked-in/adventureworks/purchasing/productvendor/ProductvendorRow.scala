/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.productvendor

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: purchasing.productvendor
    Cross-reference table mapping vendors with the products they supply.
    Composite primary key: productid, businessentityid */
case class ProductvendorRow(
  /** Primary key. Foreign key to Product.ProductID.
      Points to [[adventureworks.production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Primary key. Foreign key to Vendor.BusinessEntityID.
      Points to [[adventureworks.purchasing.vendor.VendorRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** The average span of time (in days) between placing an order with the vendor and receiving the purchased product.
      Constraint CK_ProductVendor_AverageLeadTime affecting columns averageleadtime: ((averageleadtime >= 1)) */
  averageleadtime: Int,
  /** The vendor's usual selling price.
      Constraint CK_ProductVendor_StandardPrice affecting columns standardprice: ((standardprice > 0.00)) */
  standardprice: BigDecimal,
  /** The selling price when last purchased.
      Constraint CK_ProductVendor_LastReceiptCost affecting columns lastreceiptcost: ((lastreceiptcost > 0.00)) */
  lastreceiptcost: Option[BigDecimal],
  /** Date the product was last received by the vendor. */
  lastreceiptdate: Option[TypoLocalDateTime],
  /** The maximum quantity that should be ordered.
      Constraint CK_ProductVendor_MinOrderQty affecting columns minorderqty: ((minorderqty >= 1)) */
  minorderqty: Int,
  /** The minimum quantity that should be ordered.
      Constraint CK_ProductVendor_MaxOrderQty affecting columns maxorderqty: ((maxorderqty >= 1)) */
  maxorderqty: Int,
  /** The quantity currently on order.
      Constraint CK_ProductVendor_OnOrderQty affecting columns onorderqty: ((onorderqty >= 0)) */
  onorderqty: Option[Int],
  /** The product's unit of measure.
      Points to [[adventureworks.production.unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductvendorId = ProductvendorId(productid, businessentityid)
   val id = compositeId
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductvendorRowUnsaved =
     ProductvendorRowUnsaved(productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate)
 }

object ProductvendorRow {
  def apply(compositeId: ProductvendorId, averageleadtime: Int, standardprice: BigDecimal, lastreceiptcost: Option[BigDecimal], lastreceiptdate: Option[TypoLocalDateTime], minorderqty: Int, maxorderqty: Int, onorderqty: Option[Int], unitmeasurecode: UnitmeasureId, modifieddate: TypoLocalDateTime) =
    new ProductvendorRow(compositeId.productid, compositeId.businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate)
  implicit lazy val decoder: Decoder[ProductvendorRow] = Decoder.forProduct11[ProductvendorRow, ProductId, BusinessentityId, Int, BigDecimal, Option[BigDecimal], Option[TypoLocalDateTime], Int, Int, Option[Int], UnitmeasureId, TypoLocalDateTime]("productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")(ProductvendorRow.apply)(ProductId.decoder, BusinessentityId.decoder, Decoder.decodeInt, Decoder.decodeBigDecimal, Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeInt, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeInt), UnitmeasureId.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ProductvendorRow] = Encoder.forProduct11[ProductvendorRow, ProductId, BusinessentityId, Int, BigDecimal, Option[BigDecimal], Option[TypoLocalDateTime], Int, Int, Option[Int], UnitmeasureId, TypoLocalDateTime]("productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")(x => (x.productid, x.businessentityid, x.averageleadtime, x.standardprice, x.lastreceiptcost, x.lastreceiptdate, x.minorderqty, x.maxorderqty, x.onorderqty, x.unitmeasurecode, x.modifieddate))(ProductId.encoder, BusinessentityId.encoder, Encoder.encodeInt, Encoder.encodeBigDecimal, Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeInt, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeInt), UnitmeasureId.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ProductvendorRow] = new Read[ProductvendorRow](
    gets = List(
      (ProductId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.Nullable),
      (UnitmeasureId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductvendorRow(
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 1),
      averageleadtime = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      standardprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 3),
      lastreceiptcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 4),
      lastreceiptdate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 5),
      minorderqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 6),
      maxorderqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 7),
      onorderqty = Meta.IntMeta.get.unsafeGetNullable(rs, i + 8),
      unitmeasurecode = UnitmeasureId.get.unsafeGetNonNullable(rs, i + 9),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 10)
    )
  )
  implicit lazy val text: Text[ProductvendorRow] = Text.instance[ProductvendorRow]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.averageleadtime, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.standardprice, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.bigDecimalInstance).unsafeEncode(row.lastreceiptcost, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.lastreceiptdate, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.minorderqty, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.maxorderqty, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.intInstance).unsafeEncode(row.onorderqty, sb)
    sb.append(Text.DELIMETER)
    UnitmeasureId.text.unsafeEncode(row.unitmeasurecode, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val write: Write[ProductvendorRow] = new Write[ProductvendorRow](
    puts = List((ProductId.put, Nullability.NoNulls),
                (BusinessentityId.put, Nullability.NoNulls),
                (Meta.IntMeta.put, Nullability.NoNulls),
                (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                (Meta.ScalaBigDecimalMeta.put, Nullability.Nullable),
                (TypoLocalDateTime.put, Nullability.Nullable),
                (Meta.IntMeta.put, Nullability.NoNulls),
                (Meta.IntMeta.put, Nullability.NoNulls),
                (Meta.IntMeta.put, Nullability.Nullable),
                (UnitmeasureId.put, Nullability.NoNulls),
                (TypoLocalDateTime.put, Nullability.NoNulls)),
    toList = x => List(x.productid, x.businessentityid, x.averageleadtime, x.standardprice, x.lastreceiptcost, x.lastreceiptdate, x.minorderqty, x.maxorderqty, x.onorderqty, x.unitmeasurecode, x.modifieddate),
    unsafeSet = (rs, i, a) => {
                  ProductId.put.unsafeSetNonNullable(rs, i + 0, a.productid)
                  BusinessentityId.put.unsafeSetNonNullable(rs, i + 1, a.businessentityid)
                  Meta.IntMeta.put.unsafeSetNonNullable(rs, i + 2, a.averageleadtime)
                  Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 3, a.standardprice)
                  Meta.ScalaBigDecimalMeta.put.unsafeSetNullable(rs, i + 4, a.lastreceiptcost)
                  TypoLocalDateTime.put.unsafeSetNullable(rs, i + 5, a.lastreceiptdate)
                  Meta.IntMeta.put.unsafeSetNonNullable(rs, i + 6, a.minorderqty)
                  Meta.IntMeta.put.unsafeSetNonNullable(rs, i + 7, a.maxorderqty)
                  Meta.IntMeta.put.unsafeSetNullable(rs, i + 8, a.onorderqty)
                  UnitmeasureId.put.unsafeSetNonNullable(rs, i + 9, a.unitmeasurecode)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 10, a.modifieddate)
                },
    unsafeUpdate = (ps, i, a) => {
                     ProductId.put.unsafeUpdateNonNullable(ps, i + 0, a.productid)
                     BusinessentityId.put.unsafeUpdateNonNullable(ps, i + 1, a.businessentityid)
                     Meta.IntMeta.put.unsafeUpdateNonNullable(ps, i + 2, a.averageleadtime)
                     Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 3, a.standardprice)
                     Meta.ScalaBigDecimalMeta.put.unsafeUpdateNullable(ps, i + 4, a.lastreceiptcost)
                     TypoLocalDateTime.put.unsafeUpdateNullable(ps, i + 5, a.lastreceiptdate)
                     Meta.IntMeta.put.unsafeUpdateNonNullable(ps, i + 6, a.minorderqty)
                     Meta.IntMeta.put.unsafeUpdateNonNullable(ps, i + 7, a.maxorderqty)
                     Meta.IntMeta.put.unsafeUpdateNullable(ps, i + 8, a.onorderqty)
                     UnitmeasureId.put.unsafeUpdateNonNullable(ps, i + 9, a.unitmeasurecode)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 10, a.modifieddate)
                   }
  )
}
