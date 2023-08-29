/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggers

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object TriggersViewRepoImpl extends TriggersViewRepo {
  override def select: SelectBuilder[TriggersViewFields, TriggersViewRow] = {
    SelectBuilderSql("information_schema.triggers", TriggersViewFields, TriggersViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, TriggersViewRow] = {
    sql"""select "trigger_catalog", "trigger_schema", "trigger_name", "event_manipulation", "event_object_catalog", "event_object_schema", "event_object_table", "action_order", "action_condition", "action_statement", "action_orientation", "action_timing", "action_reference_old_table", "action_reference_new_table", "action_reference_old_row", "action_reference_new_row", "created"::text from information_schema.triggers""".query(TriggersViewRow.read).stream
  }
}
