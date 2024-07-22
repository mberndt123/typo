/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.at;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.person.addresstype.AddresstypeId;
import adventureworks.public.Name;
import doobie.enumerated.Nullability;
import doobie.util.Read;
import io.circe.Decoder;
import io.circe.Encoder;
import java.sql.ResultSet;

/** View: pe.at */
case class AtViewRow(
  /** Points to [[adventureworks.person.addresstype.AddresstypeRow.addresstypeid]] */
  id: AddresstypeId,
  /** Points to [[adventureworks.person.addresstype.AddresstypeRow.addresstypeid]] */
  addresstypeid: AddresstypeId,
  /** Points to [[adventureworks.person.addresstype.AddresstypeRow.name]] */
  name: Name,
  /** Points to [[adventureworks.person.addresstype.AddresstypeRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.person.addresstype.AddresstypeRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object AtViewRow {
  implicit lazy val decoder: Decoder[AtViewRow] = Decoder.forProduct5[AtViewRow, AddresstypeId, AddresstypeId, Name, TypoUUID, TypoLocalDateTime]("id", "addresstypeid", "name", "rowguid", "modifieddate")(AtViewRow.apply)(AddresstypeId.decoder, AddresstypeId.decoder, Name.decoder, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[AtViewRow] = Encoder.forProduct5[AtViewRow, AddresstypeId, AddresstypeId, Name, TypoUUID, TypoLocalDateTime]("id", "addresstypeid", "name", "rowguid", "modifieddate")(x => (x.id, x.addresstypeid, x.name, x.rowguid, x.modifieddate))(AddresstypeId.encoder, AddresstypeId.encoder, Name.encoder, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[AtViewRow] = {
    new Read[AtViewRow](
      gets = List(
        (AddresstypeId.get, Nullability.NoNulls),
        (AddresstypeId.get, Nullability.NoNulls),
        (Name.get, Nullability.NoNulls),
        (TypoUUID.get, Nullability.NoNulls),
        (TypoLocalDateTime.get, Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => AtViewRow(
        id = AddresstypeId.get.unsafeGetNonNullable(rs, i + 0),
        addresstypeid = AddresstypeId.get.unsafeGetNonNullable(rs, i + 1),
        name = Name.get.unsafeGetNonNullable(rs, i + 2),
        rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 3),
        modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
      )
    )
  
  }
}