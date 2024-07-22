/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesorderheadersalesreason

import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `sales.salesorderheadersalesreason` */
case class SalesorderheadersalesreasonId(
  salesorderid: SalesorderheaderId,
  salesreasonid: SalesreasonId
)
object SalesorderheadersalesreasonId {
  implicit lazy val ordering: Ordering[SalesorderheadersalesreasonId] = Ordering.by(x => (x.salesorderid, x.salesreasonid))
  implicit lazy val reads: Reads[SalesorderheadersalesreasonId] = Reads[SalesorderheadersalesreasonId](json => JsResult.fromTry(
      Try(
        SalesorderheadersalesreasonId(
          salesorderid = json.\("salesorderid").as(SalesorderheaderId.reads),
          salesreasonid = json.\("salesreasonid").as(SalesreasonId.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[SalesorderheadersalesreasonId] = OWrites[SalesorderheadersalesreasonId](o =>
    new JsObject(ListMap[String, JsValue](
      "salesorderid" -> SalesorderheaderId.writes.writes(o.salesorderid),
      "salesreasonid" -> SalesreasonId.writes.writes(o.salesreasonid)
    ))
  )
}
