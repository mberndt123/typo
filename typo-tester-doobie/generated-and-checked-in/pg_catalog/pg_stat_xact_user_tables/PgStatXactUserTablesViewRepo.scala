/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_user_tables

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgStatXactUserTablesViewRepo {
  def select: SelectBuilder[PgStatXactUserTablesViewFields, PgStatXactUserTablesViewRow]
  def selectAll: Stream[ConnectionIO, PgStatXactUserTablesViewRow]
}
