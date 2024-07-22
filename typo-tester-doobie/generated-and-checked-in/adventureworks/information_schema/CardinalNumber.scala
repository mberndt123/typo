/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.information_schema;

import doobie.postgres.Text;
import doobie.util.Get;
import doobie.util.Put;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import typo.dsl.Bijection;

/** Domain `information_schema.cardinal_number`
  * Constraint: CHECK ((VALUE >= 0))
  */
case class CardinalNumber(value: Int)

object CardinalNumber {
  implicit lazy val arrayGet: Get[Array[CardinalNumber]] = adventureworks.IntegerArrayMeta.get.map(_.map(CardinalNumber.apply))
  implicit lazy val arrayPut: Put[Array[CardinalNumber]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CardinalNumber, Int] = Bijection[CardinalNumber, Int](_.value)(CardinalNumber.apply)
  implicit lazy val decoder: Decoder[CardinalNumber] = Decoder.decodeInt.map(CardinalNumber.apply)
  implicit lazy val encoder: Encoder[CardinalNumber] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[CardinalNumber] = Meta.IntMeta.get.map(CardinalNumber.apply)
  implicit lazy val put: Put[CardinalNumber] = Meta.IntMeta.put.contramap(_.value)
  implicit lazy val text: Text[CardinalNumber] = {
    new Text[CardinalNumber] {
      override def unsafeEncode(v: CardinalNumber, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: CardinalNumber, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
    }
  }
}