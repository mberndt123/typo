/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package be

import java.sql.Connection
import typo.dsl.SelectBuilder

trait BeViewRepo {
  def select: SelectBuilder[BeViewFields, BeViewRow]
  def selectAll(implicit c: Connection): List[BeViewRow]
}
