/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.i

import java.sql.Connection
import typo.dsl.SelectBuilder

trait IViewRepo {
  def select: SelectBuilder[IViewFields, IViewRow]
  def selectAll(implicit c: Connection): List[IViewRow]
}
