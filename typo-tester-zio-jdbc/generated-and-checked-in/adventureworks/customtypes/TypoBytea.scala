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
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** This represents the bytea datatype in PostgreSQL */
case class TypoBytea(value: Array[Byte])

object TypoBytea {
  implicit lazy val bijection: Bijection[TypoBytea, Array[Byte]] = Bijection[TypoBytea, Array[Byte]](_.value)(TypoBytea.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoBytea] = JdbcDecoder[TypoBytea](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoBytea(v.asInstanceOf[Array[Byte]])
    },
    "Array[scala.Byte]"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoBytea] = JdbcEncoder.singleParamEncoder(setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoBytea] = JsonDecoder.array[Byte](JsonDecoder.byte, implicitly).map(TypoBytea.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoBytea] = JsonEncoder.array[Byte](JsonEncoder.byte, implicitly).contramap(_.value)
  implicit def ordering(implicit O0: Ordering[Array[Byte]]): Ordering[TypoBytea] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoBytea] = ParameterMetaData.instance[TypoBytea]("bytea", Types.OTHER)
  implicit lazy val setter: Setter[TypoBytea] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        v.value
      )
    },
    "bytea"
  )
  implicit lazy val text: Text[TypoBytea] = new Text[TypoBytea] {
    override def unsafeEncode(v: TypoBytea, sb: StringBuilder) = Text.byteArrayInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TypoBytea, sb: StringBuilder) = Text.byteArrayInstance.unsafeArrayEncode(v.value, sb)
  }
}
