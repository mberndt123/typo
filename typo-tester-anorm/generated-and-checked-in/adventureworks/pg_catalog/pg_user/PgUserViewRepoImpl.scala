/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgUserViewRepoImpl extends PgUserViewRepo {
  override def select: SelectBuilder[PgUserViewFields, PgUserViewRow] = {
    SelectBuilderSql("pg_catalog.pg_user", PgUserViewFields, PgUserViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgUserViewRow] = {
    SQL"""select "usename", "usesysid", "usecreatedb", "usesuper", "userepl", "usebypassrls", "passwd", "valuntil"::text, "useconfig"
          from pg_catalog.pg_user
       """.as(PgUserViewRow.rowParser(1).*)
  }
}
