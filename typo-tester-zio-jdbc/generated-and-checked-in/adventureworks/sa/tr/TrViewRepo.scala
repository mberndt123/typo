/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.tr;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait TrViewRepo {
  def select: SelectBuilder[TrViewFields, TrViewRow]
  def selectAll: ZStream[ZConnection, Throwable, TrViewRow]
}