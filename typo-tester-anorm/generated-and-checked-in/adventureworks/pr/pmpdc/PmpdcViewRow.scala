/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pmpdc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** View: pr.pmpdc */
case class PmpdcViewRow(
  /** Points to [[adventureworks.production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Points to [[adventureworks.production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.productdescriptionid]] */
  productdescriptionid: ProductdescriptionId,
  /** Points to [[adventureworks.production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.cultureid]] */
  cultureid: CultureId,
  /** Points to [[adventureworks.production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PmpdcViewRow {
  implicit lazy val reads: Reads[PmpdcViewRow] = Reads[PmpdcViewRow](json => JsResult.fromTry(
      Try(
        PmpdcViewRow(
          productmodelid = json.\("productmodelid").as(ProductmodelId.reads),
          productdescriptionid = json.\("productdescriptionid").as(ProductdescriptionId.reads),
          cultureid = json.\("cultureid").as(CultureId.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PmpdcViewRow] = RowParser[PmpdcViewRow] { row =>
    Success(
      PmpdcViewRow(
        productmodelid = row(idx + 0)(ProductmodelId.column),
        productdescriptionid = row(idx + 1)(ProductdescriptionId.column),
        cultureid = row(idx + 2)(CultureId.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PmpdcViewRow] = OWrites[PmpdcViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productmodelid" -> ProductmodelId.writes.writes(o.productmodelid),
      "productdescriptionid" -> ProductdescriptionId.writes.writes(o.productdescriptionid),
      "cultureid" -> CultureId.writes.writes(o.cultureid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
