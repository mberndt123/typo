/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.psc

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class PscViewRepoImpl extends PscViewRepo {
  override def select: SelectBuilder[PscViewFields, PscViewRow] = {
    SelectBuilderSql("pr.psc", PscViewFields.structure, PscViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PscViewRow] = {
    sql"""select "id", "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text from pr.psc""".query(using PscViewRow.jdbcDecoder).selectStream()
  }
}
