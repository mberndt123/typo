/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_privileges

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object RoutinePrivilegesViewRepoImpl extends RoutinePrivilegesViewRepo {
  override def select: SelectBuilder[RoutinePrivilegesViewFields, RoutinePrivilegesViewRow] = {
    SelectBuilderSql("information_schema.routine_privileges", RoutinePrivilegesViewFields, RoutinePrivilegesViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[RoutinePrivilegesViewRow] = {
    SQL"""select grantor, grantee, specific_catalog, specific_schema, "specific_name", "routine_catalog", "routine_schema", "routine_name", privilege_type, is_grantable
          from information_schema.routine_privileges
       """.as(RoutinePrivilegesViewRow.rowParser(1).*)
  }
}
