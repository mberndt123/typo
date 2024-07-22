/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodel

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.public.Name
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.productmodel` which has not been persisted yet */
case class ProductmodelRowUnsaved(
  /** Product model description. */
  name: Name,
  /** Detailed product catalog information in xml format. */
  catalogdescription: Option[TypoXml],
  /** Manufacturing instructions in xml format. */
  instructions: Option[TypoXml],
  /** Default: nextval('production.productmodel_productmodelid_seq'::regclass)
      Primary key for ProductModel records. */
  productmodelid: Defaulted[ProductmodelId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productmodelidDefault: => ProductmodelId, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): ProductmodelRow =
    ProductmodelRow(
      name = name,
      catalogdescription = catalogdescription,
      instructions = instructions,
      productmodelid = productmodelid match {
                         case Defaulted.UseDefault => productmodelidDefault
                         case Defaulted.Provided(value) => value
                       },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductmodelRowUnsaved {
  implicit lazy val decoder: Decoder[ProductmodelRowUnsaved] = Decoder.forProduct6[ProductmodelRowUnsaved, Name, Option[TypoXml], Option[TypoXml], Defaulted[ProductmodelId], Defaulted[TypoUUID], Defaulted[TypoLocalDateTime]]("name", "catalogdescription", "instructions", "productmodelid", "rowguid", "modifieddate")(ProductmodelRowUnsaved.apply)(Name.decoder, Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Defaulted.decoder(ProductmodelId.decoder), Defaulted.decoder(TypoUUID.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ProductmodelRowUnsaved] = Encoder.forProduct6[ProductmodelRowUnsaved, Name, Option[TypoXml], Option[TypoXml], Defaulted[ProductmodelId], Defaulted[TypoUUID], Defaulted[TypoLocalDateTime]]("name", "catalogdescription", "instructions", "productmodelid", "rowguid", "modifieddate")(x => (x.name, x.catalogdescription, x.instructions, x.productmodelid, x.rowguid, x.modifieddate))(Name.encoder, Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Defaulted.encoder(ProductmodelId.encoder), Defaulted.encoder(TypoUUID.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[ProductmodelRowUnsaved] = Text.instance[ProductmodelRowUnsaved]{ (row, sb) =>
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.catalogdescription, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.instructions, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(ProductmodelId.text).unsafeEncode(row.productmodelid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
