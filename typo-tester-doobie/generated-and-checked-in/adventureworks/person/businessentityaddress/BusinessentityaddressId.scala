/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentityaddress

import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `person.businessentityaddress` */
case class BusinessentityaddressId(
  businessentityid: BusinessentityId,
  addressid: AddressId,
  addresstypeid: AddresstypeId
)
object BusinessentityaddressId {
  implicit lazy val decoder: Decoder[BusinessentityaddressId] = Decoder.forProduct3[BusinessentityaddressId, BusinessentityId, AddressId, AddresstypeId]("businessentityid", "addressid", "addresstypeid")(BusinessentityaddressId.apply)(BusinessentityId.decoder, AddressId.decoder, AddresstypeId.decoder)
  implicit lazy val encoder: Encoder[BusinessentityaddressId] = Encoder.forProduct3[BusinessentityaddressId, BusinessentityId, AddressId, AddresstypeId]("businessentityid", "addressid", "addresstypeid")(x => (x.businessentityid, x.addressid, x.addresstypeid))(BusinessentityId.encoder, AddressId.encoder, AddresstypeId.encoder)
  implicit lazy val ordering: Ordering[BusinessentityaddressId] = Ordering.by(x => (x.businessentityid, x.addressid, x.addresstypeid))
}
