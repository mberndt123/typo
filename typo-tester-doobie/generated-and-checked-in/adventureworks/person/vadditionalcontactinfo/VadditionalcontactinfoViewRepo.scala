/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.vadditionalcontactinfo;

import doobie.free.connection.ConnectionIO;
import fs2.Stream;
import typo.dsl.SelectBuilder;

trait VadditionalcontactinfoViewRepo {
  def select: SelectBuilder[VadditionalcontactinfoViewFields, VadditionalcontactinfoViewRow]
  def selectAll: Stream[ConnectionIO, VadditionalcontactinfoViewRow]
}