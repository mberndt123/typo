/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.c;

import doobie.free.connection.ConnectionIO;
import fs2.Stream;
import typo.dsl.SelectBuilder;

trait CViewRepo {
  def select: SelectBuilder[CViewFields, CViewRow]
  def selectAll: Stream[ConnectionIO, CViewRow]
}