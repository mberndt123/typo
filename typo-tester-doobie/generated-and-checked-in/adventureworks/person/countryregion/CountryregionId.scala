/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.countryregion;

import doobie.postgres.Text;
import doobie.util.Get;
import doobie.util.Put;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import typo.dsl.Bijection;

/** Type for the primary key of table `person.countryregion` */
case class CountryregionId(value: /* max 3 chars */ String) extends scala.AnyVal

object CountryregionId {
  implicit lazy val arrayGet: Get[Array[CountryregionId]] = adventureworks.StringArrayMeta.get.map(_.map(CountryregionId.apply))
  implicit lazy val arrayPut: Put[Array[CountryregionId]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CountryregionId, /* max 3 chars */ String] = Bijection[CountryregionId, /* max 3 chars */ String](_.value)(CountryregionId.apply)
  implicit lazy val decoder: Decoder[CountryregionId] = Decoder.decodeString.map(CountryregionId.apply)
  implicit lazy val encoder: Encoder[CountryregionId] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[CountryregionId] = Meta.StringMeta.get.map(CountryregionId.apply)
  implicit lazy val put: Put[CountryregionId] = Meta.StringMeta.put.contramap(_.value)
  implicit lazy val text: Text[CountryregionId] = {
    new Text[CountryregionId] {
      override def unsafeEncode(v: CountryregionId, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: CountryregionId, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
    }
  }
}