/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.c

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.culture.CultureId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: pr.c */
case class CViewRow(
  /** Points to [[adventureworks.production.culture.CultureRow.cultureid]] */
  id: CultureId,
  /** Points to [[adventureworks.production.culture.CultureRow.cultureid]] */
  cultureid: CultureId,
  /** Points to [[adventureworks.production.culture.CultureRow.name]] */
  name: Name,
  /** Points to [[adventureworks.production.culture.CultureRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object CViewRow {
  implicit lazy val decoder: Decoder[CViewRow] = Decoder.forProduct4[CViewRow, CultureId, CultureId, Name, TypoLocalDateTime]("id", "cultureid", "name", "modifieddate")(CViewRow.apply)(CultureId.decoder, CultureId.decoder, Name.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[CViewRow] = Encoder.forProduct4[CViewRow, CultureId, CultureId, Name, TypoLocalDateTime]("id", "cultureid", "name", "modifieddate")(x => (x.id, x.cultureid, x.name, x.modifieddate))(CultureId.encoder, CultureId.encoder, Name.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[CViewRow] = new Read[CViewRow](
    gets = List(
      (CultureId.get, Nullability.NoNulls),
      (CultureId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CViewRow(
      id = CultureId.get.unsafeGetNonNullable(rs, i + 0),
      cultureid = CultureId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
