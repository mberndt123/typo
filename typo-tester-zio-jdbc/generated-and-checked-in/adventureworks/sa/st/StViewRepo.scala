/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.st;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait StViewRepo {
  def select: SelectBuilder[StViewFields, StViewRow]
  def selectAll: ZStream[ZConnection, Throwable, StViewRow]
}