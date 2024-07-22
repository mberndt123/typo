/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.purchaseorderdetail

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `purchasing.purchaseorderdetail` which has not been persisted yet */
case class PurchaseorderdetailRowUnsaved(
  /** Primary key. Foreign key to PurchaseOrderHeader.PurchaseOrderID.
      Points to [[adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderRow.purchaseorderid]] */
  purchaseorderid: PurchaseorderheaderId,
  /** Date the product is expected to be received. */
  duedate: TypoLocalDateTime,
  /** Quantity ordered.
      Constraint CK_PurchaseOrderDetail_OrderQty affecting columns orderqty:  ((orderqty > 0)) */
  orderqty: TypoShort,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[adventureworks.production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Vendor's selling price of a single product.
      Constraint CK_PurchaseOrderDetail_UnitPrice affecting columns unitprice:  ((unitprice >= 0.00)) */
  unitprice: BigDecimal,
  /** Quantity actually received from the vendor.
      Constraint CK_PurchaseOrderDetail_ReceivedQty affecting columns receivedqty:  ((receivedqty >= 0.00)) */
  receivedqty: BigDecimal,
  /** Quantity rejected during inspection.
      Constraint CK_PurchaseOrderDetail_RejectedQty affecting columns rejectedqty:  ((rejectedqty >= 0.00)) */
  rejectedqty: BigDecimal,
  /** Default: nextval('purchasing.purchaseorderdetail_purchaseorderdetailid_seq'::regclass)
      Primary key. One line number per purchased product. */
  purchaseorderdetailid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(purchaseorderdetailidDefault: => Int, modifieddateDefault: => TypoLocalDateTime): PurchaseorderdetailRow =
    PurchaseorderdetailRow(
      purchaseorderid = purchaseorderid,
      duedate = duedate,
      orderqty = orderqty,
      productid = productid,
      unitprice = unitprice,
      receivedqty = receivedqty,
      rejectedqty = rejectedqty,
      purchaseorderdetailid = purchaseorderdetailid match {
                                case Defaulted.UseDefault => purchaseorderdetailidDefault
                                case Defaulted.Provided(value) => value
                              },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PurchaseorderdetailRowUnsaved {
  implicit lazy val decoder: Decoder[PurchaseorderdetailRowUnsaved] = Decoder.forProduct9[PurchaseorderdetailRowUnsaved, PurchaseorderheaderId, TypoLocalDateTime, TypoShort, ProductId, BigDecimal, BigDecimal, BigDecimal, Defaulted[Int], Defaulted[TypoLocalDateTime]]("purchaseorderid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "purchaseorderdetailid", "modifieddate")(PurchaseorderdetailRowUnsaved.apply)(PurchaseorderheaderId.decoder, TypoLocalDateTime.decoder, TypoShort.decoder, ProductId.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Defaulted.decoder(Decoder.decodeInt), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[PurchaseorderdetailRowUnsaved] = Encoder.forProduct9[PurchaseorderdetailRowUnsaved, PurchaseorderheaderId, TypoLocalDateTime, TypoShort, ProductId, BigDecimal, BigDecimal, BigDecimal, Defaulted[Int], Defaulted[TypoLocalDateTime]]("purchaseorderid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "purchaseorderdetailid", "modifieddate")(x => (x.purchaseorderid, x.duedate, x.orderqty, x.productid, x.unitprice, x.receivedqty, x.rejectedqty, x.purchaseorderdetailid, x.modifieddate))(PurchaseorderheaderId.encoder, TypoLocalDateTime.encoder, TypoShort.encoder, ProductId.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Defaulted.encoder(Encoder.encodeInt), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[PurchaseorderdetailRowUnsaved] = Text.instance[PurchaseorderdetailRowUnsaved]{ (row, sb) =>
    PurchaseorderheaderId.text.unsafeEncode(row.purchaseorderid, sb)
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
    Defaulted.text(Text.intInstance).unsafeEncode(row.purchaseorderdetailid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
