/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.e

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: pe.e */
case class EViewRow(
  /** Points to [[adventureworks.person.emailaddress.EmailaddressRow.emailaddressid]] */
  id: Int,
  /** Points to [[adventureworks.person.emailaddress.EmailaddressRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.person.emailaddress.EmailaddressRow.emailaddressid]] */
  emailaddressid: Int,
  /** Points to [[adventureworks.person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[adventureworks.person.emailaddress.EmailaddressRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.person.emailaddress.EmailaddressRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object EViewRow {
  implicit lazy val decoder: Decoder[EViewRow] = Decoder.forProduct6[EViewRow, Int, BusinessentityId, Int, Option[/* max 50 chars */ String], TypoUUID, TypoLocalDateTime]("id", "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")(EViewRow.apply)(Decoder.decodeInt, BusinessentityId.decoder, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeString), TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[EViewRow] = Encoder.forProduct6[EViewRow, Int, BusinessentityId, Int, Option[/* max 50 chars */ String], TypoUUID, TypoLocalDateTime]("id", "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")(x => (x.id, x.businessentityid, x.emailaddressid, x.emailaddress, x.rowguid, x.modifieddate))(Encoder.encodeInt, BusinessentityId.encoder, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeString), TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[EViewRow] = new Read[EViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => EViewRow(
      id = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 1),
      emailaddressid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      emailaddress = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
}
