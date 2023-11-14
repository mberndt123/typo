/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package pcc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PccViewRepoImpl extends PccViewRepo {
  override def select: SelectBuilder[PccViewFields, PccViewRow] = {
    SelectBuilderSql("sa.pcc", PccViewFields, PccViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PccViewRow] = {
    sql"""select "id", "businessentityid", "creditcardid", "modifieddate"::text from sa.pcc""".query(PccViewRow.read).stream
  }
}
