/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.spqh;

import java.sql.Connection;
import typo.dsl.SelectBuilder;

trait SpqhViewRepo {
  def select: SelectBuilder[SpqhViewFields, SpqhViewRow]
  def selectAll(implicit c: Connection): List[SpqhViewRow]
}