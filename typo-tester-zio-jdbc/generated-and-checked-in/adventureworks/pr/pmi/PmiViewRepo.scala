/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pmi;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait PmiViewRepo {
  def select: SelectBuilder[PmiViewFields, PmiViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PmiViewRow]
}