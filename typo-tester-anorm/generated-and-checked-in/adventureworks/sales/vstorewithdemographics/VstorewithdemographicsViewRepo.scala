/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.vstorewithdemographics;

import java.sql.Connection;
import typo.dsl.SelectBuilder;

trait VstorewithdemographicsViewRepo {
  def select: SelectBuilder[VstorewithdemographicsViewFields, VstorewithdemographicsViewRow]
  def selectAll(implicit c: Connection): List[VstorewithdemographicsViewRow]
}