/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `person.stateprovince` */
case class StateprovinceId(value: Int) extends AnyVal
object StateprovinceId {
  implicit lazy val arraySetter: Setter[Array[StateprovinceId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[StateprovinceId, Int] = Bijection[StateprovinceId, Int](_.value)(StateprovinceId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[StateprovinceId] = JdbcDecoder.intDecoder.map(StateprovinceId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[StateprovinceId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[StateprovinceId] = JsonDecoder.int.map(StateprovinceId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[StateprovinceId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[StateprovinceId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[StateprovinceId] = ParameterMetaData.instance[StateprovinceId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[StateprovinceId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[StateprovinceId] = new Text[StateprovinceId] {
    override def unsafeEncode(v: StateprovinceId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: StateprovinceId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
