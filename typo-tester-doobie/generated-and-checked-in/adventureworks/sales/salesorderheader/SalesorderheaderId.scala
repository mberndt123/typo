/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesorderheader;

import doobie.postgres.Text;
import doobie.util.Get;
import doobie.util.Put;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import typo.dsl.Bijection;

/** Type for the primary key of table `sales.salesorderheader` */
case class SalesorderheaderId(value: Int) extends scala.AnyVal

object SalesorderheaderId {
  implicit lazy val arrayGet: Get[Array[SalesorderheaderId]] = adventureworks.IntegerArrayMeta.get.map(_.map(SalesorderheaderId.apply))
  implicit lazy val arrayPut: Put[Array[SalesorderheaderId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[SalesorderheaderId, Int] = Bijection[SalesorderheaderId, Int](_.value)(SalesorderheaderId.apply)
  implicit lazy val decoder: Decoder[SalesorderheaderId] = Decoder.decodeInt.map(SalesorderheaderId.apply)
  implicit lazy val encoder: Encoder[SalesorderheaderId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[SalesorderheaderId] = Meta.IntMeta.get.map(SalesorderheaderId.apply)
  implicit lazy val put: Put[SalesorderheaderId] = Meta.IntMeta.put.contramap(_.value)
  implicit lazy val text: Text[SalesorderheaderId] = {
    new Text[SalesorderheaderId] {
      override def unsafeEncode(v: SalesorderheaderId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: SalesorderheaderId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
    }
  }
}