/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.vsalespersonsalesbyfiscalyearsdata

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait VsalespersonsalesbyfiscalyearsdataViewRepo {
  def select: SelectBuilder[VsalespersonsalesbyfiscalyearsdataViewFields, VsalespersonsalesbyfiscalyearsdataViewRow]
  def selectAll: ZStream[ZConnection, Throwable, VsalespersonsalesbyfiscalyearsdataViewRow]
}
