/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productcategory

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `production.productcategory` */
case class ProductcategoryId(value: Int) extends AnyVal
object ProductcategoryId {
  implicit lazy val arrayGet: Get[Array[ProductcategoryId]] = adventureworks.IntegerArrayMeta.get.map(_.map(ProductcategoryId.apply))
  implicit lazy val arrayPut: Put[Array[ProductcategoryId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductcategoryId, Int] = Bijection[ProductcategoryId, Int](_.value)(ProductcategoryId.apply)
  implicit lazy val decoder: Decoder[ProductcategoryId] = Decoder.decodeInt.map(ProductcategoryId.apply)
  implicit lazy val encoder: Encoder[ProductcategoryId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[ProductcategoryId] = Meta.IntMeta.get.map(ProductcategoryId.apply)
  implicit lazy val ordering: Ordering[ProductcategoryId] = Ordering.by(_.value)
  implicit lazy val put: Put[ProductcategoryId] = Meta.IntMeta.put.contramap(_.value)
  implicit lazy val text: Text[ProductcategoryId] = new Text[ProductcategoryId] {
    override def unsafeEncode(v: ProductcategoryId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ProductcategoryId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
