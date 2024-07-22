/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.phonenumbertype

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `person.phonenumbertype` */
case class PhonenumbertypeId(value: Int) extends AnyVal
object PhonenumbertypeId {
  implicit lazy val arrayGet: Get[Array[PhonenumbertypeId]] = adventureworks.IntegerArrayMeta.get.map(_.map(PhonenumbertypeId.apply))
  implicit lazy val arrayPut: Put[Array[PhonenumbertypeId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PhonenumbertypeId, Int] = Bijection[PhonenumbertypeId, Int](_.value)(PhonenumbertypeId.apply)
  implicit lazy val decoder: Decoder[PhonenumbertypeId] = Decoder.decodeInt.map(PhonenumbertypeId.apply)
  implicit lazy val encoder: Encoder[PhonenumbertypeId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[PhonenumbertypeId] = Meta.IntMeta.get.map(PhonenumbertypeId.apply)
  implicit lazy val put: Put[PhonenumbertypeId] = Meta.IntMeta.put.contramap(_.value)
  implicit lazy val text: Text[PhonenumbertypeId] = new Text[PhonenumbertypeId] {
    override def unsafeEncode(v: PhonenumbertypeId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: PhonenumbertypeId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
