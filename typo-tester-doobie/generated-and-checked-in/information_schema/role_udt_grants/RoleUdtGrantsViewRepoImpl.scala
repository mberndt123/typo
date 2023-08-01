/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_udt_grants

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object RoleUdtGrantsViewRepoImpl extends RoleUdtGrantsViewRepo {
  override def select: SelectBuilder[RoleUdtGrantsViewFields, RoleUdtGrantsViewRow] = {
    SelectBuilderSql("information_schema.role_udt_grants", RoleUdtGrantsViewFields, RoleUdtGrantsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, RoleUdtGrantsViewRow] = {
    sql"select grantor, grantee, udt_catalog, udt_schema, udt_name, privilege_type, is_grantable from information_schema.role_udt_grants".query(RoleUdtGrantsViewRow.read).stream
  }
}
