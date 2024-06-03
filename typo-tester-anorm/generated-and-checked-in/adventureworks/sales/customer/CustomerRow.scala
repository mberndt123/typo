/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

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

/** Table: sales.customer
    Current customer information. Also see the Person and Store tables.
    Primary key: customerid */
case class CustomerRow(
  /** Primary key.
      Default: nextval('sales.customer_customerid_seq'::regclass) */
  customerid: CustomerId,
  /** Foreign key to Person.BusinessEntityID
      Points to [[person.person.PersonRow.businessentityid]] */
  personid: Option[BusinessentityId],
  /** Foreign key to Store.BusinessEntityID
      Points to [[store.StoreRow.businessentityid]] */
  storeid: Option[BusinessentityId],
  /** ID of the territory in which the customer is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(customerid: Defaulted[CustomerId], rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): CustomerRowUnsaved =
     CustomerRowUnsaved(personid, storeid, territoryid, customerid, rowguid, modifieddate)
 }

object CustomerRow {
  implicit lazy val reads: Reads[CustomerRow] = Reads[CustomerRow](json => JsResult.fromTry(
      Try(
        CustomerRow(
          customerid = json.\("customerid").as(CustomerId.reads),
          personid = json.\("personid").toOption.map(_.as(BusinessentityId.reads)),
          storeid = json.\("storeid").toOption.map(_.as(BusinessentityId.reads)),
          territoryid = json.\("territoryid").toOption.map(_.as(SalesterritoryId.reads)),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CustomerRow] = RowParser[CustomerRow] { row =>
    Success(
      CustomerRow(
        customerid = row(idx + 0)(CustomerId.column),
        personid = row(idx + 1)(Column.columnToOption(BusinessentityId.column)),
        storeid = row(idx + 2)(Column.columnToOption(BusinessentityId.column)),
        territoryid = row(idx + 3)(Column.columnToOption(SalesterritoryId.column)),
        rowguid = row(idx + 4)(TypoUUID.column),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[CustomerRow] = Text.instance[CustomerRow]{ (row, sb) =>
    CustomerId.text.unsafeEncode(row.customerid, sb)
    sb.append(Text.DELIMETER)
    Text.option(BusinessentityId.text).unsafeEncode(row.personid, sb)
    sb.append(Text.DELIMETER)
    Text.option(BusinessentityId.text).unsafeEncode(row.storeid, sb)
    sb.append(Text.DELIMETER)
    Text.option(SalesterritoryId.text).unsafeEncode(row.territoryid, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[CustomerRow] = OWrites[CustomerRow](o =>
    new JsObject(ListMap[String, JsValue](
      "customerid" -> CustomerId.writes.writes(o.customerid),
      "personid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.personid),
      "storeid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.storeid),
      "territoryid" -> Writes.OptionWrites(SalesterritoryId.writes).writes(o.territoryid),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
