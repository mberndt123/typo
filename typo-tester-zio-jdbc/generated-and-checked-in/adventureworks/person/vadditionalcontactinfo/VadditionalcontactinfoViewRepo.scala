/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.vadditionalcontactinfo;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait VadditionalcontactinfoViewRepo {
  def select: SelectBuilder[VadditionalcontactinfoViewFields, VadditionalcontactinfoViewRow]
  def selectAll: ZStream[ZConnection, Throwable, VadditionalcontactinfoViewRow]
}