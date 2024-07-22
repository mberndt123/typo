/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productreview

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.public.Name
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.productreview` which has not been persisted yet */
case class ProductreviewRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[adventureworks.production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Name of the reviewer. */
  reviewername: Name,
  /** Reviewer's e-mail address. */
  emailaddress: /* max 50 chars */ String,
  /** Product rating given by the reviewer. Scale is 1 to 5 with 5 as the highest rating.
      Constraint CK_ProductReview_Rating affecting columns rating:  (((rating >= 1) AND (rating <= 5))) */
  rating: Int,
  /** Reviewer's comments */
  comments: Option[/* max 3850 chars */ String],
  /** Default: nextval('production.productreview_productreviewid_seq'::regclass)
      Primary key for ProductReview records. */
  productreviewid: Defaulted[ProductreviewId] = Defaulted.UseDefault,
  /** Default: now()
      Date review was submitted. */
  reviewdate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productreviewidDefault: => ProductreviewId, reviewdateDefault: => TypoLocalDateTime, modifieddateDefault: => TypoLocalDateTime): ProductreviewRow =
    ProductreviewRow(
      productreviewid = productreviewid match {
                          case Defaulted.UseDefault => productreviewidDefault
                          case Defaulted.Provided(value) => value
                        },
      productid = productid,
      reviewername = reviewername,
      reviewdate = reviewdate match {
                     case Defaulted.UseDefault => reviewdateDefault
                     case Defaulted.Provided(value) => value
                   },
      emailaddress = emailaddress,
      rating = rating,
      comments = comments,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductreviewRowUnsaved {
  implicit lazy val decoder: Decoder[ProductreviewRowUnsaved] = Decoder.forProduct8[ProductreviewRowUnsaved, ProductId, Name, /* max 50 chars */ String, Int, Option[/* max 3850 chars */ String], Defaulted[ProductreviewId], Defaulted[TypoLocalDateTime], Defaulted[TypoLocalDateTime]]("productid", "reviewername", "emailaddress", "rating", "comments", "productreviewid", "reviewdate", "modifieddate")(ProductreviewRowUnsaved.apply)(ProductId.decoder, Name.decoder, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeString), Defaulted.decoder(ProductreviewId.decoder), Defaulted.decoder(TypoLocalDateTime.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ProductreviewRowUnsaved] = Encoder.forProduct8[ProductreviewRowUnsaved, ProductId, Name, /* max 50 chars */ String, Int, Option[/* max 3850 chars */ String], Defaulted[ProductreviewId], Defaulted[TypoLocalDateTime], Defaulted[TypoLocalDateTime]]("productid", "reviewername", "emailaddress", "rating", "comments", "productreviewid", "reviewdate", "modifieddate")(x => (x.productid, x.reviewername, x.emailaddress, x.rating, x.comments, x.productreviewid, x.reviewdate, x.modifieddate))(ProductId.encoder, Name.encoder, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeString), Defaulted.encoder(ProductreviewId.encoder), Defaulted.encoder(TypoLocalDateTime.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[ProductreviewRowUnsaved] = Text.instance[ProductreviewRowUnsaved]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.reviewername, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.emailaddress, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.rating, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.comments, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(ProductreviewId.text).unsafeEncode(row.productreviewid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.reviewdate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
