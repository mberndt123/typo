/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.pp

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: pe.pp */
case class PpViewRow(
  /** Points to [[adventureworks.person.personphone.PersonphoneRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[adventureworks.person.personphone.PersonphoneRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Phone,
  /** Points to [[adventureworks.person.personphone.PersonphoneRow.phonenumbertypeid]] */
  phonenumbertypeid: PhonenumbertypeId,
  /** Points to [[adventureworks.person.personphone.PersonphoneRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PpViewRow {
  implicit lazy val decoder: Decoder[PpViewRow] = Decoder.forProduct5[PpViewRow, BusinessentityId, BusinessentityId, Phone, PhonenumbertypeId, TypoLocalDateTime]("id", "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")(PpViewRow.apply)(BusinessentityId.decoder, BusinessentityId.decoder, Phone.decoder, PhonenumbertypeId.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PpViewRow] = Encoder.forProduct5[PpViewRow, BusinessentityId, BusinessentityId, Phone, PhonenumbertypeId, TypoLocalDateTime]("id", "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")(x => (x.id, x.businessentityid, x.phonenumber, x.phonenumbertypeid, x.modifieddate))(BusinessentityId.encoder, BusinessentityId.encoder, Phone.encoder, PhonenumbertypeId.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PpViewRow] = new Read[PpViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (Phone.get, Nullability.NoNulls),
      (PhonenumbertypeId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PpViewRow(
      id = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 1),
      phonenumber = Phone.get.unsafeGetNonNullable(rs, i + 2),
      phonenumbertypeid = PhonenumbertypeId.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
}
