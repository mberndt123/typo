/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.th;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait ThViewRepo {
  def select: SelectBuilder[ThViewFields, ThViewRow]
  def selectAll: ZStream[ZConnection, Throwable, ThViewRow]
}