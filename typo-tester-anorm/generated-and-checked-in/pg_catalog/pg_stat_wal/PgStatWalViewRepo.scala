/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_wal

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgStatWalViewRepo {
  def select: SelectBuilder[PgStatWalViewFields, PgStatWalViewRow]
  def selectAll(implicit c: Connection): List[PgStatWalViewRow]
}
