/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployee

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait VemployeeViewRepo {
  def select: SelectBuilder[VemployeeViewFields, VemployeeViewRow]
  def selectAll: Stream[ConnectionIO, VemployeeViewRow]
}
