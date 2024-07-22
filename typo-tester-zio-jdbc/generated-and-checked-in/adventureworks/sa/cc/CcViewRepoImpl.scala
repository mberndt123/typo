/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.cc

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class CcViewRepoImpl extends CcViewRepo {
  override def select: SelectBuilder[CcViewFields, CcViewRow] = {
    SelectBuilderSql("sa.cc", CcViewFields.structure, CcViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CcViewRow] = {
    sql"""select "id", "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate"::text from sa.cc""".query(using CcViewRow.jdbcDecoder).selectStream()
  }
}
