/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployee

import java.sql.Connection
import typo.dsl.SelectBuilder

trait VemployeeViewRepo {
  def select: SelectBuilder[VemployeeViewFields, VemployeeViewRow]
  def selectAll(implicit c: Connection): List[VemployeeViewRow]
}
