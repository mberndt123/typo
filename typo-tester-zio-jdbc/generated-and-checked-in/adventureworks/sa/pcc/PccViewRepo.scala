/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.pcc;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait PccViewRepo {
  def select: SelectBuilder[PccViewFields, PccViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PccViewRow]
}