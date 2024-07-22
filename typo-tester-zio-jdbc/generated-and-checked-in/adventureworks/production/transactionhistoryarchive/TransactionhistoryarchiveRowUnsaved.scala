/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.transactionhistoryarchive

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.transactionhistoryarchive` which has not been persisted yet */
case class TransactionhistoryarchiveRowUnsaved(
  /** Primary key for TransactionHistoryArchive records. */
  transactionid: TransactionhistoryarchiveId,
  /** Product identification number. Foreign key to Product.ProductID. */
  productid: Int,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** W = Work Order, S = Sales Order, P = Purchase Order
      Constraint CK_TransactionHistoryArchive_TransactionType affecting columns transactiontype:  ((upper((transactiontype)::text) = ANY (ARRAY['W'::text, 'S'::text, 'P'::text]))) */
  transactiontype: /* bpchar, max 1 chars */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  /** Default: 0
      Line number associated with the purchase order, sales order, or work order. */
  referenceorderlineid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date and time of the transaction. */
  transactiondate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(referenceorderlineidDefault: => Int, transactiondateDefault: => TypoLocalDateTime, modifieddateDefault: => TypoLocalDateTime): TransactionhistoryarchiveRow =
    TransactionhistoryarchiveRow(
      transactionid = transactionid,
      productid = productid,
      referenceorderid = referenceorderid,
      transactiontype = transactiontype,
      quantity = quantity,
      actualcost = actualcost,
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
object TransactionhistoryarchiveRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[TransactionhistoryarchiveRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val transactionid = jsonObj.get("transactionid").toRight("Missing field 'transactionid'").flatMap(_.as(TransactionhistoryarchiveId.jsonDecoder))
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(JsonDecoder.int))
    val referenceorderid = jsonObj.get("referenceorderid").toRight("Missing field 'referenceorderid'").flatMap(_.as(JsonDecoder.int))
    val transactiontype = jsonObj.get("transactiontype").toRight("Missing field 'transactiontype'").flatMap(_.as(JsonDecoder.string))
    val quantity = jsonObj.get("quantity").toRight("Missing field 'quantity'").flatMap(_.as(JsonDecoder.int))
    val actualcost = jsonObj.get("actualcost").toRight("Missing field 'actualcost'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val referenceorderlineid = jsonObj.get("referenceorderlineid").toRight("Missing field 'referenceorderlineid'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.int)))
    val transactiondate = jsonObj.get("transactiondate").toRight("Missing field 'transactiondate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (transactionid.isRight && productid.isRight && referenceorderid.isRight && transactiontype.isRight && quantity.isRight && actualcost.isRight && referenceorderlineid.isRight && transactiondate.isRight && modifieddate.isRight)
      Right(TransactionhistoryarchiveRowUnsaved(transactionid = transactionid.toOption.get, productid = productid.toOption.get, referenceorderid = referenceorderid.toOption.get, transactiontype = transactiontype.toOption.get, quantity = quantity.toOption.get, actualcost = actualcost.toOption.get, referenceorderlineid = referenceorderlineid.toOption.get, transactiondate = transactiondate.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](transactionid, productid, referenceorderid, transactiontype, quantity, actualcost, referenceorderlineid, transactiondate, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[TransactionhistoryarchiveRowUnsaved] = new JsonEncoder[TransactionhistoryarchiveRowUnsaved] {
    override def unsafeEncode(a: TransactionhistoryarchiveRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""transactionid":""")
      TransactionhistoryarchiveId.jsonEncoder.unsafeEncode(a.transactionid, indent, out)
      out.write(",")
      out.write(""""productid":""")
      JsonEncoder.int.unsafeEncode(a.productid, indent, out)
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
  implicit lazy val text: Text[TransactionhistoryarchiveRowUnsaved] = Text.instance[TransactionhistoryarchiveRowUnsaved]{ (row, sb) =>
    TransactionhistoryarchiveId.text.unsafeEncode(row.transactionid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.referenceorderid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.transactiontype, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.quantity, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.actualcost, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.intInstance).unsafeEncode(row.referenceorderlineid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.transactiondate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
