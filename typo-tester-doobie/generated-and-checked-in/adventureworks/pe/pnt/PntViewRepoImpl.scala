/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pnt

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PntViewRepoImpl extends PntViewRepo {
  override def select: SelectBuilder[PntViewFields, PntViewRow] = {
    SelectBuilderSql("pe.pnt", PntViewFields, PntViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PntViewRow] = {
    sql"""select "id", "phonenumbertypeid", "name", "modifieddate"::text from pe.pnt""".query(PntViewRow.read).stream
  }
}
