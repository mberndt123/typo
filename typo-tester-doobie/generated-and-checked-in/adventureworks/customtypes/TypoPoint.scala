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
import org.postgresql.geometric.PGpoint;

/** Point datatype in PostgreSQL */
case class TypoPoint(x: Double, y: Double)

object TypoPoint {
  implicit lazy val arrayGet: Get[Array[TypoPoint]] = {
    Get.Advanced.array[AnyRef](NonEmptyList.one("point[]"))
      .map(_.map(v => TypoPoint(v.asInstanceOf[PGpoint].x, v.asInstanceOf[PGpoint].y)))
  }
  implicit lazy val arrayPut: Put[Array[TypoPoint]] = {
    Put.Advanced.array[AnyRef](NonEmptyList.one("point[]"), "point")
      .contramap(_.map(v => new PGpoint(v.x, v.y)))
  }
  implicit lazy val decoder: Decoder[TypoPoint] = Decoder.forProduct2[TypoPoint, Double, Double]("x", "y")(TypoPoint.apply)(Decoder.decodeDouble, Decoder.decodeDouble)
  implicit lazy val encoder: Encoder[TypoPoint] = Encoder.forProduct2[TypoPoint, Double, Double]("x", "y")(x => (x.x, x.y))(Encoder.encodeDouble, Encoder.encodeDouble)
  implicit lazy val get: Get[TypoPoint] = {
    Get.Advanced.other[PGpoint](NonEmptyList.one("point"))
      .map(v => TypoPoint(v.x, v.y))
  }
  implicit lazy val put: Put[TypoPoint] = Put.Advanced.other[PGpoint](NonEmptyList.one("point")).contramap(v => new PGpoint(v.x, v.y))
  implicit lazy val text: Text[TypoPoint] = {
    new Text[TypoPoint] {
      override def unsafeEncode(v: TypoPoint, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"(${v.x},${v.y})", sb)
      override def unsafeArrayEncode(v: TypoPoint, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"(${v.x},${v.y})", sb)
    }
  }
}