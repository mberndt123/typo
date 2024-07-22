/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public.users;

import adventureworks.Text;
import adventureworks.customtypes.TypoUUID;
import typo.dsl.Bijection;
import typo.dsl.PGType;
import zio.jdbc.JdbcDecoder;
import zio.jdbc.JdbcEncoder;
import zio.jdbc.SqlFragment.Setter;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;

/** Type for the primary key of table `public.users` */
case class UsersId(value: TypoUUID) extends scala.AnyVal

object UsersId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[UsersId]] = TypoUUID.arrayJdbcDecoder.map(_.map(UsersId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[UsersId]] = TypoUUID.arrayJdbcEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[UsersId]] = TypoUUID.arraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[UsersId, TypoUUID] = Bijection[UsersId, TypoUUID](_.value)(UsersId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[UsersId] = TypoUUID.jdbcDecoder.map(UsersId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[UsersId] = TypoUUID.jdbcEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[UsersId] = TypoUUID.jsonDecoder.map(UsersId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[UsersId] = TypoUUID.jsonEncoder.contramap(_.value)
  implicit lazy val pgType: PGType[UsersId] = TypoUUID.pgType.as
  implicit lazy val setter: Setter[UsersId] = TypoUUID.setter.contramap(_.value)
  implicit lazy val text: Text[UsersId] = {
    new Text[UsersId] {
      override def unsafeEncode(v: UsersId, sb: StringBuilder) = TypoUUID.text.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: UsersId, sb: StringBuilder) = TypoUUID.text.unsafeArrayEncode(v.value, sb)
    }
  }
}