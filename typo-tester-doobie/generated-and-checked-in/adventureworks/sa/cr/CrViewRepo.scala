/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.cr

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait CrViewRepo {
  def select: SelectBuilder[CrViewFields, CrViewRow]
  def selectAll: Stream[ConnectionIO, CrViewRow]
}
