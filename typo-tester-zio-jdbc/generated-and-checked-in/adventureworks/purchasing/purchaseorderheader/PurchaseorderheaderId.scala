/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `purchasing.purchaseorderheader` */
case class PurchaseorderheaderId(value: Int) extends AnyVal
object PurchaseorderheaderId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[PurchaseorderheaderId]] = adventureworks.IntArrayDecoder.map(_.map(PurchaseorderheaderId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[PurchaseorderheaderId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[PurchaseorderheaderId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PurchaseorderheaderId, Int] = Bijection[PurchaseorderheaderId, Int](_.value)(PurchaseorderheaderId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PurchaseorderheaderId] = JdbcDecoder.intDecoder.map(PurchaseorderheaderId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PurchaseorderheaderId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PurchaseorderheaderId] = JsonDecoder.int.map(PurchaseorderheaderId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PurchaseorderheaderId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[PurchaseorderheaderId] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[PurchaseorderheaderId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[PurchaseorderheaderId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[PurchaseorderheaderId] = new Text[PurchaseorderheaderId] {
    override def unsafeEncode(v: PurchaseorderheaderId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: PurchaseorderheaderId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
