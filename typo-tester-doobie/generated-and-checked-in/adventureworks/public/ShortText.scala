/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Domain `public.short_text`
  * Constraint: CHECK ((length(VALUE) <= 55))
  */
case class ShortText(value: String)
object ShortText {
  implicit lazy val arrayGet: Get[Array[ShortText]] = adventureworks.StringArrayMeta.get.map(_.map(ShortText.apply))
  implicit lazy val arrayPut: Put[Array[ShortText]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ShortText, String] = Bijection[ShortText, String](_.value)(ShortText.apply)
  implicit lazy val decoder: Decoder[ShortText] = Decoder.decodeString.map(ShortText.apply)
  implicit lazy val encoder: Encoder[ShortText] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[ShortText] = Meta.StringMeta.get.map(ShortText.apply)
  implicit lazy val put: Put[ShortText] = Meta.StringMeta.put.contramap(_.value)
  implicit lazy val text: Text[ShortText] = new Text[ShortText] {
    override def unsafeEncode(v: ShortText, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ShortText, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
}