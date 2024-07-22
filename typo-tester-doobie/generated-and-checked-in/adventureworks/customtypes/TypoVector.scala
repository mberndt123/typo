/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes

import cats.data.NonEmptyList
import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import org.postgresql.jdbc.PgArray
import typo.dsl.Bijection

/** extension: https://github.com/pgvector/pgvector */
case class TypoVector(value: Array[Float])

object TypoVector {
  implicit lazy val bijection: Bijection[TypoVector, Array[Float]] = Bijection[TypoVector, Array[Float]](_.value)(TypoVector.apply)
  implicit lazy val decoder: Decoder[TypoVector] = Decoder.decodeArray[Float](Decoder.decodeFloat, implicitly).map(TypoVector.apply)
  implicit lazy val encoder: Encoder[TypoVector] = Encoder.encodeIterable[Float, Array](Encoder.encodeFloat, implicitly).contramap(_.value)
  implicit lazy val get: Get[TypoVector] = Get.Advanced.other[PgArray](NonEmptyList.one("vector"))
    .map(v => TypoVector(v.getArray.asInstanceOf[Array[java.lang.Float]].map(Float2float)))
  implicit def ordering(implicit O0: Ordering[Array[Float]]): Ordering[TypoVector] = Ordering.by(_.value)
  implicit lazy val put: Put[TypoVector] = Put.Advanced.other[Array[java.lang.Float]](NonEmptyList.one("vector")).contramap(v => v.value.map(x => x: java.lang.Float))
  implicit lazy val text: Text[TypoVector] = new Text[TypoVector] {
    override def unsafeEncode(v: TypoVector, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.mkString("[", ",", "]"), sb)
    override def unsafeArrayEncode(v: TypoVector, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.mkString("[", ",", "]"), sb)
  }
}
