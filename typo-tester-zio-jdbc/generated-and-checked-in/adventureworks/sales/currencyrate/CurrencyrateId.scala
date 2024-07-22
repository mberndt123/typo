/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.currencyrate

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `sales.currencyrate` */
case class CurrencyrateId(value: Int) extends AnyVal
object CurrencyrateId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[CurrencyrateId]] = adventureworks.IntArrayDecoder.map(_.map(CurrencyrateId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[CurrencyrateId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[CurrencyrateId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CurrencyrateId, Int] = Bijection[CurrencyrateId, Int](_.value)(CurrencyrateId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[CurrencyrateId] = JdbcDecoder.intDecoder.map(CurrencyrateId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[CurrencyrateId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[CurrencyrateId] = JsonDecoder.int.map(CurrencyrateId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[CurrencyrateId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val pgType: PGType[CurrencyrateId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[CurrencyrateId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[CurrencyrateId] = new Text[CurrencyrateId] {
    override def unsafeEncode(v: CurrencyrateId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: CurrencyrateId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
