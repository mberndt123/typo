/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Domain `public.NameStyle`
  * No constraint
  */
case class NameStyle(value: Boolean) extends AnyVal
object NameStyle {
  implicit lazy val arrayGet: Get[Array[NameStyle]] = adventureworks.BooleanArrayMeta.get.map(_.map(NameStyle.apply))
  implicit lazy val arrayPut: Put[Array[NameStyle]] = adventureworks.BooleanArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[NameStyle, Boolean] = Bijection[NameStyle, Boolean](_.value)(NameStyle.apply)
  implicit lazy val decoder: Decoder[NameStyle] = Decoder.decodeBoolean.map(NameStyle.apply)
  implicit lazy val encoder: Encoder[NameStyle] = Encoder.encodeBoolean.contramap(_.value)
  implicit lazy val get: Get[NameStyle] = Meta.BooleanMeta.get.map(NameStyle.apply)
  implicit lazy val ordering: Ordering[NameStyle] = Ordering.by(_.value)
  implicit lazy val put: Put[NameStyle] = Meta.BooleanMeta.put.contramap(_.value)
  implicit lazy val text: Text[NameStyle] = new Text[NameStyle] {
    override def unsafeEncode(v: NameStyle, sb: StringBuilder) = Text.booleanInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: NameStyle, sb: StringBuilder) = Text.booleanInstance.unsafeArrayEncode(v.value, sb)
  }
}