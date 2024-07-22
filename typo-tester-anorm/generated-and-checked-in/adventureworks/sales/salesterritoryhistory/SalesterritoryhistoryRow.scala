/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesterritoryhistory

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
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

/** Table: sales.salesterritoryhistory
    Sales representative transfers to other sales territories.
    Composite primary key: businessentityid, startdate, territoryid */
case class SalesterritoryhistoryRow(
  /** Primary key. The sales rep.  Foreign key to SalesPerson.BusinessEntityID.
      Points to [[adventureworks.sales.salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. Territory identification number. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[adventureworks.sales.salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Primary key. Date the sales representive started work in the territory.
      Constraint CK_SalesTerritoryHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Date the sales representative left work in the territory.
      Constraint CK_SalesTerritoryHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesterritoryhistoryId = SalesterritoryhistoryId(businessentityid, startdate, territoryid)
   val id = compositeId
   def toUnsavedRow(rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): SalesterritoryhistoryRowUnsaved =
     SalesterritoryhistoryRowUnsaved(businessentityid, territoryid, startdate, enddate, rowguid, modifieddate)
 }

object SalesterritoryhistoryRow {
  def apply(compositeId: SalesterritoryhistoryId, enddate: Option[TypoLocalDateTime], rowguid: TypoUUID, modifieddate: TypoLocalDateTime) =
    new SalesterritoryhistoryRow(compositeId.businessentityid, compositeId.territoryid, compositeId.startdate, enddate, rowguid, modifieddate)
  implicit lazy val reads: Reads[SalesterritoryhistoryRow] = Reads[SalesterritoryhistoryRow](json => JsResult.fromTry(
      Try(
        SalesterritoryhistoryRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          territoryid = json.\("territoryid").as(SalesterritoryId.reads),
          startdate = json.\("startdate").as(TypoLocalDateTime.reads),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SalesterritoryhistoryRow] = RowParser[SalesterritoryhistoryRow] { row =>
    Success(
      SalesterritoryhistoryRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        territoryid = row(idx + 1)(SalesterritoryId.column),
        startdate = row(idx + 2)(TypoLocalDateTime.column),
        enddate = row(idx + 3)(Column.columnToOption(TypoLocalDateTime.column)),
        rowguid = row(idx + 4)(TypoUUID.column),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[SalesterritoryhistoryRow] = Text.instance[SalesterritoryhistoryRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    SalesterritoryId.text.unsafeEncode(row.territoryid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[SalesterritoryhistoryRow] = OWrites[SalesterritoryhistoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "territoryid" -> SalesterritoryId.writes.writes(o.territoryid),
      "startdate" -> TypoLocalDateTime.writes.writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
