/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.bea

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class BeaViewRepoImpl extends BeaViewRepo {
  override def select: SelectBuilder[BeaViewFields, BeaViewRow] = {
    SelectBuilderSql("pe.bea", BeaViewFields.structure, BeaViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, BeaViewRow] = {
    sql"""select "id", "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text from pe.bea""".query(using BeaViewRow.read).stream
  }
}
