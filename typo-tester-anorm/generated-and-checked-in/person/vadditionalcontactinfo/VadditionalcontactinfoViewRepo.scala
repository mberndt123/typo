/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package vadditionalcontactinfo

import java.sql.Connection
import typo.dsl.SelectBuilder

trait VadditionalcontactinfoViewRepo {
  def select: SelectBuilder[VadditionalcontactinfoViewFields, VadditionalcontactinfoViewRow]
  def selectAll(implicit c: Connection): List[VadditionalcontactinfoViewRow]
}
