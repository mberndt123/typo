/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pch

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PchViewRepoImpl extends PchViewRepo {
  override def select: SelectBuilder[PchViewFields, PchViewRow] = {
    SelectBuilderSql("pr.pch", PchViewFields, PchViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PchViewRow] = {
    sql"""select "id", "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text from pr.pch""".query(PchViewRow.read).stream
  }
}
