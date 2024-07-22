/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.s;

import anorm.SqlStringInterpolation;
import java.sql.Connection;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class SViewRepoImpl extends SViewRepo {
  def select: SelectBuilder[SViewFields, SViewRow] = SelectBuilderSql("hr.s", SViewFields.structure, SViewRow.rowParser)
  def selectAll(implicit c: Connection): List[SViewRow] = {
    SQL"""select "id", "shiftid", "name", "starttime"::text, "endtime"::text, "modifieddate"::text
          from hr.s
       """.as(SViewRow.rowParser(1).*)
  }
}