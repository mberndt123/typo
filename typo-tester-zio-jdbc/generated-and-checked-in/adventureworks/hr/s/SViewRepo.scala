/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.s

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait SViewRepo {
  def select: SelectBuilder[SViewFields, SViewRow]
  def selectAll: ZStream[ZConnection, Throwable, SViewRow]
}
