/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import java.sql.Connection
import typo.dsl.SelectBuilder

trait VstorewithaddressesViewRepo {
  def select: SelectBuilder[VstorewithaddressesViewFields, VstorewithaddressesViewRow]
  def selectAll(implicit c: Connection): List[VstorewithaddressesViewRow]
}
