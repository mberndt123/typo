/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.bom;

import java.sql.Connection;
import typo.dsl.SelectBuilder;

trait BomViewRepo {
  def select: SelectBuilder[BomViewFields, BomViewRow]
  def selectAll(implicit c: Connection): List[BomViewRow]
}