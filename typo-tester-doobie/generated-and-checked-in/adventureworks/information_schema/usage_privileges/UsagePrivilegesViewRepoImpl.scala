/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package usage_privileges

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object UsagePrivilegesViewRepoImpl extends UsagePrivilegesViewRepo {
  override def select: SelectBuilder[UsagePrivilegesViewFields, UsagePrivilegesViewRow] = {
    SelectBuilderSql("information_schema.usage_privileges", UsagePrivilegesViewFields, UsagePrivilegesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, UsagePrivilegesViewRow] = {
    sql"""select "grantor", "grantee", "object_catalog", "object_schema", "object_name", "object_type", "privilege_type", "is_grantable" from information_schema.usage_privileges""".query(UsagePrivilegesViewRow.read).stream
  }
}
