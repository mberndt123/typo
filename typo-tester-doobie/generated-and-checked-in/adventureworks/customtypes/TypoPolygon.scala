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
import org.postgresql.geometric.PGpolygon;
import typo.dsl.Bijection;

/** Polygon datatype in PostgreSQL */
case class TypoPolygon(points: List[TypoPoint])

object TypoPolygon {
  implicit lazy val arrayGet: Get[Array[TypoPolygon]] = {
    Get.Advanced.array[AnyRef](NonEmptyList.one("polygon[]"))
      .map(_.map(v => TypoPolygon(v.asInstanceOf[PGpolygon].points.map(p => TypoPoint(p.x, p.y)).toList)))
  }
  implicit lazy val arrayPut: Put[Array[TypoPolygon]] = {
    Put.Advanced.array[AnyRef](NonEmptyList.one("polygon[]"), "polygon")
      .contramap(_.map(v => new PGpolygon(v.points.map(p => new PGpoint(p.x, p.y)).toArray)))
  }
  implicit lazy val bijection: Bijection[TypoPolygon, List[TypoPoint]] = Bijection[TypoPolygon, List[TypoPoint]](_.points)(TypoPolygon.apply)
  implicit lazy val decoder: Decoder[TypoPolygon] = Decoder[List[TypoPoint]].map(TypoPolygon.apply)
  implicit lazy val encoder: Encoder[TypoPolygon] = Encoder[List[TypoPoint]].contramap(_.points)
  implicit lazy val get: Get[TypoPolygon] = {
    Get.Advanced.other[PGpolygon](NonEmptyList.one("polygon"))
      .map(v => TypoPolygon(v.points.map(p => TypoPoint(p.x, p.y)).toList))
  }
  implicit lazy val put: Put[TypoPolygon] = Put.Advanced.other[PGpolygon](NonEmptyList.one("polygon")).contramap(v => new PGpolygon(v.points.map(p => new PGpoint(p.x, p.y)).toArray))
  implicit lazy val text: Text[TypoPolygon] = {
    new Text[TypoPolygon] {
      override def unsafeEncode(v: TypoPolygon, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"""(${v.points.map(p => s"${p.x}, ${p.y}").mkString(",")})""", sb)
      override def unsafeArrayEncode(v: TypoPolygon, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"""(${v.points.map(p => s"${p.x}, ${p.y}").mkString(",")})""", sb)
    }
  }
}