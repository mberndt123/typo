/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productphoto

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `production.productphoto` */
case class ProductphotoId(value: Int) extends AnyVal
object ProductphotoId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[ProductphotoId]] = adventureworks.IntArrayDecoder.map(_.map(ProductphotoId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[ProductphotoId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[ProductphotoId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductphotoId, Int] = Bijection[ProductphotoId, Int](_.value)(ProductphotoId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductphotoId] = JdbcDecoder.intDecoder.map(ProductphotoId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ProductphotoId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ProductphotoId] = JsonDecoder.int.map(ProductphotoId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ProductphotoId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val pgType: PGType[ProductphotoId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[ProductphotoId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[ProductphotoId] = new Text[ProductphotoId] {
    override def unsafeEncode(v: ProductphotoId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ProductphotoId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
