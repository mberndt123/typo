/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.psc

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PscViewRepo {
  def select: SelectBuilder[PscViewFields, PscViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PscViewRow]
}
