/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pp

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PpViewRepo {
  def select: SelectBuilder[PpViewFields, PpViewRow]
  def selectAll(implicit c: Connection): List[PpViewRow]
}
