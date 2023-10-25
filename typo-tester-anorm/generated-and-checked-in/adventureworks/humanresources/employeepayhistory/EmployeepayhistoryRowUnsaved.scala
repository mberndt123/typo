/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `humanresources.employeepayhistory` which has not been persisted yet */
case class EmployeepayhistoryRowUnsaved(
  /** Employee identification number. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Date the change in pay is effective */
  ratechangedate: TypoLocalDateTime,
  /** Salary hourly rate.
      Constraint CK_EmployeePayHistory_Rate affecting columns "rate":  (((rate >= 6.50) AND (rate <= 200.00))) */
  rate: BigDecimal,
  /** 1 = Salary received monthly, 2 = Salary received biweekly
      Constraint CK_EmployeePayHistory_PayFrequency affecting columns "payfrequency":  ((payfrequency = ANY (ARRAY[1, 2]))) */
  payfrequency: TypoShort,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): EmployeepayhistoryRow =
    EmployeepayhistoryRow(
      businessentityid = businessentityid,
      ratechangedate = ratechangedate,
      rate = rate,
      payfrequency = payfrequency,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object EmployeepayhistoryRowUnsaved {
  implicit lazy val reads: Reads[EmployeepayhistoryRowUnsaved] = Reads[EmployeepayhistoryRowUnsaved](json => JsResult.fromTry(
      Try(
        EmployeepayhistoryRowUnsaved(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          ratechangedate = json.\("ratechangedate").as(TypoLocalDateTime.reads),
          rate = json.\("rate").as(Reads.bigDecReads),
          payfrequency = json.\("payfrequency").as(TypoShort.reads),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val text: Text[EmployeepayhistoryRowUnsaved] = Text.instance[EmployeepayhistoryRowUnsaved]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.ratechangedate, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.rate, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.payfrequency, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[EmployeepayhistoryRowUnsaved] = OWrites[EmployeepayhistoryRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "ratechangedate" -> TypoLocalDateTime.writes.writes(o.ratechangedate),
      "rate" -> Writes.BigDecimalWrites.writes(o.rate),
      "payfrequency" -> TypoShort.writes.writes(o.payfrequency),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
