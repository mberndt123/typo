/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_all_tables

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgStatXactAllTablesViewRepo {
  def select: SelectBuilder[PgStatXactAllTablesViewFields, PgStatXactAllTablesViewRow]
  def selectAll(implicit c: Connection): List[PgStatXactAllTablesViewRow]
}
