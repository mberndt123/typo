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

/** Domain `public.Name`
  * No constraint
  */
case class Name(value: String)
object Name {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[Name]] = adventureworks.StringArrayDecoder.map(_.map(Name.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[Name]] = adventureworks.StringArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[Name]] = adventureworks.StringArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[Name, String] = Bijection[Name, String](_.value)(Name.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[Name] = JdbcDecoder.stringDecoder.map(Name.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[Name] = JdbcEncoder.stringEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[Name] = JsonDecoder.string.map(Name.apply)
  implicit lazy val jsonEncoder: JsonEncoder[Name] = JsonEncoder.string.contramap(_.value)
  implicit lazy val ordering: Ordering[Name] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[Name] = PGType.instance(""""public"."Name"""", Types.OTHER)
  implicit lazy val setter: Setter[Name] = Setter.stringSetter.contramap(_.value)
  implicit lazy val text: Text[Name] = new Text[Name] {
    override def unsafeEncode(v: Name, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: Name, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
}