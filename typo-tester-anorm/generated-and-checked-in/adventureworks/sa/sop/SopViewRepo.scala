/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sop

import java.sql.Connection
import typo.dsl.SelectBuilder

trait SopViewRepo {
  def select: SelectBuilder[SopViewFields, SopViewRow]
  def selectAll(implicit c: Connection): List[SopViewRow]
}
