/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.sr;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait SrViewRepo {
  def select: SelectBuilder[SrViewFields, SrViewRow]
  def selectAll: ZStream[ZConnection, Throwable, SrViewRow]
}