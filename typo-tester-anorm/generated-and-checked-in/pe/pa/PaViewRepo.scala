/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PaViewRepo {
  def select: SelectBuilder[PaViewFields, PaViewRow]
  def selectAll(implicit c: Connection): List[PaViewRow]
}
