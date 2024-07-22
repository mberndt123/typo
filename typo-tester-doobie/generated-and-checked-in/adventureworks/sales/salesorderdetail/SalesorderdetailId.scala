/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesorderdetail;

import adventureworks.sales.salesorderheader.SalesorderheaderId;
import io.circe.Decoder;
import io.circe.Encoder;

/** Type for the composite primary key of table `sales.salesorderdetail` */
case class SalesorderdetailId(salesorderid: SalesorderheaderId, salesorderdetailid: Int)

object SalesorderdetailId {
  implicit lazy val decoder: Decoder[SalesorderdetailId] = Decoder.forProduct2[SalesorderdetailId, SalesorderheaderId, Int]("salesorderid", "salesorderdetailid")(SalesorderdetailId.apply)(SalesorderheaderId.decoder, Decoder.decodeInt)
  implicit lazy val encoder: Encoder[SalesorderdetailId] = Encoder.forProduct2[SalesorderdetailId, SalesorderheaderId, Int]("salesorderid", "salesorderdetailid")(x => (x.salesorderid, x.salesorderdetailid))(SalesorderheaderId.encoder, Encoder.encodeInt)
}