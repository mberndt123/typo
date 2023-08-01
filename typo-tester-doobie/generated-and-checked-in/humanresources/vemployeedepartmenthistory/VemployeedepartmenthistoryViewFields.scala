/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartmenthistory

import adventureworks.TypoLocalDate
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import typo.dsl.SqlExpr.OptField

trait VemployeedepartmenthistoryViewFields[Row] {
  val businessentityid: OptField[BusinessentityId, Row]
  val title: OptField[/* max 8 chars */ String, Row]
  val firstname: OptField[Name, Row]
  val middlename: OptField[Name, Row]
  val lastname: OptField[Name, Row]
  val suffix: OptField[/* max 10 chars */ String, Row]
  val shift: OptField[Name, Row]
  val department: OptField[Name, Row]
  val groupname: OptField[Name, Row]
  val startdate: OptField[TypoLocalDate, Row]
  val enddate: OptField[TypoLocalDate, Row]
}
object VemployeedepartmenthistoryViewFields extends VemployeedepartmenthistoryViewStructure[VemployeedepartmenthistoryViewRow](None, identity, (_, x) => x)

