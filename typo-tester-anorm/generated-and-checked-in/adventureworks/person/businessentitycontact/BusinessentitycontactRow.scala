/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentitycontact

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Table: person.businessentitycontact
    Cross-reference table mapping stores, vendors, and employees to people
    Composite primary key: businessentityid, personid, contacttypeid */
case class BusinessentitycontactRow(
  /** Primary key. Foreign key to BusinessEntity.BusinessEntityID.
      Points to [[adventureworks.person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. Foreign key to Person.BusinessEntityID.
      Points to [[adventureworks.person.person.PersonRow.businessentityid]] */
  personid: BusinessentityId,
  /** Primary key.  Foreign key to ContactType.ContactTypeID.
      Points to [[adventureworks.person.contacttype.ContacttypeRow.contacttypeid]] */
  contacttypeid: ContacttypeId,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: BusinessentitycontactId = BusinessentitycontactId(businessentityid, personid, contacttypeid)
   val id = compositeId
   def toUnsavedRow(rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): BusinessentitycontactRowUnsaved =
     BusinessentitycontactRowUnsaved(businessentityid, personid, contacttypeid, rowguid, modifieddate)
 }

object BusinessentitycontactRow {
  def apply(compositeId: BusinessentitycontactId, rowguid: TypoUUID, modifieddate: TypoLocalDateTime) =
    new BusinessentitycontactRow(compositeId.businessentityid, compositeId.personid, compositeId.contacttypeid, rowguid, modifieddate)
  implicit lazy val reads: Reads[BusinessentitycontactRow] = Reads[BusinessentitycontactRow](json => JsResult.fromTry(
      Try(
        BusinessentitycontactRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          personid = json.\("personid").as(BusinessentityId.reads),
          contacttypeid = json.\("contacttypeid").as(ContacttypeId.reads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[BusinessentitycontactRow] = RowParser[BusinessentitycontactRow] { row =>
    Success(
      BusinessentitycontactRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        personid = row(idx + 1)(BusinessentityId.column),
        contacttypeid = row(idx + 2)(ContacttypeId.column),
        rowguid = row(idx + 3)(TypoUUID.column),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[BusinessentitycontactRow] = Text.instance[BusinessentitycontactRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    BusinessentityId.text.unsafeEncode(row.personid, sb)
    sb.append(Text.DELIMETER)
    ContacttypeId.text.unsafeEncode(row.contacttypeid, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[BusinessentitycontactRow] = OWrites[BusinessentitycontactRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "personid" -> BusinessentityId.writes.writes(o.personid),
      "contacttypeid" -> ContacttypeId.writes.writes(o.contacttypeid),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
