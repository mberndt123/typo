/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.cu;

import doobie.free.connection.ConnectionIO;
import fs2.Stream;
import typo.dsl.SelectBuilder;

trait CuViewRepo {
  def select: SelectBuilder[CuViewFields, CuViewRow]
  def selectAll: Stream[ConnectionIO, CuViewRow]
}