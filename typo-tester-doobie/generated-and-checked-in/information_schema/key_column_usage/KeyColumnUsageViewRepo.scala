/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package key_column_usage

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait KeyColumnUsageViewRepo {
  def select: SelectBuilder[KeyColumnUsageViewFields, KeyColumnUsageViewRow]
  def selectAll: Stream[ConnectionIO, KeyColumnUsageViewRow]
}
