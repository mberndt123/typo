/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pu.v;

import java.sql.Connection;
import typo.dsl.SelectBuilder;

trait VViewRepo {
  def select: SelectBuilder[VViewFields, VViewRow]
  def selectAll(implicit c: Connection): List[VViewRow]
}