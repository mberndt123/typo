/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
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

/** Table: humanresources.employeedepartmenthistory
    Employee department transfers.
    Composite primary key: businessentityid, startdate, departmentid, shiftid */
case class EmployeedepartmenthistoryRow(
  /** Employee identification number. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Department in which the employee worked including currently. Foreign key to Department.DepartmentID.
      Points to [[department.DepartmentRow.departmentid]] */
  departmentid: DepartmentId,
  /** Identifies which 8-hour shift the employee works. Foreign key to Shift.Shift.ID.
      Points to [[shift.ShiftRow.shiftid]] */
  shiftid: ShiftId,
  /** Date the employee started work in the department.
      Constraint CK_EmployeeDepartmentHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDate,
  /** Date the employee left the department. NULL = Current department.
      Constraint CK_EmployeeDepartmentHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDate],
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: EmployeedepartmenthistoryId = EmployeedepartmenthistoryId(businessentityid, startdate, departmentid, shiftid)
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): EmployeedepartmenthistoryRowUnsaved =
     EmployeedepartmenthistoryRowUnsaved(businessentityid, departmentid, shiftid, startdate, enddate, modifieddate)
 }

object EmployeedepartmenthistoryRow {
  def apply(compositeId: EmployeedepartmenthistoryId, enddate: Option[TypoLocalDate], modifieddate: TypoLocalDateTime) =
    new EmployeedepartmenthistoryRow(compositeId.businessentityid, compositeId.departmentid, compositeId.shiftid, compositeId.startdate, enddate, modifieddate)
  implicit lazy val reads: Reads[EmployeedepartmenthistoryRow] = Reads[EmployeedepartmenthistoryRow](json => JsResult.fromTry(
      Try(
        EmployeedepartmenthistoryRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          departmentid = json.\("departmentid").as(DepartmentId.reads),
          shiftid = json.\("shiftid").as(ShiftId.reads),
          startdate = json.\("startdate").as(TypoLocalDate.reads),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDate.reads)),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[EmployeedepartmenthistoryRow] = RowParser[EmployeedepartmenthistoryRow] { row =>
    Success(
      EmployeedepartmenthistoryRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        departmentid = row(idx + 1)(DepartmentId.column),
        shiftid = row(idx + 2)(ShiftId.column),
        startdate = row(idx + 3)(TypoLocalDate.column),
        enddate = row(idx + 4)(Column.columnToOption(TypoLocalDate.column)),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[EmployeedepartmenthistoryRow] = Text.instance[EmployeedepartmenthistoryRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    DepartmentId.text.unsafeEncode(row.departmentid, sb)
    sb.append(Text.DELIMETER)
    ShiftId.text.unsafeEncode(row.shiftid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDate.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDate.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[EmployeedepartmenthistoryRow] = OWrites[EmployeedepartmenthistoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "departmentid" -> DepartmentId.writes.writes(o.departmentid),
      "shiftid" -> ShiftId.writes.writes(o.shiftid),
      "startdate" -> TypoLocalDate.writes.writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDate.writes).writes(o.enddate),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
