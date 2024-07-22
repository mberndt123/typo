/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pmpdc

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PmpdcViewRepo {
  def select: SelectBuilder[PmpdcViewFields, PmpdcViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PmpdcViewRow]
}
