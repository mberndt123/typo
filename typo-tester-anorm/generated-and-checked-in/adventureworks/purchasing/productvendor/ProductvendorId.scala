/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.productvendor

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `purchasing.productvendor` */
case class ProductvendorId(
  productid: ProductId,
  businessentityid: BusinessentityId
)
object ProductvendorId {
  implicit lazy val reads: Reads[ProductvendorId] = Reads[ProductvendorId](json => JsResult.fromTry(
      Try(
        ProductvendorId(
          productid = json.\("productid").as(ProductId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[ProductvendorId] = OWrites[ProductvendorId](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid)
    ))
  )
}
