/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.purchaseorderdetail;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.production.product.ProductId;
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId;
import doobie.enumerated.Nullability;
import doobie.postgres.Text;
import doobie.util.Read;
import doobie.util.Write;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import java.sql.ResultSet;

/** Table: purchasing.purchaseorderdetail
  * Individual products associated with a specific purchase order. See PurchaseOrderHeader.
  * Composite primary key: purchaseorderid, purchaseorderdetailid
  */
case class PurchaseorderdetailRow(
  /** Primary key. Foreign key to PurchaseOrderHeader.PurchaseOrderID.
    * Points to [[adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderRow.purchaseorderid]]
    */
  purchaseorderid: PurchaseorderheaderId,
  /** Primary key. One line number per purchased product.
    * Default: nextval('purchasing.purchaseorderdetail_purchaseorderdetailid_seq'::regclass)
    */
  purchaseorderdetailid: Int,
  /** Date the product is expected to be received. */
  duedate: TypoLocalDateTime,
  /** Quantity ordered.
    * Constraint CK_PurchaseOrderDetail_OrderQty affecting columns orderqty: ((orderqty > 0))
    */
  orderqty: TypoShort,
  /** Product identification number. Foreign key to Product.ProductID.
    * Points to [[adventureworks.production.product.ProductRow.productid]]
    */
  productid: ProductId,
  /** Vendor's selling price of a single product.
    * Constraint CK_PurchaseOrderDetail_UnitPrice affecting columns unitprice: ((unitprice >= 0.00))
    */
  unitprice: BigDecimal,
  /** Quantity actually received from the vendor.
    * Constraint CK_PurchaseOrderDetail_ReceivedQty affecting columns receivedqty: ((receivedqty >= 0.00))
    */
  receivedqty: BigDecimal,
  /** Quantity rejected during inspection.
    * Constraint CK_PurchaseOrderDetail_RejectedQty affecting columns rejectedqty: ((rejectedqty >= 0.00))
    */
  rejectedqty: BigDecimal,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def compositeId: PurchaseorderdetailId = new PurchaseorderdetailId(purchaseorderid, purchaseorderdetailid)
  def id: PurchaseorderdetailId = compositeId
  def toUnsavedRow(purchaseorderdetailid: Defaulted[Int], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): PurchaseorderdetailRowUnsaved = {
    new PurchaseorderdetailRowUnsaved(
      purchaseorderid,
      duedate,
      orderqty,
      productid,
      unitprice,
      receivedqty,
      rejectedqty,
      purchaseorderdetailid,
      modifieddate
    )
  }
}

object PurchaseorderdetailRow {
  def apply(
    compositeId: PurchaseorderdetailId,
    duedate: TypoLocalDateTime,
    orderqty: TypoShort,
    productid: ProductId,
    unitprice: BigDecimal,
    receivedqty: BigDecimal,
    rejectedqty: BigDecimal,
    modifieddate: TypoLocalDateTime
  ): PurchaseorderdetailRow = {
    new PurchaseorderdetailRow(
      compositeId.purchaseorderid,
      compositeId.purchaseorderdetailid,
      duedate,
      orderqty,
      productid,
      unitprice,
      receivedqty,
      rejectedqty,
      modifieddate
    )
  }
  implicit lazy val decoder: Decoder[PurchaseorderdetailRow] = Decoder.forProduct9[PurchaseorderdetailRow, PurchaseorderheaderId, Int, TypoLocalDateTime, TypoShort, ProductId, BigDecimal, BigDecimal, BigDecimal, TypoLocalDateTime]("purchaseorderid", "purchaseorderdetailid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate")(PurchaseorderdetailRow.apply)(PurchaseorderheaderId.decoder, Decoder.decodeInt, TypoLocalDateTime.decoder, TypoShort.decoder, ProductId.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PurchaseorderdetailRow] = Encoder.forProduct9[PurchaseorderdetailRow, PurchaseorderheaderId, Int, TypoLocalDateTime, TypoShort, ProductId, BigDecimal, BigDecimal, BigDecimal, TypoLocalDateTime]("purchaseorderid", "purchaseorderdetailid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate")(x => (x.purchaseorderid, x.purchaseorderdetailid, x.duedate, x.orderqty, x.productid, x.unitprice, x.receivedqty, x.rejectedqty, x.modifieddate))(PurchaseorderheaderId.encoder, Encoder.encodeInt, TypoLocalDateTime.encoder, TypoShort.encoder, ProductId.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PurchaseorderdetailRow] = {
    new Read[PurchaseorderdetailRow](
      gets = List(
        (PurchaseorderheaderId.get, Nullability.NoNulls),
        (Meta.IntMeta.get, Nullability.NoNulls),
        (TypoLocalDateTime.get, Nullability.NoNulls),
        (TypoShort.get, Nullability.NoNulls),
        (ProductId.get, Nullability.NoNulls),
        (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
        (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
        (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
        (TypoLocalDateTime.get, Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PurchaseorderdetailRow(
        purchaseorderid = PurchaseorderheaderId.get.unsafeGetNonNullable(rs, i + 0),
        purchaseorderdetailid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 1),
        duedate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2),
        orderqty = TypoShort.get.unsafeGetNonNullable(rs, i + 3),
        productid = ProductId.get.unsafeGetNonNullable(rs, i + 4),
        unitprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 5),
        receivedqty = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 6),
        rejectedqty = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
        modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8)
      )
    )
  
  }
  implicit lazy val text: Text[PurchaseorderdetailRow] = {
    Text.instance[PurchaseorderdetailRow]{ (row, sb) =>
      PurchaseorderheaderId.text.unsafeEncode(row.purchaseorderid, sb)
      sb.append(Text.DELIMETER)
      Text.intInstance.unsafeEncode(row.purchaseorderdetailid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.duedate, sb)
      sb.append(Text.DELIMETER)
      TypoShort.text.unsafeEncode(row.orderqty, sb)
      sb.append(Text.DELIMETER)
      ProductId.text.unsafeEncode(row.productid, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.unitprice, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.receivedqty, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.rejectedqty, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val write: Write[PurchaseorderdetailRow] = {
    new Write[PurchaseorderdetailRow](
      puts = List((PurchaseorderheaderId.put, Nullability.NoNulls),
                  (Meta.IntMeta.put, Nullability.NoNulls),
                  (TypoLocalDateTime.put, Nullability.NoNulls),
                  (TypoShort.put, Nullability.NoNulls),
                  (ProductId.put, Nullability.NoNulls),
                  (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                  (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                  (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                  (TypoLocalDateTime.put, Nullability.NoNulls)),
      toList = x => List(x.purchaseorderid, x.purchaseorderdetailid, x.duedate, x.orderqty, x.productid, x.unitprice, x.receivedqty, x.rejectedqty, x.modifieddate),
      unsafeSet = (rs, i, a) => {
                    PurchaseorderheaderId.put.unsafeSetNonNullable(rs, i + 0, a.purchaseorderid)
                    Meta.IntMeta.put.unsafeSetNonNullable(rs, i + 1, a.purchaseorderdetailid)
                    TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 2, a.duedate)
                    TypoShort.put.unsafeSetNonNullable(rs, i + 3, a.orderqty)
                    ProductId.put.unsafeSetNonNullable(rs, i + 4, a.productid)
                    Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 5, a.unitprice)
                    Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 6, a.receivedqty)
                    Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 7, a.rejectedqty)
                    TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 8, a.modifieddate)
                  },
      unsafeUpdate = (ps, i, a) => {
                       PurchaseorderheaderId.put.unsafeUpdateNonNullable(ps, i + 0, a.purchaseorderid)
                       Meta.IntMeta.put.unsafeUpdateNonNullable(ps, i + 1, a.purchaseorderdetailid)
                       TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 2, a.duedate)
                       TypoShort.put.unsafeUpdateNonNullable(ps, i + 3, a.orderqty)
                       ProductId.put.unsafeUpdateNonNullable(ps, i + 4, a.productid)
                       Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 5, a.unitprice)
                       Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 6, a.receivedqty)
                       Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 7, a.rejectedqty)
                       TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 8, a.modifieddate)
                     }
    )
  
  }
}