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
import org.postgresql.geometric.PGpoint
import org.postgresql.geometric.PGpolygon
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Polygon datatype in PostgreSQL */
case class TypoPolygon(points: List[TypoPoint])

object TypoPolygon {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoPolygon]] = JdbcDecoder[Array[TypoPolygon]]((rs: ResultSet) => (i: Int) =>
    rs.getArray(i) match {
      case null => null
      case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoPolygon(x.asInstanceOf[PGpolygon].points.map(p => TypoPoint(p.x, p.y)).toList))
    },
    "Array[org.postgresql.geometric.PGpolygon]"
  )
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoPolygon]] = JdbcEncoder.singleParamEncoder(arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoPolygon]] = Setter.forSqlType((ps, i, v) =>
    ps.setArray(
      i,
      ps.getConnection.createArrayOf(
        "polygon",
        v.map { vv =>
          new PGpolygon(vv.points.map(p => new PGpoint(p.x, p.y)).toArray)
        }
      )
    ),
    Types.ARRAY
  )
  implicit lazy val bijection: Bijection[TypoPolygon, List[TypoPoint]] = Bijection[TypoPolygon, List[TypoPoint]](_.points)(TypoPolygon.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoPolygon] = JdbcDecoder[TypoPolygon](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoPolygon(v.asInstanceOf[PGpolygon].points.map(p => TypoPoint(p.x, p.y)).toList)
    },
    "org.postgresql.geometric.PGpolygon"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoPolygon] = JdbcEncoder.singleParamEncoder(setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoPolygon] = JsonDecoder[List[TypoPoint]].map(TypoPolygon.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoPolygon] = JsonEncoder[List[TypoPoint]].contramap(_.points)
  implicit def ordering(implicit O0: Ordering[List[TypoPoint]]): Ordering[TypoPolygon] = Ordering.by(_.points)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoPolygon] = ParameterMetaData.instance[TypoPolygon]("polygon", Types.OTHER)
  implicit lazy val setter: Setter[TypoPolygon] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        new PGpolygon(v.points.map(p => new PGpoint(p.x, p.y)).toArray)
      )
    },
    "polygon"
  )
  implicit lazy val text: Text[TypoPolygon] = new Text[TypoPolygon] {
    override def unsafeEncode(v: TypoPolygon, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"""(${v.points.map(p => s"${p.x}, ${p.y}").mkString(",")})""", sb)
    override def unsafeArrayEncode(v: TypoPolygon, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"""(${v.points.map(p => s"${p.x}, ${p.y}").mkString(",")})""", sb)
  }
}
