/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.pnt

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PntViewRepo {
  def select: SelectBuilder[PntViewFields, PntViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PntViewRow]
}
