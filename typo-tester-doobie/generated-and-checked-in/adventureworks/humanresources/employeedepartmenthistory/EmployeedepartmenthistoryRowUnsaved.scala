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
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `humanresources.employeedepartmenthistory` which has not been persisted yet */
case class EmployeedepartmenthistoryRowUnsaved(
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
      Constraint CK_EmployeeDepartmentHistory_EndDate affecting columns "enddate", "startdate":  (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDate,
  /** Date the employee left the department. NULL = Current department.
      Constraint CK_EmployeeDepartmentHistory_EndDate affecting columns "enddate", "startdate":  (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDate],
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): EmployeedepartmenthistoryRow =
    EmployeedepartmenthistoryRow(
      businessentityid = businessentityid,
      departmentid = departmentid,
      shiftid = shiftid,
      startdate = startdate,
      enddate = enddate,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object EmployeedepartmenthistoryRowUnsaved {
  implicit lazy val decoder: Decoder[EmployeedepartmenthistoryRowUnsaved] = Decoder.forProduct6[EmployeedepartmenthistoryRowUnsaved, BusinessentityId, DepartmentId, ShiftId, TypoLocalDate, Option[TypoLocalDate], Defaulted[TypoLocalDateTime]]("businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate")(EmployeedepartmenthistoryRowUnsaved.apply)(BusinessentityId.decoder, DepartmentId.decoder, ShiftId.decoder, TypoLocalDate.decoder, Decoder.decodeOption(TypoLocalDate.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[EmployeedepartmenthistoryRowUnsaved] = Encoder.forProduct6[EmployeedepartmenthistoryRowUnsaved, BusinessentityId, DepartmentId, ShiftId, TypoLocalDate, Option[TypoLocalDate], Defaulted[TypoLocalDateTime]]("businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate")(x => (x.businessentityid, x.departmentid, x.shiftid, x.startdate, x.enddate, x.modifieddate))(BusinessentityId.encoder, DepartmentId.encoder, ShiftId.encoder, TypoLocalDate.encoder, Encoder.encodeOption(TypoLocalDate.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[EmployeedepartmenthistoryRowUnsaved] = Text.instance[EmployeedepartmenthistoryRowUnsaved]{ (row, sb) =>
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
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
