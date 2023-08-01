/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_rules

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgRulesViewRepoImpl extends PgRulesViewRepo {
  override def select: SelectBuilder[PgRulesViewFields, PgRulesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_rules", PgRulesViewFields, PgRulesViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgRulesViewRow] = {
    SQL"""select schemaname, tablename, rulename, definition
          from pg_catalog.pg_rules
       """.as(PgRulesViewRow.rowParser(1).*)
  }
}
