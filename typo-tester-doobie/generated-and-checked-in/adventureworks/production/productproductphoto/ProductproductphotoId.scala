/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productproductphoto

import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `production.productproductphoto` */
case class ProductproductphotoId(
  productid: ProductId,
  productphotoid: ProductphotoId
)
object ProductproductphotoId {
  implicit lazy val decoder: Decoder[ProductproductphotoId] = Decoder.forProduct2[ProductproductphotoId, ProductId, ProductphotoId]("productid", "productphotoid")(ProductproductphotoId.apply)(ProductId.decoder, ProductphotoId.decoder)
  implicit lazy val encoder: Encoder[ProductproductphotoId] = Encoder.forProduct2[ProductproductphotoId, ProductId, ProductphotoId]("productid", "productphotoid")(x => (x.productid, x.productphotoid))(ProductId.encoder, ProductphotoId.encoder)
}
