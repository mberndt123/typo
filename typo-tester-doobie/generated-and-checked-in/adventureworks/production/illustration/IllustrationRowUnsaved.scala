/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.illustration

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.illustration` which has not been persisted yet */
case class IllustrationRowUnsaved(
  /** Illustrations used in manufacturing instructions. Stored as XML. */
  diagram: Option[TypoXml],
  /** Default: nextval('production.illustration_illustrationid_seq'::regclass)
      Primary key for Illustration records. */
  illustrationid: Defaulted[IllustrationId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(illustrationidDefault: => IllustrationId, modifieddateDefault: => TypoLocalDateTime): IllustrationRow =
    IllustrationRow(
      illustrationid = illustrationid match {
                         case Defaulted.UseDefault => illustrationidDefault
                         case Defaulted.Provided(value) => value
                       },
      diagram = diagram,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object IllustrationRowUnsaved {
  implicit lazy val decoder: Decoder[IllustrationRowUnsaved] = Decoder.forProduct3[IllustrationRowUnsaved, Option[TypoXml], Defaulted[IllustrationId], Defaulted[TypoLocalDateTime]]("diagram", "illustrationid", "modifieddate")(IllustrationRowUnsaved.apply)(Decoder.decodeOption(TypoXml.decoder), Defaulted.decoder(IllustrationId.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[IllustrationRowUnsaved] = Encoder.forProduct3[IllustrationRowUnsaved, Option[TypoXml], Defaulted[IllustrationId], Defaulted[TypoLocalDateTime]]("diagram", "illustrationid", "modifieddate")(x => (x.diagram, x.illustrationid, x.modifieddate))(Encoder.encodeOption(TypoXml.encoder), Defaulted.encoder(IllustrationId.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[IllustrationRowUnsaved] = Text.instance[IllustrationRowUnsaved]{ (row, sb) =>
    Text.option(TypoXml.text).unsafeEncode(row.diagram, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(IllustrationId.text).unsafeEncode(row.illustrationid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
