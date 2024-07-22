/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.myschema.marital_status

import testdb.hardcoded.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `myschema.marital_status` */
case class MaritalStatusId(value: Long) extends AnyVal
object MaritalStatusId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[MaritalStatusId]] = testdb.hardcoded.LongArrayDecoder.map(_.map(MaritalStatusId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[MaritalStatusId]] = testdb.hardcoded.LongArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[MaritalStatusId]] = testdb.hardcoded.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[MaritalStatusId, Long] = Bijection[MaritalStatusId, Long](_.value)(MaritalStatusId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[MaritalStatusId] = JdbcDecoder.longDecoder.map(MaritalStatusId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[MaritalStatusId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[MaritalStatusId] = JsonDecoder.long.map(MaritalStatusId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[MaritalStatusId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[MaritalStatusId] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[MaritalStatusId] = PGType.PGTypeLong.as
  implicit lazy val setter: Setter[MaritalStatusId] = Setter.longSetter.contramap(_.value)
  implicit lazy val text: Text[MaritalStatusId] = new Text[MaritalStatusId] {
    override def unsafeEncode(v: MaritalStatusId, sb: StringBuilder) = Text.longInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: MaritalStatusId, sb: StringBuilder) = Text.longInstance.unsafeArrayEncode(v.value, sb)
  }
}
