/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_column_usage

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object ViewColumnUsageViewRepoImpl extends ViewColumnUsageViewRepo {
  override def select: SelectBuilder[ViewColumnUsageViewFields, ViewColumnUsageViewRow] = {
    SelectBuilderSql("information_schema.view_column_usage", ViewColumnUsageViewFields, ViewColumnUsageViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ViewColumnUsageViewRow] = {
    sql"""select "view_catalog", "view_schema", "view_name", "table_catalog", "table_schema", "table_name", "column_name" from information_schema.view_column_usage""".query(ViewColumnUsageViewRow.read).stream
  }
}
