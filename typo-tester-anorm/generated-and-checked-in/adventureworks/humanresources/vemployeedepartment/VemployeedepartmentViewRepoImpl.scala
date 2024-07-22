/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.vemployeedepartment;

import anorm.SqlStringInterpolation;
import java.sql.Connection;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class VemployeedepartmentViewRepoImpl extends VemployeedepartmentViewRepo {
  def select: SelectBuilder[VemployeedepartmentViewFields, VemployeedepartmentViewRow] = SelectBuilderSql("humanresources.vemployeedepartment", VemployeedepartmentViewFields.structure, VemployeedepartmentViewRow.rowParser)
  def selectAll(implicit c: Connection): List[VemployeedepartmentViewRow] = {
    SQL"""select "businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "jobtitle", "department", "groupname", "startdate"::text
          from humanresources.vemployeedepartment
       """.as(VemployeedepartmentViewRow.rowParser(1).*)
  }
}