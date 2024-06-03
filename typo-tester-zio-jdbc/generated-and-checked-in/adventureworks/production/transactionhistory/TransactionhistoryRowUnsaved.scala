/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.transactionhistory` which has not been persisted yet */
case class TransactionhistoryRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** W = WorkOrder, S = SalesOrder, P = PurchaseOrder
      Constraint CK_TransactionHistory_TransactionType affecting columns transactiontype:  ((upper((transactiontype)::text) = ANY (ARRAY['W'::text, 'S'::text, 'P'::text]))) */
  transactiontype: /* bpchar, max 1 chars */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  /** Default: nextval('production.transactionhistory_transactionid_seq'::regclass)
      Primary key for TransactionHistory records. */
  transactionid: Defaulted[TransactionhistoryId] = Defaulted.UseDefault,
  /** Default: 0
      Line number associated with the purchase order, sales order, or work order. */
  referenceorderlineid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date and time of the transaction. */
  transactiondate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(transactionidDefault: => TransactionhistoryId, referenceorderlineidDefault: => Int, transactiondateDefault: => TypoLocalDateTime, modifieddateDefault: => TypoLocalDateTime): TransactionhistoryRow =
    TransactionhistoryRow(
      productid = productid,
      referenceorderid = referenceorderid,
      transactiontype = transactiontype,
      quantity = quantity,
      actualcost = actualcost,
      transactionid = transactionid match {
                        case Defaulted.UseDefault => transactionidDefault
                        case Defaulted.Provided(value) => value
                      },
      referenceorderlineid = referenceorderlineid match {
                               case Defaulted.UseDefault => referenceorderlineidDefault
                               case Defaulted.Provided(value) => value
                             },
      transactiondate = transactiondate match {
                          case Defaulted.UseDefault => transactiondateDefault
                          case Defaulted.Provided(value) => value
                        },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object TransactionhistoryRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[TransactionhistoryRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val referenceorderid = jsonObj.get("referenceorderid").toRight("Missing field 'referenceorderid'").flatMap(_.as(JsonDecoder.int))
    val transactiontype = jsonObj.get("transactiontype").toRight("Missing field 'transactiontype'").flatMap(_.as(JsonDecoder.string))
    val quantity = jsonObj.get("quantity").toRight("Missing field 'quantity'").flatMap(_.as(JsonDecoder.int))
    val actualcost = jsonObj.get("actualcost").toRight("Missing field 'actualcost'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val transactionid = jsonObj.get("transactionid").toRight("Missing field 'transactionid'").flatMap(_.as(Defaulted.jsonDecoder(TransactionhistoryId.jsonDecoder)))
    val referenceorderlineid = jsonObj.get("referenceorderlineid").toRight("Missing field 'referenceorderlineid'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.int)))
    val transactiondate = jsonObj.get("transactiondate").toRight("Missing field 'transactiondate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (productid.isRight && referenceorderid.isRight && transactiontype.isRight && quantity.isRight && actualcost.isRight && transactionid.isRight && referenceorderlineid.isRight && transactiondate.isRight && modifieddate.isRight)
      Right(TransactionhistoryRowUnsaved(productid = productid.toOption.get, referenceorderid = referenceorderid.toOption.get, transactiontype = transactiontype.toOption.get, quantity = quantity.toOption.get, actualcost = actualcost.toOption.get, transactionid = transactionid.toOption.get, referenceorderlineid = referenceorderlineid.toOption.get, transactiondate = transactiondate.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productid, referenceorderid, transactiontype, quantity, actualcost, transactionid, referenceorderlineid, transactiondate, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[TransactionhistoryRowUnsaved] = new JsonEncoder[TransactionhistoryRowUnsaved] {
    override def unsafeEncode(a: TransactionhistoryRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""referenceorderid":""")
      JsonEncoder.int.unsafeEncode(a.referenceorderid, indent, out)
      out.write(",")
      out.write(""""transactiontype":""")
      JsonEncoder.string.unsafeEncode(a.transactiontype, indent, out)
      out.write(",")
      out.write(""""quantity":""")
      JsonEncoder.int.unsafeEncode(a.quantity, indent, out)
      out.write(",")
      out.write(""""actualcost":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.actualcost, indent, out)
      out.write(",")
      out.write(""""transactionid":""")
      Defaulted.jsonEncoder(TransactionhistoryId.jsonEncoder).unsafeEncode(a.transactionid, indent, out)
      out.write(",")
      out.write(""""referenceorderlineid":""")
      Defaulted.jsonEncoder(JsonEncoder.int).unsafeEncode(a.referenceorderlineid, indent, out)
      out.write(",")
      out.write(""""transactiondate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.transactiondate, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[TransactionhistoryRowUnsaved] = Text.instance[TransactionhistoryRowUnsaved]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.referenceorderid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.transactiontype, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.quantity, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.actualcost, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TransactionhistoryId.text).unsafeEncode(row.transactionid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.intInstance).unsafeEncode(row.referenceorderlineid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.transactiondate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
