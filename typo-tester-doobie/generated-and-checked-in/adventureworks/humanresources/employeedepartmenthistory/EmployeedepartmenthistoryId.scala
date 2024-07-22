/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.employeedepartmenthistory;

import adventureworks.customtypes.TypoLocalDate;
import adventureworks.humanresources.department.DepartmentId;
import adventureworks.humanresources.shift.ShiftId;
import adventureworks.person.businessentity.BusinessentityId;
import io.circe.Decoder;
import io.circe.Encoder;

/** Type for the composite primary key of table `humanresources.employeedepartmenthistory` */
case class EmployeedepartmenthistoryId(
  businessentityid: BusinessentityId,
  startdate: TypoLocalDate,
  departmentid: DepartmentId,
  shiftid: ShiftId
)

object EmployeedepartmenthistoryId {
  implicit lazy val decoder: Decoder[EmployeedepartmenthistoryId] = Decoder.forProduct4[EmployeedepartmenthistoryId, BusinessentityId, TypoLocalDate, DepartmentId, ShiftId]("businessentityid", "startdate", "departmentid", "shiftid")(EmployeedepartmenthistoryId.apply)(BusinessentityId.decoder, TypoLocalDate.decoder, DepartmentId.decoder, ShiftId.decoder)
  implicit lazy val encoder: Encoder[EmployeedepartmenthistoryId] = Encoder.forProduct4[EmployeedepartmenthistoryId, BusinessentityId, TypoLocalDate, DepartmentId, ShiftId]("businessentityid", "startdate", "departmentid", "shiftid")(x => (x.businessentityid, x.startdate, x.departmentid, x.shiftid))(BusinessentityId.encoder, TypoLocalDate.encoder, DepartmentId.encoder, ShiftId.encoder)
}