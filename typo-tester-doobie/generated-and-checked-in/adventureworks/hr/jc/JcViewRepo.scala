/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.jc

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait JcViewRepo {
  def select: SelectBuilder[JcViewFields, JcViewRow]
  def selectAll: Stream[ConnectionIO, JcViewRow]
}
