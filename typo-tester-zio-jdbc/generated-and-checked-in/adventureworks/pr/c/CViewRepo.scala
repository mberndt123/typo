/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.c;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait CViewRepo {
  def select: SelectBuilder[CViewFields, CViewRow]
  def selectAll: ZStream[ZConnection, Throwable, CViewRow]
}