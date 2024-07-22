/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productphoto

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `production.productphoto` */
case class ProductphotoId(value: Int) extends AnyVal
object ProductphotoId {
  implicit lazy val arrayGet: Get[Array[ProductphotoId]] = adventureworks.IntegerArrayMeta.get.map(_.map(ProductphotoId.apply))
  implicit lazy val arrayPut: Put[Array[ProductphotoId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductphotoId, Int] = Bijection[ProductphotoId, Int](_.value)(ProductphotoId.apply)
  implicit lazy val decoder: Decoder[ProductphotoId] = Decoder.decodeInt.map(ProductphotoId.apply)
  implicit lazy val encoder: Encoder[ProductphotoId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[ProductphotoId] = Meta.IntMeta.get.map(ProductphotoId.apply)
  implicit lazy val ordering: Ordering[ProductphotoId] = Ordering.by(_.value)
  implicit lazy val put: Put[ProductphotoId] = Meta.IntMeta.put.contramap(_.value)
  implicit lazy val text: Text[ProductphotoId] = new Text[ProductphotoId] {
    override def unsafeEncode(v: ProductphotoId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ProductphotoId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
