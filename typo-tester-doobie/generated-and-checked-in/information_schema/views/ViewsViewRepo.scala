/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package views

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait ViewsViewRepo {
  def select: SelectBuilder[ViewsViewFields, ViewsViewRow]
  def selectAll: Stream[ConnectionIO, ViewsViewRow]
}
