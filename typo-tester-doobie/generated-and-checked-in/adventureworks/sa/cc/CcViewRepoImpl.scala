/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.cc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class CcViewRepoImpl extends CcViewRepo {
  override def select: SelectBuilder[CcViewFields, CcViewRow] = {
    SelectBuilderSql("sa.cc", CcViewFields.structure, CcViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CcViewRow] = {
    sql"""select "id", "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate"::text from sa.cc""".query(using CcViewRow.read).stream
  }
}
