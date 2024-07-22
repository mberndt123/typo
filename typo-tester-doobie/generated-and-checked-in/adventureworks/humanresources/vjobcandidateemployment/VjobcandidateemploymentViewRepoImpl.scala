/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.vjobcandidateemployment;

import doobie.free.connection.ConnectionIO;
import doobie.syntax.string.toSqlInterpolator;
import fs2.Stream;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class VjobcandidateemploymentViewRepoImpl extends VjobcandidateemploymentViewRepo {
  def select: SelectBuilder[VjobcandidateemploymentViewFields, VjobcandidateemploymentViewRow] = SelectBuilderSql("humanresources.vjobcandidateemployment", VjobcandidateemploymentViewFields.structure, VjobcandidateemploymentViewRow.read)
  def selectAll: Stream[ConnectionIO, VjobcandidateemploymentViewRow] = sql"""select "jobcandidateid", "Emp.StartDate"::text, "Emp.EndDate"::text, "Emp.OrgName", "Emp.JobTitle", "Emp.Responsibility", "Emp.FunctionCategory", "Emp.IndustryCategory", "Emp.Loc.CountryRegion", "Emp.Loc.State", "Emp.Loc.City" from humanresources.vjobcandidateemployment""".query(using VjobcandidateemploymentViewRow.read).stream
}