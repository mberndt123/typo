/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pc;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait PcViewRepo {
  def select: SelectBuilder[PcViewFields, PcViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PcViewRow]
}