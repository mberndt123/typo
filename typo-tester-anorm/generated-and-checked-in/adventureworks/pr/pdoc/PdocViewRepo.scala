/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pdoc;

import java.sql.Connection;
import typo.dsl.SelectBuilder;

trait PdocViewRepo {
  def select: SelectBuilder[PdocViewFields, PdocViewRow]
  def selectAll(implicit c: Connection): List[PdocViewRow]
}