/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package e

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait EViewRepo {
  def select: SelectBuilder[EViewFields, EViewRow]
  def selectAll: Stream[ConnectionIO, EViewRow]
}
