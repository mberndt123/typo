/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class CultureRow(
  /** Primary key for Culture records. */
  cultureid: CultureId,
  /** Culture description. */
  name: Name,
  modifieddate: TypoLocalDateTime
)

object CultureRow {
  implicit lazy val decoder: Decoder[CultureRow] = Decoder.forProduct3[CultureRow, CultureId, Name, TypoLocalDateTime]("cultureid", "name", "modifieddate")(CultureRow.apply)(CultureId.decoder, Name.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[CultureRow] = Encoder.forProduct3[CultureRow, CultureId, Name, TypoLocalDateTime]("cultureid", "name", "modifieddate")(x => (x.cultureid, x.name, x.modifieddate))(CultureId.encoder, Name.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[CultureRow] = new Read[CultureRow](
    gets = List(
      (CultureId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CultureRow(
      cultureid = CultureId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
  implicit lazy val text: Text[CultureRow] = Text.instance[CultureRow]{ (row, sb) =>
    CultureId.text.unsafeEncode(row.cultureid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
