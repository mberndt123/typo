/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithcontacts

import java.sql.Connection
import typo.dsl.SelectBuilder

trait VstorewithcontactsViewRepo {
  def select: SelectBuilder[VstorewithcontactsViewFields, VstorewithcontactsViewRow]
  def selectAll(implicit c: Connection): List[VstorewithcontactsViewRow]
}
