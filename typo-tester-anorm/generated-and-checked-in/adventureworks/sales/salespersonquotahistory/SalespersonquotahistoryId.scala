/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salespersonquotahistory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `sales.salespersonquotahistory` */
case class SalespersonquotahistoryId(
  businessentityid: BusinessentityId,
  quotadate: TypoLocalDateTime
)
object SalespersonquotahistoryId {
  implicit def ordering(implicit O0: Ordering[TypoLocalDateTime]): Ordering[SalespersonquotahistoryId] = Ordering.by(x => (x.businessentityid, x.quotadate))
  implicit lazy val reads: Reads[SalespersonquotahistoryId] = Reads[SalespersonquotahistoryId](json => JsResult.fromTry(
      Try(
        SalespersonquotahistoryId(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          quotadate = json.\("quotadate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[SalespersonquotahistoryId] = OWrites[SalespersonquotahistoryId](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "quotadate" -> TypoLocalDateTime.writes.writes(o.quotadate)
    ))
  )
}
