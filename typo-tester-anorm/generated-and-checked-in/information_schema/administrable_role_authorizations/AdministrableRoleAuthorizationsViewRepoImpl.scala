/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package administrable_role_authorizations

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object AdministrableRoleAuthorizationsViewRepoImpl extends AdministrableRoleAuthorizationsViewRepo {
  override def select: SelectBuilder[AdministrableRoleAuthorizationsViewFields, AdministrableRoleAuthorizationsViewRow] = {
    SelectBuilderSql("information_schema.administrable_role_authorizations", AdministrableRoleAuthorizationsViewFields, AdministrableRoleAuthorizationsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[AdministrableRoleAuthorizationsViewRow] = {
    SQL"""select grantee, role_name, is_grantable
          from information_schema.administrable_role_authorizations
       """.as(AdministrableRoleAuthorizationsViewRow.rowParser(1).*)
  }
}
