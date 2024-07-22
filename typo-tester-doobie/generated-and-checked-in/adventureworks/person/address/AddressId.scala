/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.address

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `person.address` */
case class AddressId(value: Int) extends AnyVal
object AddressId {
  implicit lazy val arrayGet: Get[Array[AddressId]] = adventureworks.IntegerArrayMeta.get.map(_.map(AddressId.apply))
  implicit lazy val arrayPut: Put[Array[AddressId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[AddressId, Int] = Bijection[AddressId, Int](_.value)(AddressId.apply)
  implicit lazy val decoder: Decoder[AddressId] = Decoder.decodeInt.map(AddressId.apply)
  implicit lazy val encoder: Encoder[AddressId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[AddressId] = Meta.IntMeta.get.map(AddressId.apply)
  implicit lazy val ordering: Ordering[AddressId] = Ordering.by(_.value)
  implicit lazy val put: Put[AddressId] = Meta.IntMeta.put.contramap(_.value)
  implicit lazy val text: Text[AddressId] = new Text[AddressId] {
    override def unsafeEncode(v: AddressId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: AddressId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
