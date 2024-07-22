/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.shift

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `humanresources.shift` */
case class ShiftId(value: Int) extends AnyVal
object ShiftId {
  implicit lazy val arrayGet: Get[Array[ShiftId]] = adventureworks.IntegerArrayMeta.get.map(_.map(ShiftId.apply))
  implicit lazy val arrayPut: Put[Array[ShiftId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ShiftId, Int] = Bijection[ShiftId, Int](_.value)(ShiftId.apply)
  implicit lazy val decoder: Decoder[ShiftId] = Decoder.decodeInt.map(ShiftId.apply)
  implicit lazy val encoder: Encoder[ShiftId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[ShiftId] = Meta.IntMeta.get.map(ShiftId.apply)
  implicit lazy val ordering: Ordering[ShiftId] = Ordering.by(_.value)
  implicit lazy val put: Put[ShiftId] = Meta.IntMeta.put.contramap(_.value)
  implicit lazy val text: Text[ShiftId] = new Text[ShiftId] {
    override def unsafeEncode(v: ShiftId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ShiftId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
