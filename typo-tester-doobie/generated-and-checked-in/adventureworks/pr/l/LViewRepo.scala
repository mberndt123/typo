/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.l;

import doobie.free.connection.ConnectionIO;
import fs2.Stream;
import typo.dsl.SelectBuilder;

trait LViewRepo {
  def select: SelectBuilder[LViewFields, LViewRow]
  def selectAll: Stream[ConnectionIO, LViewRow]
}