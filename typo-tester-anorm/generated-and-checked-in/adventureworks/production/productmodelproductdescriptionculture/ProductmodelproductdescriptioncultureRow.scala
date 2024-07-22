/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodelproductdescriptionculture

import adventureworks.Text
import adventureworks.customtypes.Defaulted
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

/** Table: production.productmodelproductdescriptionculture
    Cross-reference table mapping product descriptions and the language the description is written in.
    Composite primary key: productmodelid, productdescriptionid, cultureid */
case class ProductmodelproductdescriptioncultureRow(
  /** Primary key. Foreign key to ProductModel.ProductModelID.
      Points to [[adventureworks.production.productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Primary key. Foreign key to ProductDescription.ProductDescriptionID.
      Points to [[adventureworks.production.productdescription.ProductdescriptionRow.productdescriptionid]] */
  productdescriptionid: ProductdescriptionId,
  /** Culture identification number. Foreign key to Culture.CultureID.
      Points to [[adventureworks.production.culture.CultureRow.cultureid]] */
  cultureid: CultureId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductmodelproductdescriptioncultureId = ProductmodelproductdescriptioncultureId(productmodelid, productdescriptionid, cultureid)
   val id = compositeId
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductmodelproductdescriptioncultureRowUnsaved =
     ProductmodelproductdescriptioncultureRowUnsaved(productmodelid, productdescriptionid, cultureid, modifieddate)
 }

object ProductmodelproductdescriptioncultureRow {
  def apply(compositeId: ProductmodelproductdescriptioncultureId, modifieddate: TypoLocalDateTime) =
    new ProductmodelproductdescriptioncultureRow(compositeId.productmodelid, compositeId.productdescriptionid, compositeId.cultureid, modifieddate)
  implicit lazy val reads: Reads[ProductmodelproductdescriptioncultureRow] = Reads[ProductmodelproductdescriptioncultureRow](json => JsResult.fromTry(
      Try(
        ProductmodelproductdescriptioncultureRow(
          productmodelid = json.\("productmodelid").as(ProductmodelId.reads),
          productdescriptionid = json.\("productdescriptionid").as(ProductdescriptionId.reads),
          cultureid = json.\("cultureid").as(CultureId.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductmodelproductdescriptioncultureRow] = RowParser[ProductmodelproductdescriptioncultureRow] { row =>
    Success(
      ProductmodelproductdescriptioncultureRow(
        productmodelid = row(idx + 0)(ProductmodelId.column),
        productdescriptionid = row(idx + 1)(ProductdescriptionId.column),
        cultureid = row(idx + 2)(CultureId.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[ProductmodelproductdescriptioncultureRow] = Text.instance[ProductmodelproductdescriptioncultureRow]{ (row, sb) =>
    ProductmodelId.text.unsafeEncode(row.productmodelid, sb)
    sb.append(Text.DELIMETER)
    ProductdescriptionId.text.unsafeEncode(row.productdescriptionid, sb)
    sb.append(Text.DELIMETER)
    CultureId.text.unsafeEncode(row.cultureid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ProductmodelproductdescriptioncultureRow] = OWrites[ProductmodelproductdescriptioncultureRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productmodelid" -> ProductmodelId.writes.writes(o.productmodelid),
      "productdescriptionid" -> ProductdescriptionId.writes.writes(o.productdescriptionid),
      "cultureid" -> CultureId.writes.writes(o.cultureid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
