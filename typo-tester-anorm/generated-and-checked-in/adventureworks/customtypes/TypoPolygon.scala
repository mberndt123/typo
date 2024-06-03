/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import org.postgresql.geometric.PGpoint
import org.postgresql.geometric.PGpolygon
import org.postgresql.jdbc.PgArray
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Polygon datatype in PostgreSQL */
case class TypoPolygon(points: List[TypoPoint])

object TypoPolygon {
  implicit lazy val arrayColumn: Column[Array[TypoPolygon]] = Column.nonNull[Array[TypoPolygon]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoPolygon(v.asInstanceOf[PGpolygon].points.map(p => TypoPoint(p.x, p.y)).toList)))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoPolygon, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoPolygon]] = ToStatement[Array[TypoPolygon]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("polygon", v.map(v => new PGpolygon(v.points.map(p => new PGpoint(p.x, p.y)).toArray)))))
  implicit lazy val bijection: Bijection[TypoPolygon, List[TypoPoint]] = Bijection[TypoPolygon, List[TypoPoint]](_.points)(TypoPolygon.apply)
  implicit lazy val column: Column[TypoPolygon] = Column.nonNull[TypoPolygon]((v1: Any, _) =>
    v1 match {
      case v: PGpolygon => Right(TypoPolygon(v.points.map(p => TypoPoint(p.x, p.y)).toList))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.geometric.PGpolygon, got ${other.getClass.getName}"))
    }
  )
  implicit def ordering(implicit O0: Ordering[List[TypoPoint]]): Ordering[TypoPolygon] = Ordering.by(_.points)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoPolygon] = new ParameterMetaData[TypoPolygon] {
    override def sqlType: String = "polygon"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoPolygon] = implicitly[Reads[List[TypoPoint]]].map(TypoPolygon.apply)
  implicit lazy val text: Text[TypoPolygon] = new Text[TypoPolygon] {
    override def unsafeEncode(v: TypoPolygon, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"""(${v.points.map(p => s"${p.x}, ${p.y}").mkString(",")})""", sb)
    override def unsafeArrayEncode(v: TypoPolygon, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"""(${v.points.map(p => s"${p.x}, ${p.y}").mkString(",")})""", sb)
  }
  implicit lazy val toStatement: ToStatement[TypoPolygon] = ToStatement[TypoPolygon]((s, index, v) => s.setObject(index, new PGpolygon(v.points.map(p => new PGpoint(p.x, p.y)).toArray)))
  implicit lazy val writes: Writes[TypoPolygon] = implicitly[Writes[List[TypoPoint]]].contramap(_.points)
}
