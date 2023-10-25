/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `production.productsubcategory` */
case class ProductsubcategoryId(value: Int) extends AnyVal
object ProductsubcategoryId {
  implicit lazy val arrayGet: Get[Array[ProductsubcategoryId]] = adventureworks.IntegerArrayMeta.get.map(_.map(ProductsubcategoryId.apply))
  implicit lazy val arrayPut: Put[Array[ProductsubcategoryId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductsubcategoryId, Int] = Bijection[ProductsubcategoryId, Int](_.value)(ProductsubcategoryId.apply)
  implicit lazy val decoder: Decoder[ProductsubcategoryId] = Decoder.decodeInt.map(ProductsubcategoryId.apply)
  implicit lazy val encoder: Encoder[ProductsubcategoryId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[ProductsubcategoryId] = Meta.IntMeta.get.map(ProductsubcategoryId.apply)
  implicit lazy val ordering: Ordering[ProductsubcategoryId] = Ordering.by(_.value)
  implicit lazy val put: Put[ProductsubcategoryId] = Meta.IntMeta.put.contramap(_.value)
  implicit lazy val text: Text[ProductsubcategoryId] = new Text[ProductsubcategoryId] {
    override def unsafeEncode(v: ProductsubcategoryId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ProductsubcategoryId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
