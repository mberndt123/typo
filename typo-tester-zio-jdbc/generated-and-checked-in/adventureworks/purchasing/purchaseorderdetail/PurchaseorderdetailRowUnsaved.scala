/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.purchaseorderdetail

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

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
      purchaseorderdetailid = purchaseorderdetailid match {
                                case Defaulted.UseDefault => purchaseorderdetailidDefault
                                case Defaulted.Provided(value) => value
                              },
      duedate = duedate,
      orderqty = orderqty,
      productid = productid,
      unitprice = unitprice,
      receivedqty = receivedqty,
      rejectedqty = rejectedqty,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PurchaseorderdetailRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[PurchaseorderdetailRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val purchaseorderid = jsonObj.get("purchaseorderid").toRight("Missing field 'purchaseorderid'").flatMap(_.as(PurchaseorderheaderId.jsonDecoder))
    val duedate = jsonObj.get("duedate").toRight("Missing field 'duedate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val orderqty = jsonObj.get("orderqty").toRight("Missing field 'orderqty'").flatMap(_.as(TypoShort.jsonDecoder))
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val unitprice = jsonObj.get("unitprice").toRight("Missing field 'unitprice'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val receivedqty = jsonObj.get("receivedqty").toRight("Missing field 'receivedqty'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val rejectedqty = jsonObj.get("rejectedqty").toRight("Missing field 'rejectedqty'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val purchaseorderdetailid = jsonObj.get("purchaseorderdetailid").toRight("Missing field 'purchaseorderdetailid'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.int)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (purchaseorderid.isRight && duedate.isRight && orderqty.isRight && productid.isRight && unitprice.isRight && receivedqty.isRight && rejectedqty.isRight && purchaseorderdetailid.isRight && modifieddate.isRight)
      Right(PurchaseorderdetailRowUnsaved(purchaseorderid = purchaseorderid.toOption.get, duedate = duedate.toOption.get, orderqty = orderqty.toOption.get, productid = productid.toOption.get, unitprice = unitprice.toOption.get, receivedqty = receivedqty.toOption.get, rejectedqty = rejectedqty.toOption.get, purchaseorderdetailid = purchaseorderdetailid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](purchaseorderid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, purchaseorderdetailid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PurchaseorderdetailRowUnsaved] = new JsonEncoder[PurchaseorderdetailRowUnsaved] {
    override def unsafeEncode(a: PurchaseorderdetailRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""purchaseorderid":""")
      PurchaseorderheaderId.jsonEncoder.unsafeEncode(a.purchaseorderid, indent, out)
      out.write(",")
      out.write(""""duedate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.duedate, indent, out)
      out.write(",")
      out.write(""""orderqty":""")
      TypoShort.jsonEncoder.unsafeEncode(a.orderqty, indent, out)
      out.write(",")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""unitprice":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.unitprice, indent, out)
      out.write(",")
      out.write(""""receivedqty":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.receivedqty, indent, out)
      out.write(",")
      out.write(""""rejectedqty":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.rejectedqty, indent, out)
      out.write(",")
      out.write(""""purchaseorderdetailid":""")
      Defaulted.jsonEncoder(JsonEncoder.int).unsafeEncode(a.purchaseorderdetailid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
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
