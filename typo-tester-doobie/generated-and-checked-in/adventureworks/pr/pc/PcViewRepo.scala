/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pc

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PcViewRepo {
  def select: SelectBuilder[PcViewFields, PcViewRow]
  def selectAll: Stream[ConnectionIO, PcViewRow]
}
