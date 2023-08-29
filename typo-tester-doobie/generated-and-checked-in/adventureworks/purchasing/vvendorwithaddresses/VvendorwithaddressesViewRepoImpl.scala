/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vvendorwithaddresses

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VvendorwithaddressesViewRepoImpl extends VvendorwithaddressesViewRepo {
  override def select: SelectBuilder[VvendorwithaddressesViewFields, VvendorwithaddressesViewRow] = {
    SelectBuilderSql("purchasing.vvendorwithaddresses", VvendorwithaddressesViewFields, VvendorwithaddressesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, VvendorwithaddressesViewRow] = {
    sql"""select "businessentityid", "name", "addresstype", "addressline1", "addressline2", "city", "stateprovincename", "postalcode", "countryregionname" from purchasing.vvendorwithaddresses""".query(VvendorwithaddressesViewRow.read).stream
  }
}
