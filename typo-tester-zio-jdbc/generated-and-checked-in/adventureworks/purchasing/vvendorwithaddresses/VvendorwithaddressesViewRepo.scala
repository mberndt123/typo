/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.vvendorwithaddresses

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait VvendorwithaddressesViewRepo {
  def select: SelectBuilder[VvendorwithaddressesViewFields, VvendorwithaddressesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, VvendorwithaddressesViewRow]
}
