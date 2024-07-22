/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentitycontact;

import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.person.contacttype.ContacttypeId;
import io.circe.Decoder;
import io.circe.Encoder;

/** Type for the composite primary key of table `person.businessentitycontact` */
case class BusinessentitycontactId(businessentityid: BusinessentityId, personid: BusinessentityId, contacttypeid: ContacttypeId)

object BusinessentitycontactId {
  implicit lazy val decoder: Decoder[BusinessentitycontactId] = Decoder.forProduct3[BusinessentitycontactId, BusinessentityId, BusinessentityId, ContacttypeId]("businessentityid", "personid", "contacttypeid")(BusinessentitycontactId.apply)(BusinessentityId.decoder, BusinessentityId.decoder, ContacttypeId.decoder)
  implicit lazy val encoder: Encoder[BusinessentitycontactId] = Encoder.forProduct3[BusinessentitycontactId, BusinessentityId, BusinessentityId, ContacttypeId]("businessentityid", "personid", "contacttypeid")(x => (x.businessentityid, x.personid, x.contacttypeid))(BusinessentityId.encoder, BusinessentityId.encoder, ContacttypeId.encoder)
}