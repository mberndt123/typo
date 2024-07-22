/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.illustration

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `production.illustration` */
case class IllustrationId(value: Int) extends AnyVal
object IllustrationId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[IllustrationId]] = adventureworks.IntArrayDecoder.map(_.map(IllustrationId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[IllustrationId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[IllustrationId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[IllustrationId, Int] = Bijection[IllustrationId, Int](_.value)(IllustrationId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[IllustrationId] = JdbcDecoder.intDecoder.map(IllustrationId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[IllustrationId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[IllustrationId] = JsonDecoder.int.map(IllustrationId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[IllustrationId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val pgType: PGType[IllustrationId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[IllustrationId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[IllustrationId] = new Text[IllustrationId] {
    override def unsafeEncode(v: IllustrationId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: IllustrationId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
