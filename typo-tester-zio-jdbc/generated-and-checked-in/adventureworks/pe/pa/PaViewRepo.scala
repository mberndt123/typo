/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.pa

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PaViewRepo {
  def select: SelectBuilder[PaViewFields, PaViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PaViewRow]
}
