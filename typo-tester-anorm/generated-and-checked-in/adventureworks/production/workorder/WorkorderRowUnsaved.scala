/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.workorder` which has not been persisted yet */
case class WorkorderRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product quantity to build.
      Constraint CK_WorkOrder_OrderQty affecting columns "orderqty":  ((orderqty > 0)) */
  orderqty: Int,
  /** Quantity that failed inspection.
      Constraint CK_WorkOrder_ScrappedQty affecting columns "scrappedqty":  ((scrappedqty >= 0)) */
  scrappedqty: TypoShort,
  /** Work order start date.
      Constraint CK_WorkOrder_EndDate affecting columns "enddate", "startdate":  (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Work order end date.
      Constraint CK_WorkOrder_EndDate affecting columns "enddate", "startdate":  (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Work order due date. */
  duedate: TypoLocalDateTime,
  /** Reason for inspection failure.
      Points to [[scrapreason.ScrapreasonRow.scrapreasonid]] */
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
  implicit lazy val reads: Reads[WorkorderRowUnsaved] = Reads[WorkorderRowUnsaved](json => JsResult.fromTry(
      Try(
        WorkorderRowUnsaved(
          productid = json.\("productid").as(ProductId.reads),
          orderqty = json.\("orderqty").as(Reads.IntReads),
          scrappedqty = json.\("scrappedqty").as(TypoShort.reads),
          startdate = json.\("startdate").as(TypoLocalDateTime.reads),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          duedate = json.\("duedate").as(TypoLocalDateTime.reads),
          scrapreasonid = json.\("scrapreasonid").toOption.map(_.as(ScrapreasonId.reads)),
          workorderid = json.\("workorderid").as(Defaulted.reads(WorkorderId.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
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
  implicit lazy val writes: OWrites[WorkorderRowUnsaved] = OWrites[WorkorderRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "orderqty" -> Writes.IntWrites.writes(o.orderqty),
      "scrappedqty" -> TypoShort.writes.writes(o.scrappedqty),
      "startdate" -> TypoLocalDateTime.writes.writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "duedate" -> TypoLocalDateTime.writes.writes(o.duedate),
      "scrapreasonid" -> Writes.OptionWrites(ScrapreasonId.writes).writes(o.scrapreasonid),
      "workorderid" -> Defaulted.writes(WorkorderId.writes).writes(o.workorderid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
