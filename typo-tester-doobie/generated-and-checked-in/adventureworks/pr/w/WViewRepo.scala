/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.w;

import doobie.free.connection.ConnectionIO;
import fs2.Stream;
import typo.dsl.SelectBuilder;

trait WViewRepo {
  def select: SelectBuilder[WViewFields, WViewRow]
  def selectAll: Stream[ConnectionIO, WViewRow]
}