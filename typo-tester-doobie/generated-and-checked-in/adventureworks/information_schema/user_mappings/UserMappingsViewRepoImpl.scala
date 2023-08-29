/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_mappings

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object UserMappingsViewRepoImpl extends UserMappingsViewRepo {
  override def select: SelectBuilder[UserMappingsViewFields, UserMappingsViewRow] = {
    SelectBuilderSql("information_schema.user_mappings", UserMappingsViewFields, UserMappingsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, UserMappingsViewRow] = {
    sql"""select "authorization_identifier", "foreign_server_catalog", "foreign_server_name" from information_schema.user_mappings""".query(UserMappingsViewRow.read).stream
  }
}
