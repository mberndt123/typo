/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes;

import adventureworks.Text;
import java.sql.ResultSet;
import java.sql.Types;
import org.postgresql.geometric.PGlseg;
import org.postgresql.geometric.PGpoint;
import typo.dsl.PGType;
import zio.jdbc.JdbcDecoder;
import zio.jdbc.JdbcEncoder;
import zio.jdbc.SqlFragment.Setter;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** This implements a line represented by the linear equation Ax + By + C = 0 */
case class TypoLineSegment(p1: TypoPoint, p2: TypoPoint)

object TypoLineSegment {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoLineSegment]] = {
    JdbcDecoder[Array[TypoLineSegment]]((rs: ResultSet) => (i: Int) =>
      rs.getArray(i) match {
        case null => null
        case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoLineSegment(TypoPoint(x.asInstanceOf[PGlseg].point(0).x, x.asInstanceOf[PGlseg].point(0).y), TypoPoint(x.asInstanceOf[PGlseg].point(1).x, x.asInstanceOf[PGlseg].point(1).y)))
      },
      "Array[org.postgresql.geometric.PGlseg]"
    )
  }
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoLineSegment]] = JdbcEncoder.singleParamEncoder(using arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoLineSegment]] = {
    Setter.forSqlType((ps, i, v) =>
      ps.setArray(
        i,
        ps.getConnection.createArrayOf(
          "lseg",
          v.map { vv =>
            new PGlseg(new PGpoint(vv.p1.x, vv.p1.y), new PGpoint(vv.p2.x, vv.p2.y))
          }
        )
      ),
      Types.ARRAY
    )
  }
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoLineSegment] = {
    JdbcDecoder[TypoLineSegment](
      (rs: ResultSet) => (i: Int) => {
        val v = rs.getObject(i)
        if (v eq null) null else TypoLineSegment(TypoPoint(v.asInstanceOf[PGlseg].point(0).x, v.asInstanceOf[PGlseg].point(0).y), TypoPoint(v.asInstanceOf[PGlseg].point(1).x, v.asInstanceOf[PGlseg].point(1).y))
      },
      "org.postgresql.geometric.PGlseg"
    )
  }
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoLineSegment] = JdbcEncoder.singleParamEncoder(using setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoLineSegment] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val p1 = jsonObj.get("p1").toRight("Missing field 'p1'").flatMap(_.as(TypoPoint.jsonDecoder))
      val p2 = jsonObj.get("p2").toRight("Missing field 'p2'").flatMap(_.as(TypoPoint.jsonDecoder))
      if (p1.isRight && p2.isRight)
        Right(TypoLineSegment(p1 = p1.toOption.get, p2 = p2.toOption.get))
      else Left(List[Either[String, Any]](p1, p2).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[TypoLineSegment] = {
    new JsonEncoder[TypoLineSegment] {
      override def unsafeEncode(a: TypoLineSegment, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""p1":""")
        TypoPoint.jsonEncoder.unsafeEncode(a.p1, indent, out)
        out.write(",")
        out.write(""""p2":""")
        TypoPoint.jsonEncoder.unsafeEncode(a.p2, indent, out)
        out.write("}")
      }
    }
  }
  implicit lazy val pgType: PGType[TypoLineSegment] = PGType.instance[TypoLineSegment]("lseg", Types.OTHER)
  implicit lazy val setter: Setter[TypoLineSegment] = {
    Setter.other(
      (ps, i, v) => {
        ps.setObject(
          i,
          new PGlseg(new PGpoint(v.p1.x, v.p1.y), new PGpoint(v.p2.x, v.p2.y))
        )
      },
      "lseg"
    )
  }
  implicit lazy val text: Text[TypoLineSegment] = {
    new Text[TypoLineSegment] {
      override def unsafeEncode(v: TypoLineSegment, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"((${v.p1.x},${v.p1.y}),(${v.p2.x},${v.p2.y}))", sb)
      override def unsafeArrayEncode(v: TypoLineSegment, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"((${v.p1.x},${v.p1.y}),(${v.p2.x},${v.p2.y}))", sb)
    }
  }
}