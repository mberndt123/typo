/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.vstorewithaddresses

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait VstorewithaddressesViewRepo {
  def select: SelectBuilder[VstorewithaddressesViewFields, VstorewithaddressesViewRow]
  def selectAll: Stream[ConnectionIO, VstorewithaddressesViewRow]
}
