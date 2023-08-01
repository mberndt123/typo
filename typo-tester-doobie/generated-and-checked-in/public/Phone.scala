/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Domain `public.Phone`
  * No constraint
  */
case class Phone(value: String) extends AnyVal
object Phone {
  implicit val arrayGet: Get[Array[Phone]] = adventureworks.StringArrayMeta.get.map(_.map(Phone.apply))
  implicit val arrayPut: Put[Array[Phone]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[Phone, String] = Bijection[Phone, String](_.value)(Phone.apply)
  implicit val decoder: Decoder[Phone] = Decoder.decodeString.map(Phone.apply)
  implicit val encoder: Encoder[Phone] = Encoder.encodeString.contramap(_.value)
  implicit val get: Get[Phone] = Meta.StringMeta.get.map(Phone.apply)
  implicit val ordering: Ordering[Phone] = Ordering.by(_.value)
  implicit val put: Put[Phone] = Meta.StringMeta.put.contramap(_.value)
}
