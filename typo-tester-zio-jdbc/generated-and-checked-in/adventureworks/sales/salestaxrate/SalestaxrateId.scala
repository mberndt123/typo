/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salestaxrate;

import adventureworks.Text;
import typo.dsl.Bijection;
import typo.dsl.PGType;
import zio.jdbc.JdbcDecoder;
import zio.jdbc.JdbcEncoder;
import zio.jdbc.SqlFragment.Setter;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;

/** Type for the primary key of table `sales.salestaxrate` */
case class SalestaxrateId(value: Int) extends scala.AnyVal

object SalestaxrateId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[SalestaxrateId]] = adventureworks.IntArrayDecoder.map(_.map(SalestaxrateId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[SalestaxrateId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[SalestaxrateId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[SalestaxrateId, Int] = Bijection[SalestaxrateId, Int](_.value)(SalestaxrateId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[SalestaxrateId] = JdbcDecoder.intDecoder.map(SalestaxrateId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[SalestaxrateId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[SalestaxrateId] = JsonDecoder.int.map(SalestaxrateId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[SalestaxrateId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val pgType: PGType[SalestaxrateId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[SalestaxrateId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[SalestaxrateId] = {
    new Text[SalestaxrateId] {
      override def unsafeEncode(v: SalestaxrateId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: SalestaxrateId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
    }
  }
}