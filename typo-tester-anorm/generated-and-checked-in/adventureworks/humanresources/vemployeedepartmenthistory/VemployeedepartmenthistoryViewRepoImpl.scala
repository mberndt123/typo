/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartmenthistory

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class VemployeedepartmenthistoryViewRepoImpl extends VemployeedepartmenthistoryViewRepo {
  override def select: SelectBuilder[VemployeedepartmenthistoryViewFields, VemployeedepartmenthistoryViewRow] = {
    SelectBuilderSql("humanresources.vemployeedepartmenthistory", VemployeedepartmenthistoryViewFields, VemployeedepartmenthistoryViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[VemployeedepartmenthistoryViewRow] = {
    SQL"""select "businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "shift", "department", "groupname", "startdate"::text, "enddate"::text
          from humanresources.vemployeedepartmenthistory
       """.as(VemployeedepartmenthistoryViewRow.rowParser(1).*)
  }
}
