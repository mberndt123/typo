/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sci

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SciViewRepoImpl extends SciViewRepo {
  override def select: SelectBuilder[SciViewFields, SciViewRow] = {
    SelectBuilderSql("sa.sci", SciViewFields.structure, SciViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SciViewRow] = {
    sql"""select "id", "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated"::text, "modifieddate"::text from sa.sci""".query(using SciViewRow.read).stream
  }
}
