/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodelillustration

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.productmodelillustration` which has not been persisted yet */
case class ProductmodelillustrationRowUnsaved(
  /** Primary key. Foreign key to ProductModel.ProductModelID.
      Points to [[adventureworks.production.productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Primary key. Foreign key to Illustration.IllustrationID.
      Points to [[adventureworks.production.illustration.IllustrationRow.illustrationid]] */
  illustrationid: IllustrationId,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): ProductmodelillustrationRow =
    ProductmodelillustrationRow(
      productmodelid = productmodelid,
      illustrationid = illustrationid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductmodelillustrationRowUnsaved {
  implicit lazy val decoder: Decoder[ProductmodelillustrationRowUnsaved] = Decoder.forProduct3[ProductmodelillustrationRowUnsaved, ProductmodelId, IllustrationId, Defaulted[TypoLocalDateTime]]("productmodelid", "illustrationid", "modifieddate")(ProductmodelillustrationRowUnsaved.apply)(ProductmodelId.decoder, IllustrationId.decoder, Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ProductmodelillustrationRowUnsaved] = Encoder.forProduct3[ProductmodelillustrationRowUnsaved, ProductmodelId, IllustrationId, Defaulted[TypoLocalDateTime]]("productmodelid", "illustrationid", "modifieddate")(x => (x.productmodelid, x.illustrationid, x.modifieddate))(ProductmodelId.encoder, IllustrationId.encoder, Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[ProductmodelillustrationRowUnsaved] = Text.instance[ProductmodelillustrationRowUnsaved]{ (row, sb) =>
    ProductmodelId.text.unsafeEncode(row.productmodelid, sb)
    sb.append(Text.DELIMETER)
    IllustrationId.text.unsafeEncode(row.illustrationid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
