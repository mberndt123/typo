/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sr

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SrViewRepoImpl extends SrViewRepo {
  override def select: SelectBuilder[SrViewFields, SrViewRow] = {
    SelectBuilderSql("sa.sr", SrViewFields.structure, SrViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SrViewRow] = {
    sql"""select "id", "salesreasonid", "name", "reasontype", "modifieddate"::text from sa.sr""".query(using SrViewRow.read).stream
  }
}
