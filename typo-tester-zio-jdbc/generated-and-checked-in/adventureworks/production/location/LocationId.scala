/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.location

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `production.location` */
case class LocationId(value: Int) extends AnyVal
object LocationId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[LocationId]] = adventureworks.IntArrayDecoder.map(_.map(LocationId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[LocationId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[LocationId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[LocationId, Int] = Bijection[LocationId, Int](_.value)(LocationId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[LocationId] = JdbcDecoder.intDecoder.map(LocationId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[LocationId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[LocationId] = JsonDecoder.int.map(LocationId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[LocationId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[LocationId] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[LocationId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[LocationId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[LocationId] = new Text[LocationId] {
    override def unsafeEncode(v: LocationId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: LocationId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
