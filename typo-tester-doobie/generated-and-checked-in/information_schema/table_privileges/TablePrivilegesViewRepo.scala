/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package table_privileges

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait TablePrivilegesViewRepo {
  def select: SelectBuilder[TablePrivilegesViewFields, TablePrivilegesViewRow]
  def selectAll: Stream[ConnectionIO, TablePrivilegesViewRow]
}
