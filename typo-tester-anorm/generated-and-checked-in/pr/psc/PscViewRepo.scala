/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package psc

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PscViewRepo {
  def select: SelectBuilder[PscViewFields, PscViewRow]
  def selectAll(implicit c: Connection): List[PscViewRow]
}
