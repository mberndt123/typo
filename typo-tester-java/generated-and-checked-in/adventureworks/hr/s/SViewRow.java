/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.s;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoLocalTime;
import adventureworks.humanresources.shift.ShiftId;
import adventureworks.public_.Name;

/** View: hr.s */
public record SViewRow(
  /** Points to {@link adventureworks.humanresources.shift.ShiftRow.shiftid} */
  ShiftId id,
  /** Points to {@link adventureworks.humanresources.shift.ShiftRow.shiftid} */
  ShiftId shiftid,
  /** Points to {@link adventureworks.humanresources.shift.ShiftRow.name} */
  Name name,
  /** Points to {@link adventureworks.humanresources.shift.ShiftRow.starttime} */
  TypoLocalTime starttime,
  /** Points to {@link adventureworks.humanresources.shift.ShiftRow.endtime} */
  TypoLocalTime endtime,
  /** Points to {@link adventureworks.humanresources.shift.ShiftRow.modifieddate} */
  TypoLocalDateTime modifieddate
) {
  
}