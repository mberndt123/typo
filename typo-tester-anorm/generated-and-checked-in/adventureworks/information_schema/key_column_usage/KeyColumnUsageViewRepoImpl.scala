/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package key_column_usage

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object KeyColumnUsageViewRepoImpl extends KeyColumnUsageViewRepo {
  override def select: SelectBuilder[KeyColumnUsageViewFields, KeyColumnUsageViewRow] = {
    SelectBuilderSql("information_schema.key_column_usage", KeyColumnUsageViewFields, KeyColumnUsageViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[KeyColumnUsageViewRow] = {
    SQL"""select "constraint_catalog", "constraint_schema", "constraint_name", "table_catalog", "table_schema", "table_name", "column_name", "ordinal_position", "position_in_unique_constraint"
          from information_schema.key_column_usage
       """.as(KeyColumnUsageViewRow.rowParser(1).*)
  }
}
