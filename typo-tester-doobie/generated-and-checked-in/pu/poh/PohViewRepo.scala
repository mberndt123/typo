/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package poh

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PohViewRepo {
  def select: SelectBuilder[PohViewFields, PohViewRow]
  def selectAll: Stream[ConnectionIO, PohViewRow]
}
