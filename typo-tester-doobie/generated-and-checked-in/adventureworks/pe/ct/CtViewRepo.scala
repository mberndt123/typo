/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.ct;

import doobie.free.connection.ConnectionIO;
import fs2.Stream;
import typo.dsl.SelectBuilder;

trait CtViewRepo {
  def select: SelectBuilder[CtViewFields, CtViewRow]
  def selectAll: Stream[ConnectionIO, CtViewRow]
}