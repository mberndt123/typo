/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.purchaseorderdetail;

import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** Type for the composite primary key of table `purchasing.purchaseorderdetail` */
case class PurchaseorderdetailId(purchaseorderid: PurchaseorderheaderId, purchaseorderdetailid: Int)

object PurchaseorderdetailId {
  implicit lazy val reads: Reads[PurchaseorderdetailId] = {
    Reads[PurchaseorderdetailId](json => JsResult.fromTry(
        Try(
          PurchaseorderdetailId(
            purchaseorderid = json.\("purchaseorderid").as(PurchaseorderheaderId.reads),
            purchaseorderdetailid = json.\("purchaseorderdetailid").as(Reads.IntReads)
          )
        )
      ),
    )
  }
  implicit lazy val writes: OWrites[PurchaseorderdetailId] = {
    OWrites[PurchaseorderdetailId](o =>
      new JsObject(ListMap[String, JsValue](
        "purchaseorderid" -> PurchaseorderheaderId.writes.writes(o.purchaseorderid),
        "purchaseorderdetailid" -> Writes.IntWrites.writes(o.purchaseorderdetailid)
      ))
    )
  }
}