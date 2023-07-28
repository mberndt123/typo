/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

import adventureworks.person.businessentity.BusinessentityId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

/** Type for the composite primary key of table `sales.salespersonquotahistory` */
case class SalespersonquotahistoryId(businessentityid: BusinessentityId, quotadate: LocalDateTime)
object SalespersonquotahistoryId {
  implicit def ordering(implicit O0: Ordering[LocalDateTime]): Ordering[SalespersonquotahistoryId] = Ordering.by(x => (x.businessentityid, x.quotadate))
  implicit val decoder: Decoder[SalespersonquotahistoryId] =
    (c: HCursor) =>
      for {
        businessentityid <- c.downField("businessentityid").as[BusinessentityId]
        quotadate <- c.downField("quotadate").as[LocalDateTime]
      } yield SalespersonquotahistoryId(businessentityid, quotadate)
  implicit val encoder: Encoder[SalespersonquotahistoryId] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "businessentityid" := row.businessentityid,
        "quotadate" := row.quotadate
      )}
}
