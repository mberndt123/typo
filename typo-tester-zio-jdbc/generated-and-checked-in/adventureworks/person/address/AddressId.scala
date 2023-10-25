/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `person.address` */
case class AddressId(value: Int) extends AnyVal
object AddressId {
  implicit lazy val arraySetter: Setter[Array[AddressId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[AddressId, Int] = Bijection[AddressId, Int](_.value)(AddressId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[AddressId] = JdbcDecoder.intDecoder.map(AddressId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[AddressId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[AddressId] = JsonDecoder.int.map(AddressId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[AddressId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[AddressId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[AddressId] = ParameterMetaData.instance[AddressId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[AddressId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[AddressId] = new Text[AddressId] {
    override def unsafeEncode(v: AddressId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: AddressId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
