/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.ppp

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class PppViewRepoImpl extends PppViewRepo {
  override def select: SelectBuilder[PppViewFields, PppViewRow] = {
    SelectBuilderSql("pr.ppp", PppViewFields.structure, PppViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PppViewRow] = {
    sql"""select "productid", "productphotoid", "primary", "modifieddate"::text from pr.ppp""".query(using PppViewRow.jdbcDecoder).selectStream()
  }
}
