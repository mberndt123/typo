/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.pnt

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: pe.pnt */
case class PntViewRow(
  /** Points to [[adventureworks.person.phonenumbertype.PhonenumbertypeRow.phonenumbertypeid]] */
  id: PhonenumbertypeId,
  /** Points to [[adventureworks.person.phonenumbertype.PhonenumbertypeRow.phonenumbertypeid]] */
  phonenumbertypeid: PhonenumbertypeId,
  /** Points to [[adventureworks.person.phonenumbertype.PhonenumbertypeRow.name]] */
  name: Name,
  /** Points to [[adventureworks.person.phonenumbertype.PhonenumbertypeRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PntViewRow {
  implicit lazy val decoder: Decoder[PntViewRow] = Decoder.forProduct4[PntViewRow, PhonenumbertypeId, PhonenumbertypeId, Name, TypoLocalDateTime]("id", "phonenumbertypeid", "name", "modifieddate")(PntViewRow.apply)(PhonenumbertypeId.decoder, PhonenumbertypeId.decoder, Name.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PntViewRow] = Encoder.forProduct4[PntViewRow, PhonenumbertypeId, PhonenumbertypeId, Name, TypoLocalDateTime]("id", "phonenumbertypeid", "name", "modifieddate")(x => (x.id, x.phonenumbertypeid, x.name, x.modifieddate))(PhonenumbertypeId.encoder, PhonenumbertypeId.encoder, Name.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PntViewRow] = new Read[PntViewRow](
    gets = List(
      (PhonenumbertypeId.get, Nullability.NoNulls),
      (PhonenumbertypeId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PntViewRow(
      id = PhonenumbertypeId.get.unsafeGetNonNullable(rs, i + 0),
      phonenumbertypeid = PhonenumbertypeId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
