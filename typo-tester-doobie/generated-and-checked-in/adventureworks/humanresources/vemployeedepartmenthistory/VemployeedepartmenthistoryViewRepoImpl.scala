/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartmenthistory

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VemployeedepartmenthistoryViewRepoImpl extends VemployeedepartmenthistoryViewRepo {
  override def select: SelectBuilder[VemployeedepartmenthistoryViewFields, VemployeedepartmenthistoryViewRow] = {
    SelectBuilderSql("humanresources.vemployeedepartmenthistory", VemployeedepartmenthistoryViewFields, VemployeedepartmenthistoryViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, VemployeedepartmenthistoryViewRow] = {
    sql"""select "businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "shift", "department", "groupname", "startdate"::text, "enddate"::text from humanresources.vemployeedepartmenthistory""".query(VemployeedepartmenthistoryViewRow.read).stream
  }
}
