/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import adventureworks.production.product.ProductId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** Type for the composite primary key of table `production.productcosthistory` */
case class ProductcosthistoryId(productid: ProductId, startdate: LocalDateTime)
object ProductcosthistoryId {
  implicit def ordering(implicit O0: Ordering[LocalDateTime]): Ordering[ProductcosthistoryId] = Ordering.by(x => (x.productid, x.startdate))
  implicit val oFormat: OFormat[ProductcosthistoryId] = new OFormat[ProductcosthistoryId]{
    override def writes(o: ProductcosthistoryId): JsObject =
      Json.obj(
        "productid" -> o.productid,
        "startdate" -> o.startdate
      )
  
    override def reads(json: JsValue): JsResult[ProductcosthistoryId] = {
      JsResult.fromTry(
        Try(
          ProductcosthistoryId(
            productid = json.\("productid").as[ProductId],
            startdate = json.\("startdate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
