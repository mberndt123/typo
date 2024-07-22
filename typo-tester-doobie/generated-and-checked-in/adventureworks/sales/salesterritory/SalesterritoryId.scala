/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesterritory

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `sales.salesterritory` */
case class SalesterritoryId(value: Int) extends AnyVal
object SalesterritoryId {
  implicit lazy val arrayGet: Get[Array[SalesterritoryId]] = adventureworks.IntegerArrayMeta.get.map(_.map(SalesterritoryId.apply))
  implicit lazy val arrayPut: Put[Array[SalesterritoryId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[SalesterritoryId, Int] = Bijection[SalesterritoryId, Int](_.value)(SalesterritoryId.apply)
  implicit lazy val decoder: Decoder[SalesterritoryId] = Decoder.decodeInt.map(SalesterritoryId.apply)
  implicit lazy val encoder: Encoder[SalesterritoryId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[SalesterritoryId] = Meta.IntMeta.get.map(SalesterritoryId.apply)
  implicit lazy val ordering: Ordering[SalesterritoryId] = Ordering.by(_.value)
  implicit lazy val put: Put[SalesterritoryId] = Meta.IntMeta.put.contramap(_.value)
  implicit lazy val text: Text[SalesterritoryId] = new Text[SalesterritoryId] {
    override def unsafeEncode(v: SalesterritoryId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: SalesterritoryId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
