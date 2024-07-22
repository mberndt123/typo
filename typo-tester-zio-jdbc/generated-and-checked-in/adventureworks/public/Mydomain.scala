/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public

import adventureworks.Text
import java.sql.Types
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Domain `public.mydomain`
  * No constraint
  */
case class Mydomain(value: String)
object Mydomain {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[Mydomain]] = adventureworks.StringArrayDecoder.map(_.map(Mydomain.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[Mydomain]] = adventureworks.StringArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[Mydomain]] = adventureworks.StringArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[Mydomain, String] = Bijection[Mydomain, String](_.value)(Mydomain.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[Mydomain] = JdbcDecoder.stringDecoder.map(Mydomain.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[Mydomain] = JdbcEncoder.stringEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[Mydomain] = JsonDecoder.string.map(Mydomain.apply)
  implicit lazy val jsonEncoder: JsonEncoder[Mydomain] = JsonEncoder.string.contramap(_.value)
  implicit lazy val pgType: PGType[Mydomain] = PGType.instance(""""public"."mydomain"""", Types.OTHER)
  implicit lazy val setter: Setter[Mydomain] = Setter.stringSetter.contramap(_.value)
  implicit lazy val text: Text[Mydomain] = new Text[Mydomain] {
    override def unsafeEncode(v: Mydomain, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: Mydomain, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
}