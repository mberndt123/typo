/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `production.culture` */
case class CultureId(value: /* bpchar, max 6 chars */ String) extends AnyVal
object CultureId {
  implicit lazy val arraySetter: Setter[Array[CultureId]] = adventureworks.StringArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CultureId, /* bpchar, max 6 chars */ String] = Bijection[CultureId, /* bpchar, max 6 chars */ String](_.value)(CultureId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[CultureId] = JdbcDecoder.stringDecoder.map(CultureId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[CultureId] = JdbcEncoder.stringEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[CultureId] = JsonDecoder.string.map(CultureId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[CultureId] = JsonEncoder.string.contramap(_.value)
  implicit lazy val ordering: Ordering[CultureId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[CultureId] = ParameterMetaData.instance[CultureId](ParameterMetaData.StringParameterMetaData.sqlType, ParameterMetaData.StringParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[CultureId] = Setter.stringSetter.contramap(_.value)
  implicit lazy val text: Text[CultureId] = new Text[CultureId] {
    override def unsafeEncode(v: CultureId, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: CultureId, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
}
