/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package th

import java.sql.Connection
import typo.dsl.SelectBuilder

trait ThViewRepo {
  def select: SelectBuilder[ThViewFields, ThViewRow]
  def selectAll(implicit c: Connection): List[ThViewRow]
}
