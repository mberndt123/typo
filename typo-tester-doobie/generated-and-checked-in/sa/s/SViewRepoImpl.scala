/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package s

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object SViewRepoImpl extends SViewRepo {
  override def select: SelectBuilder[SViewFields, SViewRow] = {
    SelectBuilderSql("sa.s", SViewFields, SViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SViewRow] = {
    sql"""select "id", businessentityid, "name", salespersonid, demographics, rowguid, modifieddate::text from sa.s""".query(SViewRow.read).stream
  }
}
