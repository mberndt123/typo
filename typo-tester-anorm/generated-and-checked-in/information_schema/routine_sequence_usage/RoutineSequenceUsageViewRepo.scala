/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_sequence_usage

import java.sql.Connection
import typo.dsl.SelectBuilder

trait RoutineSequenceUsageViewRepo {
  def select: SelectBuilder[RoutineSequenceUsageViewFields, RoutineSequenceUsageViewRow]
  def selectAll(implicit c: Connection): List[RoutineSequenceUsageViewRow]
}
