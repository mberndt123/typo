/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.pa

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PaViewRepo {
  def select: SelectBuilder[PaViewFields, PaViewRow]
  def selectAll: Stream[ConnectionIO, PaViewRow]
}
