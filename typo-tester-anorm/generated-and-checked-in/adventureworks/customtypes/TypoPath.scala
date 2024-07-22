/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes;

import adventureworks.Text;
import anorm.Column;
import anorm.ParameterMetaData;
import anorm.ToStatement;
import anorm.TypeDoesNotMatch;
import java.sql.Types;
import org.postgresql.geometric.PGpath;
import org.postgresql.geometric.PGpoint;
import org.postgresql.jdbc.PgArray;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** This implements a path (a multiple segmented line, which may be closed) */
case class TypoPath(open: Boolean, points: List[TypoPoint])

object TypoPath {
  implicit lazy val arrayColumn: Column[Array[TypoPath]] = {
    Column.nonNull[Array[TypoPath]]((v1: Any, _) =>
      v1 match {
          case v: PgArray =>
           v.getArray match {
             case v: Array[?] =>
               Right(v.map(v => TypoPath(v.asInstanceOf[PGpath].isOpen, v.asInstanceOf[PGpath].points.map(p => TypoPoint(p.x, p.y)).toList)))
             case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoPath, got ${other.getClass.getName}"))
           }
        case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
      }
    )
  }
  implicit lazy val arrayToStatement: ToStatement[Array[TypoPath]] = ToStatement[Array[TypoPath]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("path", v.map(v => new PGpath(v.points.map(p => new PGpoint(p.x, p.y)).toArray, v.open)))))
  implicit lazy val column: Column[TypoPath] = {
    Column.nonNull[TypoPath]((v1: Any, _) =>
      v1 match {
        case v: PGpath => Right(TypoPath(v.isOpen, v.points.map(p => TypoPoint(p.x, p.y)).toList))
        case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.geometric.PGpath, got ${other.getClass.getName}"))
      }
    )
  }
  implicit lazy val parameterMetadata: ParameterMetaData[TypoPath] = {
    new ParameterMetaData[TypoPath] {
      override def sqlType: String = "path"
      override def jdbcType: Int = Types.OTHER
    }
  }
  implicit lazy val reads: Reads[TypoPath] = {
    Reads[TypoPath](json => JsResult.fromTry(
        Try(
          TypoPath(
            open = json.\("open").as(Reads.BooleanReads),
            points = json.\("points").as(implicitly[Reads[List[TypoPoint]]])
          )
        )
      ),
    )
  }
  implicit lazy val text: Text[TypoPath] = {
    new Text[TypoPath] {
      override def unsafeEncode(v: TypoPath, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"""${if (v.open) "[" else "("}${v.points.map(p => s"${p.x}, ${p.y}").mkString(",")}${if (v.open) "]" else ")"}""", sb)
      override def unsafeArrayEncode(v: TypoPath, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"""${if (v.open) "[" else "("}${v.points.map(p => s"${p.x}, ${p.y}").mkString(",")}${if (v.open) "]" else ")"}""", sb)
    }
  }
  implicit lazy val toStatement: ToStatement[TypoPath] = ToStatement[TypoPath]((s, index, v) => s.setObject(index, new PGpath(v.points.map(p => new PGpoint(p.x, p.y)).toArray, v.open)))
  implicit lazy val writes: OWrites[TypoPath] = {
    OWrites[TypoPath](o =>
      new JsObject(ListMap[String, JsValue](
        "open" -> Writes.BooleanWrites.writes(o.open),
        "points" -> implicitly[Writes[List[TypoPoint]]].writes(o.points)
      ))
    )
  }
}