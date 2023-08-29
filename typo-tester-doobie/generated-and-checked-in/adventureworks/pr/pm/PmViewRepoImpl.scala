/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pm

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PmViewRepoImpl extends PmViewRepo {
  override def select: SelectBuilder[PmViewFields, PmViewRow] = {
    SelectBuilderSql("pr.pm", PmViewFields, PmViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PmViewRow] = {
    sql"""select "id", "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text from pr.pm""".query(PmViewRow.read).stream
  }
}
