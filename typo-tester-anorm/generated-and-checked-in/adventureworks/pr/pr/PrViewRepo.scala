/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pr;

import java.sql.Connection;
import typo.dsl.SelectBuilder;

trait PrViewRepo {
  def select: SelectBuilder[PrViewFields, PrViewRow]
  def selectAll(implicit c: Connection): List[PrViewRow]
}