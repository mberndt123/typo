/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_table_usage

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object RoutineTableUsageViewRepoImpl extends RoutineTableUsageViewRepo {
  override def select: SelectBuilder[RoutineTableUsageViewFields, RoutineTableUsageViewRow] = {
    SelectBuilderSql("information_schema.routine_table_usage", RoutineTableUsageViewFields, RoutineTableUsageViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[RoutineTableUsageViewRow] = {
    SQL"""select specific_catalog, specific_schema, "specific_name", "routine_catalog", "routine_schema", "routine_name", table_catalog, table_schema, "table_name"
          from information_schema.routine_table_usage
       """.as(RoutineTableUsageViewRow.rowParser(1).*)
  }
}
