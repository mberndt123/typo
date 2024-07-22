/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public;

import doobie.postgres.Text;
import doobie.util.Get;
import doobie.util.Put;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import typo.dsl.Bijection;

/** Domain `public.mydomain`
  * No constraint
  */
case class Mydomain(value: String)

object Mydomain {
  implicit lazy val arrayGet: Get[Array[Mydomain]] = adventureworks.StringArrayMeta.get.map(_.map(Mydomain.apply))
  implicit lazy val arrayPut: Put[Array[Mydomain]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[Mydomain, String] = Bijection[Mydomain, String](_.value)(Mydomain.apply)
  implicit lazy val decoder: Decoder[Mydomain] = Decoder.decodeString.map(Mydomain.apply)
  implicit lazy val encoder: Encoder[Mydomain] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[Mydomain] = Meta.StringMeta.get.map(Mydomain.apply)
  implicit lazy val put: Put[Mydomain] = Meta.StringMeta.put.contramap(_.value)
  implicit lazy val text: Text[Mydomain] = {
    new Text[Mydomain] {
      override def unsafeEncode(v: Mydomain, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: Mydomain, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
    }
  }
}