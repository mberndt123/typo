/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_foreign_servers`

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgForeignServersViewRepo {
  def select: SelectBuilder[PgForeignServersViewFields, PgForeignServersViewRow]
  def selectAll(implicit c: Connection): List[PgForeignServersViewRow]
}
