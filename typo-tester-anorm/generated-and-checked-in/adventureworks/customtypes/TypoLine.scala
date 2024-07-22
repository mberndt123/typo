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
import org.postgresql.geometric.PGline;
import org.postgresql.jdbc.PgArray;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** This implements a line represented by the linear equation Ax + By + C = 0 */
case class TypoLine(a: Double, b: Double, c: Double)

object TypoLine {
  implicit lazy val arrayColumn: Column[Array[TypoLine]] = {
    Column.nonNull[Array[TypoLine]]((v1: Any, _) =>
      v1 match {
          case v: PgArray =>
           v.getArray match {
             case v: Array[?] =>
               Right(v.map(v => TypoLine(v.asInstanceOf[PGline].a, v.asInstanceOf[PGline].b, v.asInstanceOf[PGline].c)))
             case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoLine, got ${other.getClass.getName}"))
           }
        case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
      }
    )
  }
  implicit lazy val arrayToStatement: ToStatement[Array[TypoLine]] = ToStatement[Array[TypoLine]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("line", v.map(v => new PGline(v.a, v.b, v.c)))))
  implicit lazy val column: Column[TypoLine] = {
    Column.nonNull[TypoLine]((v1: Any, _) =>
      v1 match {
        case v: PGline => Right(TypoLine(v.a, v.b, v.c))
        case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.geometric.PGline, got ${other.getClass.getName}"))
      }
    )
  }
  implicit lazy val parameterMetadata: ParameterMetaData[TypoLine] = {
    new ParameterMetaData[TypoLine] {
      override def sqlType: String = "line"
      override def jdbcType: Int = Types.OTHER
    }
  }
  implicit lazy val reads: Reads[TypoLine] = {
    Reads[TypoLine](json => JsResult.fromTry(
        Try(
          TypoLine(
            a = json.\("a").as(Reads.DoubleReads),
            b = json.\("b").as(Reads.DoubleReads),
            c = json.\("c").as(Reads.DoubleReads)
          )
        )
      ),
    )
  }
  implicit lazy val text: Text[TypoLine] = {
    new Text[TypoLine] {
      override def unsafeEncode(v: TypoLine, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"{${v.a},${v.b},${v.c}}", sb)
      override def unsafeArrayEncode(v: TypoLine, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"{${v.a},${v.b},${v.c}}", sb)
    }
  }
  implicit lazy val toStatement: ToStatement[TypoLine] = ToStatement[TypoLine]((s, index, v) => s.setObject(index, new PGline(v.a, v.b, v.c)))
  implicit lazy val writes: OWrites[TypoLine] = {
    OWrites[TypoLine](o =>
      new JsObject(ListMap[String, JsValue](
        "a" -> Writes.DoubleWrites.writes(o.a),
        "b" -> Writes.DoubleWrites.writes(o.b),
        "c" -> Writes.DoubleWrites.writes(o.c)
      ))
    )
  }
}