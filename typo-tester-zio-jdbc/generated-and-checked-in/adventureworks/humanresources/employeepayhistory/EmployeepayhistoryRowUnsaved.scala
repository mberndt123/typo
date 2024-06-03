/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `humanresources.employeepayhistory` which has not been persisted yet */
case class EmployeepayhistoryRowUnsaved(
  /** Employee identification number. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Date the change in pay is effective */
  ratechangedate: TypoLocalDateTime,
  /** Salary hourly rate.
      Constraint CK_EmployeePayHistory_Rate affecting columns rate:  (((rate >= 6.50) AND (rate <= 200.00))) */
  rate: BigDecimal,
  /** 1 = Salary received monthly, 2 = Salary received biweekly
      Constraint CK_EmployeePayHistory_PayFrequency affecting columns payfrequency:  ((payfrequency = ANY (ARRAY[1, 2]))) */
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
  implicit lazy val jsonDecoder: JsonDecoder[EmployeepayhistoryRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val ratechangedate = jsonObj.get("ratechangedate").toRight("Missing field 'ratechangedate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val rate = jsonObj.get("rate").toRight("Missing field 'rate'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val payfrequency = jsonObj.get("payfrequency").toRight("Missing field 'payfrequency'").flatMap(_.as(TypoShort.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (businessentityid.isRight && ratechangedate.isRight && rate.isRight && payfrequency.isRight && modifieddate.isRight)
      Right(EmployeepayhistoryRowUnsaved(businessentityid = businessentityid.toOption.get, ratechangedate = ratechangedate.toOption.get, rate = rate.toOption.get, payfrequency = payfrequency.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, ratechangedate, rate, payfrequency, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[EmployeepayhistoryRowUnsaved] = new JsonEncoder[EmployeepayhistoryRowUnsaved] {
    override def unsafeEncode(a: EmployeepayhistoryRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""ratechangedate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.ratechangedate, indent, out)
      out.write(",")
      out.write(""""rate":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.rate, indent, out)
      out.write(",")
      out.write(""""payfrequency":""")
      TypoShort.jsonEncoder.unsafeEncode(a.payfrequency, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
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
}
