/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pm

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PmViewRepo {
  def select: SelectBuilder[PmViewFields, PmViewRow]
  def selectAll: Stream[ConnectionIO, PmViewRow]
}
