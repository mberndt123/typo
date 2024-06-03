/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
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

/** Table: purchasing.shipmethod
    Shipping company lookup table.
    Primary key: shipmethodid */
case class ShipmethodRow(
  /** Primary key for ShipMethod records.
      Default: nextval('purchasing.shipmethod_shipmethodid_seq'::regclass) */
  shipmethodid: ShipmethodId,
  /** Shipping company name. */
  name: Name,
  /** Minimum shipping charge.
      Default: 0.00
      Constraint CK_ShipMethod_ShipBase affecting columns shipbase: ((shipbase > 0.00)) */
  shipbase: BigDecimal,
  /** Shipping charge per pound.
      Default: 0.00
      Constraint CK_ShipMethod_ShipRate affecting columns shiprate: ((shiprate > 0.00)) */
  shiprate: BigDecimal,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(shipmethodid: Defaulted[ShipmethodId], shipbase: Defaulted[BigDecimal] = Defaulted.Provided(this.shipbase), shiprate: Defaulted[BigDecimal] = Defaulted.Provided(this.shiprate), rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ShipmethodRowUnsaved =
     ShipmethodRowUnsaved(name, shipmethodid, shipbase, shiprate, rowguid, modifieddate)
 }

object ShipmethodRow {
  implicit lazy val reads: Reads[ShipmethodRow] = Reads[ShipmethodRow](json => JsResult.fromTry(
      Try(
        ShipmethodRow(
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
  def rowParser(idx: Int): RowParser[ShipmethodRow] = RowParser[ShipmethodRow] { row =>
    Success(
      ShipmethodRow(
        shipmethodid = row(idx + 0)(ShipmethodId.column),
        name = row(idx + 1)(Name.column),
        shipbase = row(idx + 2)(Column.columnToScalaBigDecimal),
        shiprate = row(idx + 3)(Column.columnToScalaBigDecimal),
        rowguid = row(idx + 4)(TypoUUID.column),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[ShipmethodRow] = Text.instance[ShipmethodRow]{ (row, sb) =>
    ShipmethodId.text.unsafeEncode(row.shipmethodid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.shipbase, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.shiprate, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ShipmethodRow] = OWrites[ShipmethodRow](o =>
    new JsObject(ListMap[String, JsValue](
      "shipmethodid" -> ShipmethodId.writes.writes(o.shipmethodid),
      "name" -> Name.writes.writes(o.name),
      "shipbase" -> Writes.BigDecimalWrites.writes(o.shipbase),
      "shiprate" -> Writes.BigDecimalWrites.writes(o.shiprate),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
