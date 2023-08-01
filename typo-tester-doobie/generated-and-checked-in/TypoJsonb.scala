/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import cats.data.NonEmptyList
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import org.postgresql.util.PGobject
import typo.dsl.Bijection

/** jsonb (via PGObject) */
case class TypoJsonb(value: String)

object TypoJsonb {
  implicit val arrayGet: Get[Array[TypoJsonb]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_jsonb"))
    .map(_.map(v => TypoJsonb(v.asInstanceOf[String])))
  implicit val arrayPut: Put[Array[TypoJsonb]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_jsonb"), "jsonb")
    .contramap(_.map(v => {
                            val obj = new PGobject
                            obj.setType("jsonb")
                            obj.setValue(v.value)
                            obj
                          }))
  implicit val bijection: Bijection[TypoJsonb, String] = Bijection[TypoJsonb, String](_.value)(TypoJsonb.apply)
  implicit val decoder: Decoder[TypoJsonb] = Decoder.decodeString.map(TypoJsonb.apply)
  implicit val encoder: Encoder[TypoJsonb] = Encoder.encodeString.contramap(_.value)
  implicit val get: Get[TypoJsonb] = Get.Advanced.other[PGobject](NonEmptyList.one("jsonb"))
    .map(v => TypoJsonb(v.getValue))
  implicit val ordering: Ordering[TypoJsonb] = Ordering.by(_.value)
  implicit val put: Put[TypoJsonb] = Put.Advanced.other[PGobject](NonEmptyList.one("jsonb")).contramap(v => {
                                                                           val obj = new PGobject
                                                                           obj.setType("jsonb")
                                                                           obj.setValue(v.value)
                                                                           obj
                                                                         })
}
