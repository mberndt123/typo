/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.at;

import typo.dsl.SelectBuilder;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait AtViewRepo {
  def select: SelectBuilder[AtViewFields, AtViewRow]
  def selectAll: ZStream[ZConnection, Throwable, AtViewRow]
}