/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateemployment

import java.sql.Connection
import typo.dsl.SelectBuilder

trait VjobcandidateemploymentViewRepo {
  def select: SelectBuilder[VjobcandidateemploymentViewFields, VjobcandidateemploymentViewRow]
  def selectAll(implicit c: Connection): List[VjobcandidateemploymentViewRow]
}
