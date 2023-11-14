/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cr

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class CrViewRepoImpl extends CrViewRepo {
  override def select: SelectBuilder[CrViewFields, CrViewRow] = {
    SelectBuilderSql("sa.cr", CrViewFields, CrViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CrViewRow] = {
    sql"""select "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text from sa.cr""".query(CrViewRow.jdbcDecoder).selectStream
  }
}
