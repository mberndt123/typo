/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pu.v

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait VViewRepo {
  def select: SelectBuilder[VViewFields, VViewRow]
  def selectAll: Stream[ConnectionIO, VViewRow]
}
