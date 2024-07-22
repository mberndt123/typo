/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productreview

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.public.Name
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

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
  implicit lazy val reads: Reads[ProductreviewRowUnsaved] = Reads[ProductreviewRowUnsaved](json => JsResult.fromTry(
      Try(
        ProductreviewRowUnsaved(
          productid = json.\("productid").as(ProductId.reads),
          reviewername = json.\("reviewername").as(Name.reads),
          emailaddress = json.\("emailaddress").as(Reads.StringReads),
          rating = json.\("rating").as(Reads.IntReads),
          comments = json.\("comments").toOption.map(_.as(Reads.StringReads)),
          productreviewid = json.\("productreviewid").as(Defaulted.reads(ProductreviewId.reads)),
          reviewdate = json.\("reviewdate").as(Defaulted.reads(TypoLocalDateTime.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
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
  implicit lazy val writes: OWrites[ProductreviewRowUnsaved] = OWrites[ProductreviewRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "reviewername" -> Name.writes.writes(o.reviewername),
      "emailaddress" -> Writes.StringWrites.writes(o.emailaddress),
      "rating" -> Writes.IntWrites.writes(o.rating),
      "comments" -> Writes.OptionWrites(Writes.StringWrites).writes(o.comments),
      "productreviewid" -> Defaulted.writes(ProductreviewId.writes).writes(o.productreviewid),
      "reviewdate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.reviewdate),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
