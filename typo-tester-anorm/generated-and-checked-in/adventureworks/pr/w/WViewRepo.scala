/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.w;

import java.sql.Connection;
import typo.dsl.SelectBuilder;

trait WViewRepo {
  def select: SelectBuilder[WViewFields, WViewRow]
  def selectAll(implicit c: Connection): List[WViewRow]
}