/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class IllustrationRow(
  /** Primary key for Illustration records. */
  illustrationid: IllustrationId,
  /** Illustrations used in manufacturing instructions. Stored as XML. */
  diagram: Option[TypoXml],
  modifieddate: TypoLocalDateTime
)

object IllustrationRow {
  implicit lazy val decoder: Decoder[IllustrationRow] = Decoder.forProduct3[IllustrationRow, IllustrationId, Option[TypoXml], TypoLocalDateTime]("illustrationid", "diagram", "modifieddate")(IllustrationRow.apply)(IllustrationId.decoder, Decoder.decodeOption(TypoXml.decoder), TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[IllustrationRow] = Encoder.forProduct3[IllustrationRow, IllustrationId, Option[TypoXml], TypoLocalDateTime]("illustrationid", "diagram", "modifieddate")(x => (x.illustrationid, x.diagram, x.modifieddate))(IllustrationId.encoder, Encoder.encodeOption(TypoXml.encoder), TypoLocalDateTime.encoder)
  implicit lazy val read: Read[IllustrationRow] = new Read[IllustrationRow](
    gets = List(
      (IllustrationId.get, Nullability.NoNulls),
      (TypoXml.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => IllustrationRow(
      illustrationid = IllustrationId.get.unsafeGetNonNullable(rs, i + 0),
      diagram = TypoXml.get.unsafeGetNullable(rs, i + 1),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
  implicit lazy val text: Text[IllustrationRow] = Text.instance[IllustrationRow]{ (row, sb) =>
    IllustrationId.text.unsafeEncode(row.illustrationid, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.diagram, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
