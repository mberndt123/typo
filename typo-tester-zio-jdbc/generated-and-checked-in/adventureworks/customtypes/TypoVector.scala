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
import org.postgresql.jdbc.PgArray
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** extension: https://github.com/pgvector/pgvector */
case class TypoVector(value: Array[Float])

object TypoVector {
  implicit lazy val bijection: Bijection[TypoVector, Array[Float]] = Bijection[TypoVector, Array[Float]](_.value)(TypoVector.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoVector] = JdbcDecoder[TypoVector](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoVector(v.asInstanceOf[PgArray].getArray.asInstanceOf[Array[java.lang.Float]].map(Float2float))
    },
    "Array[java.lang.Float]"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoVector] = JdbcEncoder.singleParamEncoder(setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoVector] = JsonDecoder.array[Float](JsonDecoder.float, implicitly).map(TypoVector.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoVector] = JsonEncoder.array[Float](JsonEncoder.float, implicitly).contramap(_.value)
  implicit def ordering(implicit O0: Ordering[Array[Float]]): Ordering[TypoVector] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoVector] = ParameterMetaData.instance[TypoVector]("vector", Types.OTHER)
  implicit lazy val setter: Setter[TypoVector] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        v.value.map(x => x: java.lang.Float)
      )
    },
    "vector"
  )
  implicit lazy val text: Text[TypoVector] = new Text[TypoVector] {
    override def unsafeEncode(v: TypoVector, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.mkString("[", ",", "]"), sb)
    override def unsafeArrayEncode(v: TypoVector, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.mkString("[", ",", "]"), sb)
  }
}
