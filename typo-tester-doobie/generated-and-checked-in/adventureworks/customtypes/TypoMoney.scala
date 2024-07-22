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
import typo.dsl.Bijection

/** Money and cash types in PostgreSQL */
case class TypoMoney(value: BigDecimal)

object TypoMoney {
  implicit lazy val arrayGet: Get[Array[TypoMoney]] = Get.Advanced.array[AnyRef](NonEmptyList.one("money[]"))
    .map(_.map(v => TypoMoney(BigDecimal(v.asInstanceOf[java.math.BigDecimal]))))
  implicit lazy val arrayPut: Put[Array[TypoMoney]] = Put.Advanced.array[AnyRef](NonEmptyList.one("money[]"), "money")
    .contramap(_.map(v => v.value.bigDecimal))
  implicit lazy val bijection: Bijection[TypoMoney, BigDecimal] = Bijection[TypoMoney, BigDecimal](_.value)(TypoMoney.apply)
  implicit lazy val decoder: Decoder[TypoMoney] = Decoder.decodeBigDecimal.map(TypoMoney.apply)
  implicit lazy val encoder: Encoder[TypoMoney] = Encoder.encodeBigDecimal.contramap(_.value)
  implicit lazy val get: Get[TypoMoney] = Get.Advanced.other[java.math.BigDecimal](NonEmptyList.one("money"))
    .map(v => TypoMoney(BigDecimal(v)))
  implicit lazy val ordering: Ordering[TypoMoney] = Ordering.by(_.value)
  implicit lazy val put: Put[TypoMoney] = Put.Advanced.other[java.math.BigDecimal](NonEmptyList.one("money")).contramap(v => v.value.bigDecimal)
  implicit lazy val text: Text[TypoMoney] = new Text[TypoMoney] {
    override def unsafeEncode(v: TypoMoney, sb: StringBuilder) = Text.bigDecimalInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TypoMoney, sb: StringBuilder) = Text.bigDecimalInstance.unsafeArrayEncode(v.value, sb)
  }
}
