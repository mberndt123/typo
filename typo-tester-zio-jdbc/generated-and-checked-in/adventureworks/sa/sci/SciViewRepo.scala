/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sci;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait SciViewRepo {
  def select: SelectBuilder[SciViewFields, SciViewRow]
  def selectAll: ZStream[ZConnection, Throwable, SciViewRow]
}