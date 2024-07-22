/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.vemployeedepartmenthistory;

import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import zio.jdbc.ZConnection;
import zio.jdbc.sqlInterpolator;
import zio.stream.ZStream;

class VemployeedepartmenthistoryViewRepoImpl extends VemployeedepartmenthistoryViewRepo {
  def select: SelectBuilder[VemployeedepartmenthistoryViewFields, VemployeedepartmenthistoryViewRow] = SelectBuilderSql("humanresources.vemployeedepartmenthistory", VemployeedepartmenthistoryViewFields.structure, VemployeedepartmenthistoryViewRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, VemployeedepartmenthistoryViewRow] = sql"""select "businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "shift", "department", "groupname", "startdate"::text, "enddate"::text from humanresources.vemployeedepartmenthistory""".query(using VemployeedepartmenthistoryViewRow.jdbcDecoder).selectStream()
}