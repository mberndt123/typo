/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.customer

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `sales.customer` */
case class CustomerId(value: Int) extends AnyVal
object CustomerId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[CustomerId]] = adventureworks.IntArrayDecoder.map(_.map(CustomerId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[CustomerId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[CustomerId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CustomerId, Int] = Bijection[CustomerId, Int](_.value)(CustomerId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[CustomerId] = JdbcDecoder.intDecoder.map(CustomerId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[CustomerId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[CustomerId] = JsonDecoder.int.map(CustomerId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[CustomerId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val pgType: PGType[CustomerId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[CustomerId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[CustomerId] = new Text[CustomerId] {
    override def unsafeEncode(v: CustomerId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: CustomerId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
