/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class BusinessentityaddressRow(
  /** Primary key. Foreign key to BusinessEntity.BusinessEntityID.
      Points to [[businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. Foreign key to Address.AddressID.
      Points to [[address.AddressRow.addressid]] */
  addressid: AddressId,
  /** Primary key. Foreign key to AddressType.AddressTypeID.
      Points to [[addresstype.AddresstypeRow.addresstypeid]] */
  addresstypeid: AddresstypeId,
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
){
   val compositeId: BusinessentityaddressId = BusinessentityaddressId(businessentityid, addressid, addresstypeid)
 }

object BusinessentityaddressRow {
  implicit lazy val reads: Reads[BusinessentityaddressRow] = Reads[BusinessentityaddressRow](json => JsResult.fromTry(
      Try(
        BusinessentityaddressRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          addressid = json.\("addressid").as(AddressId.reads),
          addresstypeid = json.\("addresstypeid").as(AddresstypeId.reads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[BusinessentityaddressRow] = RowParser[BusinessentityaddressRow] { row =>
    Success(
      BusinessentityaddressRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        addressid = row(idx + 1)(AddressId.column),
        addresstypeid = row(idx + 2)(AddresstypeId.column),
        rowguid = row(idx + 3)(TypoUUID.column),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[BusinessentityaddressRow] = Text.instance[BusinessentityaddressRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    AddressId.text.unsafeEncode(row.addressid, sb)
    sb.append(Text.DELIMETER)
    AddresstypeId.text.unsafeEncode(row.addresstypeid, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[BusinessentityaddressRow] = OWrites[BusinessentityaddressRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "addressid" -> AddressId.writes.writes(o.addressid),
      "addresstypeid" -> AddresstypeId.writes.writes(o.addresstypeid),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
