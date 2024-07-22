/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.currency

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `sales.currency` */
case class CurrencyId(value: /* bpchar, max 3 chars */ String) extends AnyVal
object CurrencyId {
  implicit lazy val arrayGet: Get[Array[CurrencyId]] = adventureworks.StringArrayMeta.get.map(_.map(CurrencyId.apply))
  implicit lazy val arrayPut: Put[Array[CurrencyId]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CurrencyId, /* bpchar, max 3 chars */ String] = Bijection[CurrencyId, /* bpchar, max 3 chars */ String](_.value)(CurrencyId.apply)
  implicit lazy val decoder: Decoder[CurrencyId] = Decoder.decodeString.map(CurrencyId.apply)
  implicit lazy val encoder: Encoder[CurrencyId] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[CurrencyId] = Meta.StringMeta.get.map(CurrencyId.apply)
  implicit lazy val put: Put[CurrencyId] = Meta.StringMeta.put.contramap(_.value)
  implicit lazy val text: Text[CurrencyId] = new Text[CurrencyId] {
    override def unsafeEncode(v: CurrencyId, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: CurrencyId, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
}
