/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productdocument

import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `production.productdocument` */
case class ProductdocumentId(
  productid: ProductId,
  documentnode: DocumentId
)
object ProductdocumentId {
  implicit lazy val ordering: Ordering[ProductdocumentId] = Ordering.by(x => (x.productid, x.documentnode))
  implicit lazy val reads: Reads[ProductdocumentId] = Reads[ProductdocumentId](json => JsResult.fromTry(
      Try(
        ProductdocumentId(
          productid = json.\("productid").as(ProductId.reads),
          documentnode = json.\("documentnode").as(DocumentId.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[ProductdocumentId] = OWrites[ProductdocumentId](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "documentnode" -> DocumentId.writes.writes(o.documentnode)
    ))
  )
}
