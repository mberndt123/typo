/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartmenthistory

import java.sql.Connection
import typo.dsl.SelectBuilder

trait VemployeedepartmenthistoryViewRepo {
  def select: SelectBuilder[VemployeedepartmenthistoryViewFields, VemployeedepartmenthistoryViewRow]
  def selectAll(implicit c: Connection): List[VemployeedepartmenthistoryViewRow]
}
