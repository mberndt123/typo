/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_routine_usage

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait ViewRoutineUsageViewRepo {
  def select: SelectBuilder[ViewRoutineUsageViewFields, ViewRoutineUsageViewRow]
  def selectAll: Stream[ConnectionIO, ViewRoutineUsageViewRow]
}
