/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_available_extensions

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgAvailableExtensionsViewRepoImpl extends PgAvailableExtensionsViewRepo {
  override def select: SelectBuilder[PgAvailableExtensionsViewFields, PgAvailableExtensionsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_available_extensions", PgAvailableExtensionsViewFields, PgAvailableExtensionsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgAvailableExtensionsViewRow] = {
    SQL"""select "name", "default_version", "installed_version", "comment"
          from pg_catalog.pg_available_extensions
       """.as(PgAvailableExtensionsViewRow.rowParser(1).*)
  }
}
