/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_tables

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait ForeignTablesViewRepo {
  def select: SelectBuilder[ForeignTablesViewFields, ForeignTablesViewRow]
  def selectAll: Stream[ConnectionIO, ForeignTablesViewRow]
}
