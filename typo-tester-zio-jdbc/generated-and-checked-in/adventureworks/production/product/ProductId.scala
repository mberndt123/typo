/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.product

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `production.product` */
case class ProductId(value: Int) extends AnyVal
object ProductId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[ProductId]] = adventureworks.IntArrayDecoder.map(_.map(ProductId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[ProductId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[ProductId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductId, Int] = Bijection[ProductId, Int](_.value)(ProductId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductId] = JdbcDecoder.intDecoder.map(ProductId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ProductId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ProductId] = JsonDecoder.int.map(ProductId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ProductId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val pgType: PGType[ProductId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[ProductId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[ProductId] = new Text[ProductId] {
    override def unsafeEncode(v: ProductId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ProductId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
