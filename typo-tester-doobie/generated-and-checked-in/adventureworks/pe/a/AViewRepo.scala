/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.a

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait AViewRepo {
  def select: SelectBuilder[AViewFields, AViewRow]
  def selectAll: Stream[ConnectionIO, AViewRow]
}
