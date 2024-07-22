/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodel;

import adventureworks.Text;
import typo.dsl.Bijection;
import typo.dsl.PGType;
import zio.jdbc.JdbcDecoder;
import zio.jdbc.JdbcEncoder;
import zio.jdbc.SqlFragment.Setter;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;

/** Type for the primary key of table `production.productmodel` */
case class ProductmodelId(value: Int) extends scala.AnyVal

object ProductmodelId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[ProductmodelId]] = adventureworks.IntArrayDecoder.map(_.map(ProductmodelId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[ProductmodelId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[ProductmodelId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductmodelId, Int] = Bijection[ProductmodelId, Int](_.value)(ProductmodelId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductmodelId] = JdbcDecoder.intDecoder.map(ProductmodelId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ProductmodelId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ProductmodelId] = JsonDecoder.int.map(ProductmodelId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ProductmodelId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val pgType: PGType[ProductmodelId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[ProductmodelId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[ProductmodelId] = {
    new Text[ProductmodelId] {
      override def unsafeEncode(v: ProductmodelId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: ProductmodelId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
    }
  }
}