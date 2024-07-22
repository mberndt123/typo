/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.personphone

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `person.personphone` */
case class PersonphoneId(
  businessentityid: BusinessentityId,
  phonenumber: Phone,
  phonenumbertypeid: PhonenumbertypeId
)
object PersonphoneId {
  implicit lazy val decoder: Decoder[PersonphoneId] = Decoder.forProduct3[PersonphoneId, BusinessentityId, Phone, PhonenumbertypeId]("businessentityid", "phonenumber", "phonenumbertypeid")(PersonphoneId.apply)(BusinessentityId.decoder, Phone.decoder, PhonenumbertypeId.decoder)
  implicit lazy val encoder: Encoder[PersonphoneId] = Encoder.forProduct3[PersonphoneId, BusinessentityId, Phone, PhonenumbertypeId]("businessentityid", "phonenumber", "phonenumbertypeid")(x => (x.businessentityid, x.phonenumber, x.phonenumbertypeid))(BusinessentityId.encoder, Phone.encoder, PhonenumbertypeId.encoder)
}
