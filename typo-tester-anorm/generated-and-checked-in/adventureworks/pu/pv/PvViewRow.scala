/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pu.pv

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** View: pu.pv */
case class PvViewRow(
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.productid]] */
  id: ProductId,
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.productid]] */
  productid: ProductId,
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.averageleadtime]] */
  averageleadtime: Int,
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.standardprice]] */
  standardprice: BigDecimal,
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.lastreceiptcost]] */
  lastreceiptcost: Option[BigDecimal],
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.lastreceiptdate]] */
  lastreceiptdate: Option[TypoLocalDateTime],
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.minorderqty]] */
  minorderqty: Int,
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.maxorderqty]] */
  maxorderqty: Int,
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.onorderqty]] */
  onorderqty: Option[Int],
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Points to [[adventureworks.purchasing.productvendor.ProductvendorRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PvViewRow {
  implicit lazy val reads: Reads[PvViewRow] = Reads[PvViewRow](json => JsResult.fromTry(
      Try(
        PvViewRow(
          id = json.\("id").as(ProductId.reads),
          productid = json.\("productid").as(ProductId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          averageleadtime = json.\("averageleadtime").as(Reads.IntReads),
          standardprice = json.\("standardprice").as(Reads.bigDecReads),
          lastreceiptcost = json.\("lastreceiptcost").toOption.map(_.as(Reads.bigDecReads)),
          lastreceiptdate = json.\("lastreceiptdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          minorderqty = json.\("minorderqty").as(Reads.IntReads),
          maxorderqty = json.\("maxorderqty").as(Reads.IntReads),
          onorderqty = json.\("onorderqty").toOption.map(_.as(Reads.IntReads)),
          unitmeasurecode = json.\("unitmeasurecode").as(UnitmeasureId.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PvViewRow] = RowParser[PvViewRow] { row =>
    Success(
      PvViewRow(
        id = row(idx + 0)(ProductId.column),
        productid = row(idx + 1)(ProductId.column),
        businessentityid = row(idx + 2)(BusinessentityId.column),
        averageleadtime = row(idx + 3)(Column.columnToInt),
        standardprice = row(idx + 4)(Column.columnToScalaBigDecimal),
        lastreceiptcost = row(idx + 5)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        lastreceiptdate = row(idx + 6)(Column.columnToOption(TypoLocalDateTime.column)),
        minorderqty = row(idx + 7)(Column.columnToInt),
        maxorderqty = row(idx + 8)(Column.columnToInt),
        onorderqty = row(idx + 9)(Column.columnToOption(Column.columnToInt)),
        unitmeasurecode = row(idx + 10)(UnitmeasureId.column),
        modifieddate = row(idx + 11)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PvViewRow] = OWrites[PvViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> ProductId.writes.writes(o.id),
      "productid" -> ProductId.writes.writes(o.productid),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "averageleadtime" -> Writes.IntWrites.writes(o.averageleadtime),
      "standardprice" -> Writes.BigDecimalWrites.writes(o.standardprice),
      "lastreceiptcost" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.lastreceiptcost),
      "lastreceiptdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.lastreceiptdate),
      "minorderqty" -> Writes.IntWrites.writes(o.minorderqty),
      "maxorderqty" -> Writes.IntWrites.writes(o.maxorderqty),
      "onorderqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.onorderqty),
      "unitmeasurecode" -> UnitmeasureId.writes.writes(o.unitmeasurecode),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
