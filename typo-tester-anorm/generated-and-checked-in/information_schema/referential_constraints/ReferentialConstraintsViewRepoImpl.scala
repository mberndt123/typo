/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package referential_constraints

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object ReferentialConstraintsViewRepoImpl extends ReferentialConstraintsViewRepo {
  override def select: SelectBuilder[ReferentialConstraintsViewFields, ReferentialConstraintsViewRow] = {
    SelectBuilderSql("information_schema.referential_constraints", ReferentialConstraintsViewFields, ReferentialConstraintsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ReferentialConstraintsViewRow] = {
    SQL"""select "constraint_catalog", "constraint_schema", "constraint_name", unique_constraint_catalog, unique_constraint_schema, unique_constraint_name, match_option, update_rule, delete_rule
          from information_schema.referential_constraints
       """.as(ReferentialConstraintsViewRow.rowParser(1).*)
  }
}
