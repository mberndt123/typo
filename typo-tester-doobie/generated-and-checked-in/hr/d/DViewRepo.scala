/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package d

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait DViewRepo {
  def select: SelectBuilder[DViewFields, DViewRow]
  def selectAll: Stream[ConnectionIO, DViewRow]
}
