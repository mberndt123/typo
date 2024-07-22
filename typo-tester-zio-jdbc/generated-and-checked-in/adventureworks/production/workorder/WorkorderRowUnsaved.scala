/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.workorder

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.workorder` which has not been persisted yet */
case class WorkorderRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[adventureworks.production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Product quantity to build.
      Constraint CK_WorkOrder_OrderQty affecting columns orderqty:  ((orderqty > 0)) */
  orderqty: Int,
  /** Quantity that failed inspection.
      Constraint CK_WorkOrder_ScrappedQty affecting columns scrappedqty:  ((scrappedqty >= 0)) */
  scrappedqty: TypoShort,
  /** Work order start date.
      Constraint CK_WorkOrder_EndDate affecting columns enddate, startdate:  (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Work order end date.
      Constraint CK_WorkOrder_EndDate affecting columns enddate, startdate:  (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Work order due date. */
  duedate: TypoLocalDateTime,
  /** Reason for inspection failure.
      Points to [[adventureworks.production.scrapreason.ScrapreasonRow.scrapreasonid]] */
  scrapreasonid: Option[ScrapreasonId],
  /** Default: nextval('production.workorder_workorderid_seq'::regclass)
      Primary key for WorkOrder records. */
  workorderid: Defaulted[WorkorderId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(workorderidDefault: => WorkorderId, modifieddateDefault: => TypoLocalDateTime): WorkorderRow =
    WorkorderRow(
      productid = productid,
      orderqty = orderqty,
      scrappedqty = scrappedqty,
      startdate = startdate,
      enddate = enddate,
      duedate = duedate,
      scrapreasonid = scrapreasonid,
      workorderid = workorderid match {
                      case Defaulted.UseDefault => workorderidDefault
                      case Defaulted.Provided(value) => value
                    },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object WorkorderRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[WorkorderRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val orderqty = jsonObj.get("orderqty").toRight("Missing field 'orderqty'").flatMap(_.as(JsonDecoder.int))
    val scrappedqty = jsonObj.get("scrappedqty").toRight("Missing field 'scrappedqty'").flatMap(_.as(TypoShort.jsonDecoder))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val enddate = jsonObj.get("enddate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDateTime.jsonDecoder)))
    val duedate = jsonObj.get("duedate").toRight("Missing field 'duedate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val scrapreasonid = jsonObj.get("scrapreasonid").fold[Either[String, Option[ScrapreasonId]]](Right(None))(_.as(JsonDecoder.option(using ScrapreasonId.jsonDecoder)))
    val workorderid = jsonObj.get("workorderid").toRight("Missing field 'workorderid'").flatMap(_.as(Defaulted.jsonDecoder(WorkorderId.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (productid.isRight && orderqty.isRight && scrappedqty.isRight && startdate.isRight && enddate.isRight && duedate.isRight && scrapreasonid.isRight && workorderid.isRight && modifieddate.isRight)
      Right(WorkorderRowUnsaved(productid = productid.toOption.get, orderqty = orderqty.toOption.get, scrappedqty = scrappedqty.toOption.get, startdate = startdate.toOption.get, enddate = enddate.toOption.get, duedate = duedate.toOption.get, scrapreasonid = scrapreasonid.toOption.get, workorderid = workorderid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, workorderid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[WorkorderRowUnsaved] = new JsonEncoder[WorkorderRowUnsaved] {
    override def unsafeEncode(a: WorkorderRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""orderqty":""")
      JsonEncoder.int.unsafeEncode(a.orderqty, indent, out)
      out.write(",")
      out.write(""""scrappedqty":""")
      TypoShort.jsonEncoder.unsafeEncode(a.scrappedqty, indent, out)
      out.write(",")
      out.write(""""startdate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.startdate, indent, out)
      out.write(",")
      out.write(""""enddate":""")
      JsonEncoder.option(using TypoLocalDateTime.jsonEncoder).unsafeEncode(a.enddate, indent, out)
      out.write(",")
      out.write(""""duedate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.duedate, indent, out)
      out.write(",")
      out.write(""""scrapreasonid":""")
      JsonEncoder.option(using ScrapreasonId.jsonEncoder).unsafeEncode(a.scrapreasonid, indent, out)
      out.write(",")
      out.write(""""workorderid":""")
      Defaulted.jsonEncoder(WorkorderId.jsonEncoder).unsafeEncode(a.workorderid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[WorkorderRowUnsaved] = Text.instance[WorkorderRowUnsaved]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.orderqty, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.scrappedqty, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.duedate, sb)
    sb.append(Text.DELIMETER)
    Text.option(ScrapreasonId.text).unsafeEncode(row.scrapreasonid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(WorkorderId.text).unsafeEncode(row.workorderid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
