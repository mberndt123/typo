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
import org.postgresql.geometric.PGlseg
import org.postgresql.geometric.PGpoint
import org.postgresql.jdbc.PgArray
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** This implements a line represented by the linear equation Ax + By + C = 0 */
case class TypoLineSegment(p1: TypoPoint, p2: TypoPoint)

object TypoLineSegment {
  implicit lazy val arrayColumn: Column[Array[TypoLineSegment]] = Column.nonNull[Array[TypoLineSegment]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoLineSegment(TypoPoint(v.asInstanceOf[PGlseg].point(0).x, v.asInstanceOf[PGlseg].point(0).y), TypoPoint(v.asInstanceOf[PGlseg].point(1).x, v.asInstanceOf[PGlseg].point(1).y))))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoLineSegment, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoLineSegment]] = ToStatement[Array[TypoLineSegment]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("lseg", v.map(v => new PGlseg(new PGpoint(v.p1.x, v.p1.y), new PGpoint(v.p2.x, v.p2.y))))))
  implicit lazy val column: Column[TypoLineSegment] = Column.nonNull[TypoLineSegment]((v1: Any, _) =>
    v1 match {
      case v: PGlseg => Right(TypoLineSegment(TypoPoint(v.point(0).x, v.point(0).y), TypoPoint(v.point(1).x, v.point(1).y)))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.geometric.PGlseg, got ${other.getClass.getName}"))
    }
  )
  implicit def ordering(implicit O0: Ordering[TypoPoint]): Ordering[TypoLineSegment] = Ordering.by(x => (x.p1, x.p2))
  implicit lazy val parameterMetadata: ParameterMetaData[TypoLineSegment] = new ParameterMetaData[TypoLineSegment] {
    override def sqlType: String = "lseg"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoLineSegment] = Reads[TypoLineSegment](json => JsResult.fromTry(
      Try(
        TypoLineSegment(
          p1 = json.\("p1").as(TypoPoint.reads),
          p2 = json.\("p2").as(TypoPoint.reads)
        )
      )
    ),
  )
  implicit lazy val text: Text[TypoLineSegment] = new Text[TypoLineSegment] {
    override def unsafeEncode(v: TypoLineSegment, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"((${v.p1.x},${v.p1.y}),(${v.p2.x},${v.p2.y}))", sb)
    override def unsafeArrayEncode(v: TypoLineSegment, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"((${v.p1.x},${v.p1.y}),(${v.p2.x},${v.p2.y}))", sb)
  }
  implicit lazy val toStatement: ToStatement[TypoLineSegment] = ToStatement[TypoLineSegment]((s, index, v) => s.setObject(index, new PGlseg(new PGpoint(v.p1.x, v.p1.y), new PGpoint(v.p2.x, v.p2.y))))
  implicit lazy val writes: OWrites[TypoLineSegment] = OWrites[TypoLineSegment](o =>
    new JsObject(ListMap[String, JsValue](
      "p1" -> TypoPoint.writes.writes(o.p1),
      "p2" -> TypoPoint.writes.writes(o.p2)
    ))
  )
}
