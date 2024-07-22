/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sp

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait SpViewRepo {
  def select: SelectBuilder[SpViewFields, SpViewRow]
  def selectAll: ZStream[ZConnection, Throwable, SpViewRow]
}
