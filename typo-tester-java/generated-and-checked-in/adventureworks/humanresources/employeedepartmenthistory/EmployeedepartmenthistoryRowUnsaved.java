/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.employeedepartmenthistory;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDate;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.humanresources.department.DepartmentId;
import adventureworks.humanresources.shift.ShiftId;
import adventureworks.person.businessentity.BusinessentityId;
import java.util.Optional;

/** This class corresponds to a row in table `humanresources.employeedepartmenthistory` which has not been persisted yet */
public record EmployeedepartmenthistoryRowUnsaved(
  /** Employee identification number. Foreign key to Employee.BusinessEntityID.
    * Points to {@link adventureworks.humanresources.employee.EmployeeRow.businessentityid}
    */
  BusinessentityId businessentityid,
  /** Department in which the employee worked including currently. Foreign key to Department.DepartmentID.
    * Points to {@link adventureworks.humanresources.department.DepartmentRow.departmentid}
    */
  DepartmentId departmentid,
  /** Identifies which 8-hour shift the employee works. Foreign key to Shift.Shift.ID.
    * Points to {@link adventureworks.humanresources.shift.ShiftRow.shiftid}
    */
  ShiftId shiftid,
  /** Date the employee started work in the department.
    * Constraint CK_EmployeeDepartmentHistory_EndDate affecting columns enddate, startdate:  (((enddate >= startdate) OR (enddate IS NULL)))
    */
  TypoLocalDate startdate,
  /** Date the employee left the department. NULL = Current department.
    * Constraint CK_EmployeeDepartmentHistory_EndDate affecting columns enddate, startdate:  (((enddate >= startdate) OR (enddate IS NULL)))
    */
  Optional<TypoLocalDate> enddate,
  /** Default: now() */
  Defaulted<TypoLocalDateTime> modifieddate
) {
  public EmployeedepartmenthistoryRow toRow(java.util.function.Supplier<TypoLocalDateTime> modifieddateDefault) {
    return new EmployeedepartmenthistoryRow(businessentityid, departmentid, shiftid, startdate, enddate, modifieddate.getOrElse(modifieddateDefault));
  };
}