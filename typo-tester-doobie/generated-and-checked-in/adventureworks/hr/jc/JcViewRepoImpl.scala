/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.jc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class JcViewRepoImpl extends JcViewRepo {
  override def select: SelectBuilder[JcViewFields, JcViewRow] = {
    SelectBuilderSql("hr.jc", JcViewFields.structure, JcViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, JcViewRow] = {
    sql"""select "id", "jobcandidateid", "businessentityid", "resume", "modifieddate"::text from hr.jc""".query(using JcViewRow.read).stream
  }
}
