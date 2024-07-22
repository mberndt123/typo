/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pu.sm

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import adventureworks.purchasing.shipmethod.ShipmethodId
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

/** View: pu.sm */
case class SmViewRow(
  /** Points to [[adventureworks.purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  id: ShipmethodId,
  /** Points to [[adventureworks.purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Points to [[adventureworks.purchasing.shipmethod.ShipmethodRow.name]] */
  name: Name,
  /** Points to [[adventureworks.purchasing.shipmethod.ShipmethodRow.shipbase]] */
  shipbase: BigDecimal,
  /** Points to [[adventureworks.purchasing.shipmethod.ShipmethodRow.shiprate]] */
  shiprate: BigDecimal,
  /** Points to [[adventureworks.purchasing.shipmethod.ShipmethodRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.purchasing.shipmethod.ShipmethodRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SmViewRow {
  implicit lazy val reads: Reads[SmViewRow] = Reads[SmViewRow](json => JsResult.fromTry(
      Try(
        SmViewRow(
          id = json.\("id").as(ShipmethodId.reads),
          shipmethodid = json.\("shipmethodid").as(ShipmethodId.reads),
          name = json.\("name").as(Name.reads),
          shipbase = json.\("shipbase").as(Reads.bigDecReads),
          shiprate = json.\("shiprate").as(Reads.bigDecReads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SmViewRow] = RowParser[SmViewRow] { row =>
    Success(
      SmViewRow(
        id = row(idx + 0)(ShipmethodId.column),
        shipmethodid = row(idx + 1)(ShipmethodId.column),
        name = row(idx + 2)(Name.column),
        shipbase = row(idx + 3)(Column.columnToScalaBigDecimal),
        shiprate = row(idx + 4)(Column.columnToScalaBigDecimal),
        rowguid = row(idx + 5)(TypoUUID.column),
        modifieddate = row(idx + 6)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[SmViewRow] = OWrites[SmViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> ShipmethodId.writes.writes(o.id),
      "shipmethodid" -> ShipmethodId.writes.writes(o.shipmethodid),
      "name" -> Name.writes.writes(o.name),
      "shipbase" -> Writes.BigDecimalWrites.writes(o.shipbase),
      "shiprate" -> Writes.BigDecimalWrites.writes(o.shiprate),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
