/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.employeedepartmenthistory

import adventureworks.customtypes.TypoLocalDate
import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Type for the composite primary key of table `humanresources.employeedepartmenthistory` */
case class EmployeedepartmenthistoryId(
  businessentityid: BusinessentityId,
  startdate: TypoLocalDate,
  departmentid: DepartmentId,
  shiftid: ShiftId
)
object EmployeedepartmenthistoryId {
  implicit lazy val jsonDecoder: JsonDecoder[EmployeedepartmenthistoryId] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(TypoLocalDate.jsonDecoder))
    val departmentid = jsonObj.get("departmentid").toRight("Missing field 'departmentid'").flatMap(_.as(DepartmentId.jsonDecoder))
    val shiftid = jsonObj.get("shiftid").toRight("Missing field 'shiftid'").flatMap(_.as(ShiftId.jsonDecoder))
    if (businessentityid.isRight && startdate.isRight && departmentid.isRight && shiftid.isRight)
      Right(EmployeedepartmenthistoryId(businessentityid = businessentityid.toOption.get, startdate = startdate.toOption.get, departmentid = departmentid.toOption.get, shiftid = shiftid.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, startdate, departmentid, shiftid).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[EmployeedepartmenthistoryId] = new JsonEncoder[EmployeedepartmenthistoryId] {
    override def unsafeEncode(a: EmployeedepartmenthistoryId, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""startdate":""")
      TypoLocalDate.jsonEncoder.unsafeEncode(a.startdate, indent, out)
      out.write(",")
      out.write(""""departmentid":""")
      DepartmentId.jsonEncoder.unsafeEncode(a.departmentid, indent, out)
      out.write(",")
      out.write(""""shiftid":""")
      ShiftId.jsonEncoder.unsafeEncode(a.shiftid, indent, out)
      out.write("}")
    }
  }
}
