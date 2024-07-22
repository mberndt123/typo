/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.i

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait IViewRepo {
  def select: SelectBuilder[IViewFields, IViewRow]
  def selectAll: ZStream[ZConnection, Throwable, IViewRow]
}
