/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.p

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PViewRepo {
  def select: SelectBuilder[PViewFields, PViewRow]
  def selectAll(implicit c: Connection): List[PViewRow]
}
