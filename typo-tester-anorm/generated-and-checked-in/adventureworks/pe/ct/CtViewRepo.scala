/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.ct

import java.sql.Connection
import typo.dsl.SelectBuilder

trait CtViewRepo {
  def select: SelectBuilder[CtViewFields, CtViewRow]
  def selectAll(implicit c: Connection): List[CtViewRow]
}
