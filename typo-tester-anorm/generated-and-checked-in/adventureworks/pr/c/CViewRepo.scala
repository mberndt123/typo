/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.c;

import java.sql.Connection;
import typo.dsl.SelectBuilder;

trait CViewRepo {
  def select: SelectBuilder[CViewFields, CViewRow]
  def selectAll(implicit c: Connection): List[CViewRow]
}