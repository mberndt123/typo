/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_all_tables

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgStatioAllTablesViewRepo {
  def select: SelectBuilder[PgStatioAllTablesViewFields, PgStatioAllTablesViewRow]
  def selectAll: Stream[ConnectionIO, PgStatioAllTablesViewRow]
}
