/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.cc;

import java.sql.Connection;
import typo.dsl.SelectBuilder;

trait CcViewRepo {
  def select: SelectBuilder[CcViewFields, CcViewRow]
  def selectAll(implicit c: Connection): List[CcViewRow]
}