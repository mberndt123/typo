/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productproductphoto

import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `production.productproductphoto` */
case class ProductproductphotoId(
  productid: ProductId,
  productphotoid: ProductphotoId
)
object ProductproductphotoId {
  implicit lazy val ordering: Ordering[ProductproductphotoId] = Ordering.by(x => (x.productid, x.productphotoid))
  implicit lazy val reads: Reads[ProductproductphotoId] = Reads[ProductproductphotoId](json => JsResult.fromTry(
      Try(
        ProductproductphotoId(
          productid = json.\("productid").as(ProductId.reads),
          productphotoid = json.\("productphotoid").as(ProductphotoId.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[ProductproductphotoId] = OWrites[ProductproductphotoId](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "productphotoid" -> ProductphotoId.writes.writes(o.productphotoid)
    ))
  )
}
