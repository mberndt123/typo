/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.shoppingcartitem

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `sales.shoppingcartitem` */
case class ShoppingcartitemId(value: Int) extends AnyVal
object ShoppingcartitemId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[ShoppingcartitemId]] = adventureworks.IntArrayDecoder.map(_.map(ShoppingcartitemId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[ShoppingcartitemId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[ShoppingcartitemId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ShoppingcartitemId, Int] = Bijection[ShoppingcartitemId, Int](_.value)(ShoppingcartitemId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ShoppingcartitemId] = JdbcDecoder.intDecoder.map(ShoppingcartitemId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ShoppingcartitemId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ShoppingcartitemId] = JsonDecoder.int.map(ShoppingcartitemId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ShoppingcartitemId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[ShoppingcartitemId] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[ShoppingcartitemId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[ShoppingcartitemId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[ShoppingcartitemId] = new Text[ShoppingcartitemId] {
    override def unsafeEncode(v: ShoppingcartitemId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ShoppingcartitemId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
