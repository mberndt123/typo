/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.userdefined.CustomCreditcardId
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class PersoncreditcardRow(
  /** Business entity identification number. Foreign key to Person.BusinessEntityID.
      Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Credit card identification number. Foreign key to CreditCard.CreditCardID.
      Points to [[creditcard.CreditcardRow.creditcardid]] */
  creditcardid: /* user-picked */ CustomCreditcardId,
  modifieddate: TypoLocalDateTime
){
   val compositeId: PersoncreditcardId = PersoncreditcardId(businessentityid, creditcardid)
 }

object PersoncreditcardRow {
  implicit lazy val reads: Reads[PersoncreditcardRow] = Reads[PersoncreditcardRow](json => JsResult.fromTry(
      Try(
        PersoncreditcardRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          creditcardid = json.\("creditcardid").as(CustomCreditcardId.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PersoncreditcardRow] = RowParser[PersoncreditcardRow] { row =>
    Success(
      PersoncreditcardRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        creditcardid = row(idx + 1)(/* user-picked */ CustomCreditcardId.column),
        modifieddate = row(idx + 2)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[PersoncreditcardRow] = Text.instance[PersoncreditcardRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    /* user-picked */ CustomCreditcardId.text.unsafeEncode(row.creditcardid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[PersoncreditcardRow] = OWrites[PersoncreditcardRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "creditcardid" -> CustomCreditcardId.writes.writes(o.creditcardid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
