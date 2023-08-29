/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_column_usage

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object RoutineColumnUsageViewRepoImpl extends RoutineColumnUsageViewRepo {
  override def select: SelectBuilder[RoutineColumnUsageViewFields, RoutineColumnUsageViewRow] = {
    SelectBuilderSql("information_schema.routine_column_usage", RoutineColumnUsageViewFields, RoutineColumnUsageViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, RoutineColumnUsageViewRow] = {
    sql"""select "specific_catalog", "specific_schema", "specific_name", "routine_catalog", "routine_schema", "routine_name", "table_catalog", "table_schema", "table_name", "column_name" from information_schema.routine_column_usage""".query(RoutineColumnUsageViewRow.read).stream
  }
}
