/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_routine_usage

import java.sql.Connection
import typo.dsl.SelectBuilder

trait ViewRoutineUsageViewRepo {
  def select: SelectBuilder[ViewRoutineUsageViewFields, ViewRoutineUsageViewRow]
  def selectAll(implicit c: Connection): List[ViewRoutineUsageViewRow]
}
