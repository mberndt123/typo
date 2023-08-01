/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `production.culture` */
case class CultureId(value: /* bpchar */ String) extends AnyVal
object CultureId {
  implicit val arrayGet: Get[Array[CultureId]] = adventureworks.StringArrayMeta.get.map(_.map(CultureId.apply))
  implicit val arrayPut: Put[Array[CultureId]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[CultureId, /* bpchar */ String] = Bijection[CultureId, /* bpchar */ String](_.value)(CultureId.apply)
  implicit val decoder: Decoder[CultureId] = Decoder.decodeString.map(CultureId.apply)
  implicit val encoder: Encoder[CultureId] = Encoder.encodeString.contramap(_.value)
  implicit val get: Get[CultureId] = Meta.StringMeta.get.map(CultureId.apply)
  implicit val ordering: Ordering[CultureId] = Ordering.by(_.value)
  implicit val put: Put[CultureId] = Meta.StringMeta.put.contramap(_.value)
}
