/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.sr

import java.sql.Connection
import typo.dsl.SelectBuilder

trait SrViewRepo {
  def select: SelectBuilder[SrViewFields, SrViewRow]
  def selectAll(implicit c: Connection): List[SrViewRow]
}
