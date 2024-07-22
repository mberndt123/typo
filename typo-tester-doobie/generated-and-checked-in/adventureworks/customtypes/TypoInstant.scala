/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes;

import cats.data.NonEmptyList;
import doobie.postgres.Text;
import doobie.util.Get;
import doobie.util.Put;
import io.circe.Decoder;
import io.circe.Encoder;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import typo.dsl.Bijection;

/** This is `java.time.TypoInstant`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */
case class TypoInstant(value: Instant)

object TypoInstant {
  def apply(value: Instant): TypoInstant = new TypoInstant(value.truncatedTo(ChronoUnit.MICROS))
  def apply(str: String): TypoInstant = apply(OffsetDateTime.parse(str, parser).toInstant())
  implicit lazy val arrayGet: Get[Array[TypoInstant]] = {
    Get.Advanced.array[AnyRef](NonEmptyList.one("timestamptz[]"))
      .map(_.map(v => TypoInstant(v.asInstanceOf[String])))
  }
  implicit lazy val arrayPut: Put[Array[TypoInstant]] = {
    Put.Advanced.array[AnyRef](NonEmptyList.one("timestamptz[]"), "timestamptz")
      .contramap(_.map(v => v.value.toString))
  }
  implicit lazy val bijection: Bijection[TypoInstant, Instant] = Bijection[TypoInstant, Instant](_.value)(TypoInstant.apply)
  implicit lazy val decoder: Decoder[TypoInstant] = Decoder.decodeInstant.map(TypoInstant.apply)
  implicit lazy val encoder: Encoder[TypoInstant] = Encoder.encodeInstant.contramap(_.value)
  implicit lazy val get: Get[TypoInstant] = {
    Get.Advanced.other[String](NonEmptyList.one("timestamptz"))
      .map(v => TypoInstant(v))
  }
  def now: TypoInstant = new TypoInstant(Instant.now())
  val parser: DateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss").appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true).appendPattern("X").toFormatter()
  implicit lazy val put: Put[TypoInstant] = Put.Advanced.other[String](NonEmptyList.one("timestamptz")).contramap(v => v.value.toString)
  implicit lazy val text: Text[TypoInstant] = {
    new Text[TypoInstant] {
      override def unsafeEncode(v: TypoInstant, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.toString, sb)
      override def unsafeArrayEncode(v: TypoInstant, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.toString, sb)
    }
  }
}