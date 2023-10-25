/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Domain `public.NameStyle`
  * No constraint
  */
case class NameStyle(value: Boolean) extends AnyVal
object NameStyle {
  implicit lazy val arraySetter: Setter[Array[NameStyle]] = adventureworks.BooleanArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[NameStyle, Boolean] = Bijection[NameStyle, Boolean](_.value)(NameStyle.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[NameStyle] = JdbcDecoder.booleanDecoder.map(NameStyle.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[NameStyle] = JdbcEncoder.booleanEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[NameStyle] = JsonDecoder.boolean.map(NameStyle.apply)
  implicit lazy val jsonEncoder: JsonEncoder[NameStyle] = JsonEncoder.boolean.contramap(_.value)
  implicit lazy val ordering: Ordering[NameStyle] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[NameStyle] = ParameterMetaData.instance[NameStyle](ParameterMetaData.BooleanParameterMetaData.sqlType, ParameterMetaData.BooleanParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[NameStyle] = Setter.booleanSetter.contramap(_.value)
  implicit lazy val text: Text[NameStyle] = new Text[NameStyle] {
    override def unsafeEncode(v: NameStyle, sb: StringBuilder) = Text.booleanInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: NameStyle, sb: StringBuilder) = Text.booleanInstance.unsafeArrayEncode(v.value, sb)
  }
}