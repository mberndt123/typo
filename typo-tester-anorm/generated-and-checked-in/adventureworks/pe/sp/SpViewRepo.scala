/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.sp

import java.sql.Connection
import typo.dsl.SelectBuilder

trait SpViewRepo {
  def select: SelectBuilder[SpViewFields, SpViewRow]
  def selectAll(implicit c: Connection): List[SpViewRow]
}
