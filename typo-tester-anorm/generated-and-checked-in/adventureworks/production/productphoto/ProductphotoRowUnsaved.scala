/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.productphoto` which has not been persisted yet */
case class ProductphotoRowUnsaved(
  /** Small image of the product. */
  thumbnailphoto: Option[TypoBytea],
  /** Small image file name. */
  thumbnailphotofilename: Option[/* max 50 chars */ String],
  /** Large image of the product. */
  largephoto: Option[TypoBytea],
  /** Large image file name. */
  largephotofilename: Option[/* max 50 chars */ String],
  /** Default: nextval('production.productphoto_productphotoid_seq'::regclass)
      Primary key for ProductPhoto records. */
  productphotoid: Defaulted[ProductphotoId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productphotoidDefault: => ProductphotoId, modifieddateDefault: => TypoLocalDateTime): ProductphotoRow =
    ProductphotoRow(
      thumbnailphoto = thumbnailphoto,
      thumbnailphotofilename = thumbnailphotofilename,
      largephoto = largephoto,
      largephotofilename = largephotofilename,
      productphotoid = productphotoid match {
                         case Defaulted.UseDefault => productphotoidDefault
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductphotoRowUnsaved {
  implicit lazy val reads: Reads[ProductphotoRowUnsaved] = Reads[ProductphotoRowUnsaved](json => JsResult.fromTry(
      Try(
        ProductphotoRowUnsaved(
          thumbnailphoto = json.\("thumbnailphoto").toOption.map(_.as(TypoBytea.reads)),
          thumbnailphotofilename = json.\("thumbnailphotofilename").toOption.map(_.as(Reads.StringReads)),
          largephoto = json.\("largephoto").toOption.map(_.as(TypoBytea.reads)),
          largephotofilename = json.\("largephotofilename").toOption.map(_.as(Reads.StringReads)),
          productphotoid = json.\("productphotoid").as(Defaulted.reads(ProductphotoId.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val text: Text[ProductphotoRowUnsaved] = Text.instance[ProductphotoRowUnsaved]{ (row, sb) =>
    Text.option(TypoBytea.text).unsafeEncode(row.thumbnailphoto, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.thumbnailphotofilename, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoBytea.text).unsafeEncode(row.largephoto, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.largephotofilename, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(ProductphotoId.text).unsafeEncode(row.productphotoid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ProductphotoRowUnsaved] = OWrites[ProductphotoRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "thumbnailphoto" -> Writes.OptionWrites(TypoBytea.writes).writes(o.thumbnailphoto),
      "thumbnailphotofilename" -> Writes.OptionWrites(Writes.StringWrites).writes(o.thumbnailphotofilename),
      "largephoto" -> Writes.OptionWrites(TypoBytea.writes).writes(o.largephoto),
      "largephotofilename" -> Writes.OptionWrites(Writes.StringWrites).writes(o.largephotofilename),
      "productphotoid" -> Defaulted.writes(ProductphotoId.writes).writes(o.productphotoid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
