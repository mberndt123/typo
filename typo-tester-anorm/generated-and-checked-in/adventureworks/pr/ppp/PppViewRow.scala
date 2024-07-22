/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.ppp

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** View: pr.ppp */
case class PppViewRow(
  /** Points to [[adventureworks.production.productproductphoto.ProductproductphotoRow.productid]] */
  productid: ProductId,
  /** Points to [[adventureworks.production.productproductphoto.ProductproductphotoRow.productphotoid]] */
  productphotoid: ProductphotoId,
  /** Points to [[adventureworks.production.productproductphoto.ProductproductphotoRow.primary]] */
  primary: Flag,
  /** Points to [[adventureworks.production.productproductphoto.ProductproductphotoRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PppViewRow {
  implicit lazy val reads: Reads[PppViewRow] = Reads[PppViewRow](json => JsResult.fromTry(
      Try(
        PppViewRow(
          productid = json.\("productid").as(ProductId.reads),
          productphotoid = json.\("productphotoid").as(ProductphotoId.reads),
          primary = json.\("primary").as(Flag.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PppViewRow] = RowParser[PppViewRow] { row =>
    Success(
      PppViewRow(
        productid = row(idx + 0)(ProductId.column),
        productphotoid = row(idx + 1)(ProductphotoId.column),
        primary = row(idx + 2)(Flag.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PppViewRow] = OWrites[PppViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "productphotoid" -> ProductphotoId.writes.writes(o.productphotoid),
      "primary" -> Flag.writes.writes(o.primary),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
