/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import adventureworks.Text
import java.sql.ResultSet
import java.sql.Types
import org.postgresql.geometric.PGcircle
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This represents circle datatype in PostgreSQL, consisting of a point and a radius */
case class TypoCircle(center: TypoPoint, radius: Double)

object TypoCircle {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoCircle]] = JdbcDecoder[Array[TypoCircle]]((rs: ResultSet) => (i: Int) =>
    rs.getArray(i) match {
      case null => null
      case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoCircle(TypoPoint(x.asInstanceOf[PGcircle].center.x, x.asInstanceOf[PGcircle].center.y), x.asInstanceOf[PGcircle].radius))
    },
    "Array[org.postgresql.geometric.PGcircle]"
  )
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoCircle]] = JdbcEncoder.singleParamEncoder(arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoCircle]] = Setter.forSqlType((ps, i, v) =>
    ps.setArray(
      i,
      ps.getConnection.createArrayOf(
        "circle",
        v.map { vv =>
          new PGcircle(vv.center.x, vv.center.y, vv.radius)
        }
      )
    ),
    Types.ARRAY
  )
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoCircle] = JdbcDecoder[TypoCircle](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoCircle(TypoPoint(v.asInstanceOf[PGcircle].center.x, v.asInstanceOf[PGcircle].center.y), v.asInstanceOf[PGcircle].radius)
    },
    "org.postgresql.geometric.PGcircle"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoCircle] = JdbcEncoder.singleParamEncoder(setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoCircle] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val center = jsonObj.get("center").toRight("Missing field 'center'").flatMap(_.as(TypoPoint.jsonDecoder))
    val radius = jsonObj.get("radius").toRight("Missing field 'radius'").flatMap(_.as(JsonDecoder.double))
    if (center.isRight && radius.isRight)
      Right(TypoCircle(center = center.toOption.get, radius = radius.toOption.get))
    else Left(List[Either[String, Any]](center, radius).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[TypoCircle] = new JsonEncoder[TypoCircle] {
    override def unsafeEncode(a: TypoCircle, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""center":""")
      TypoPoint.jsonEncoder.unsafeEncode(a.center, indent, out)
      out.write(",")
      out.write(""""radius":""")
      JsonEncoder.double.unsafeEncode(a.radius, indent, out)
      out.write("}")
    }
  }
  implicit def ordering(implicit O0: Ordering[TypoPoint]): Ordering[TypoCircle] = Ordering.by(x => (x.center, x.radius))
  implicit lazy val parameterMetadata: ParameterMetaData[TypoCircle] = ParameterMetaData.instance[TypoCircle]("circle", Types.OTHER)
  implicit lazy val setter: Setter[TypoCircle] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        new PGcircle(v.center.x, v.center.y, v.radius)
      )
    },
    "circle"
  )
  implicit lazy val text: Text[TypoCircle] = new Text[TypoCircle] {
    override def unsafeEncode(v: TypoCircle, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"<(${v.center.x},${v.center.y}),${v.radius}>", sb)
    override def unsafeArrayEncode(v: TypoCircle, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"<(${v.center.x},${v.center.y}),${v.radius}>", sb)
  }
}
