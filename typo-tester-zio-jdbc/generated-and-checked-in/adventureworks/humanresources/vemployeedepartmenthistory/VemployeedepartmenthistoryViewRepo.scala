/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.vemployeedepartmenthistory;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait VemployeedepartmenthistoryViewRepo {
  def select: SelectBuilder[VemployeedepartmenthistoryViewFields, VemployeedepartmenthistoryViewRow]
  def selectAll: ZStream[ZConnection, Throwable, VemployeedepartmenthistoryViewRow]
}