/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.jc;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait JcViewRepo {
  def select: SelectBuilder[JcViewFields, JcViewRow]
  def selectAll: ZStream[ZConnection, Throwable, JcViewRow]
}