/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productcategory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.productcategory` which has not been persisted yet */
case class ProductcategoryRowUnsaved(
  /** Category description. */
  name: Name,
  /** Default: nextval('production.productcategory_productcategoryid_seq'::regclass)
      Primary key for ProductCategory records. */
  productcategoryid: Defaulted[ProductcategoryId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productcategoryidDefault: => ProductcategoryId, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): ProductcategoryRow =
    ProductcategoryRow(
      productcategoryid = productcategoryid match {
                            case Defaulted.UseDefault => productcategoryidDefault
                            case Defaulted.Provided(value) => value
                          },
      name = name,
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
object ProductcategoryRowUnsaved {
  implicit lazy val decoder: Decoder[ProductcategoryRowUnsaved] = Decoder.forProduct4[ProductcategoryRowUnsaved, Name, Defaulted[ProductcategoryId], Defaulted[TypoUUID], Defaulted[TypoLocalDateTime]]("name", "productcategoryid", "rowguid", "modifieddate")(ProductcategoryRowUnsaved.apply)(Name.decoder, Defaulted.decoder(ProductcategoryId.decoder), Defaulted.decoder(TypoUUID.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ProductcategoryRowUnsaved] = Encoder.forProduct4[ProductcategoryRowUnsaved, Name, Defaulted[ProductcategoryId], Defaulted[TypoUUID], Defaulted[TypoLocalDateTime]]("name", "productcategoryid", "rowguid", "modifieddate")(x => (x.name, x.productcategoryid, x.rowguid, x.modifieddate))(Name.encoder, Defaulted.encoder(ProductcategoryId.encoder), Defaulted.encoder(TypoUUID.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[ProductcategoryRowUnsaved] = Text.instance[ProductcategoryRowUnsaved]{ (row, sb) =>
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(ProductcategoryId.text).unsafeEncode(row.productcategoryid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
