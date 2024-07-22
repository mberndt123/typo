/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.bea

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

/** View: pe.bea */
case class BeaViewRow(
  /** Points to [[adventureworks.person.businessentityaddress.BusinessentityaddressRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[adventureworks.person.businessentityaddress.BusinessentityaddressRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.person.businessentityaddress.BusinessentityaddressRow.addressid]] */
  addressid: AddressId,
  /** Points to [[adventureworks.person.businessentityaddress.BusinessentityaddressRow.addresstypeid]] */
  addresstypeid: AddresstypeId,
  /** Points to [[adventureworks.person.businessentityaddress.BusinessentityaddressRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.person.businessentityaddress.BusinessentityaddressRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object BeaViewRow {
  implicit lazy val reads: Reads[BeaViewRow] = Reads[BeaViewRow](json => JsResult.fromTry(
      Try(
        BeaViewRow(
          id = json.\("id").as(BusinessentityId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          addressid = json.\("addressid").as(AddressId.reads),
          addresstypeid = json.\("addresstypeid").as(AddresstypeId.reads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[BeaViewRow] = RowParser[BeaViewRow] { row =>
    Success(
      BeaViewRow(
        id = row(idx + 0)(BusinessentityId.column),
        businessentityid = row(idx + 1)(BusinessentityId.column),
        addressid = row(idx + 2)(AddressId.column),
        addresstypeid = row(idx + 3)(AddresstypeId.column),
        rowguid = row(idx + 4)(TypoUUID.column),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[BeaViewRow] = OWrites[BeaViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> BusinessentityId.writes.writes(o.id),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "addressid" -> AddressId.writes.writes(o.addressid),
      "addresstypeid" -> AddresstypeId.writes.writes(o.addresstypeid),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
