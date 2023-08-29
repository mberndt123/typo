/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_routine_usage

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object RoutineRoutineUsageViewRepoImpl extends RoutineRoutineUsageViewRepo {
  override def select: SelectBuilder[RoutineRoutineUsageViewFields, RoutineRoutineUsageViewRow] = {
    SelectBuilderSql("information_schema.routine_routine_usage", RoutineRoutineUsageViewFields, RoutineRoutineUsageViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, RoutineRoutineUsageViewRow] = {
    sql"""select "specific_catalog", "specific_schema", "specific_name", "routine_catalog", "routine_schema", "routine_name" from information_schema.routine_routine_usage""".query(RoutineRoutineUsageViewRow.read).stream
  }
}
