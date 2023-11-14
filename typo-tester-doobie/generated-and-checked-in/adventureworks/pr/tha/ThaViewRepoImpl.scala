/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package tha

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class ThaViewRepoImpl extends ThaViewRepo {
  override def select: SelectBuilder[ThaViewFields, ThaViewRow] = {
    SelectBuilderSql("pr.tha", ThaViewFields, ThaViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ThaViewRow] = {
    sql"""select "id", "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text from pr.tha""".query(ThaViewRow.read).stream
  }
}
