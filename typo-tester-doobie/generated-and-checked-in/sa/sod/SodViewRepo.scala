/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sod

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait SodViewRepo {
  def select: SelectBuilder[SodViewFields, SodViewRow]
  def selectAll: Stream[ConnectionIO, SodViewRow]
}
