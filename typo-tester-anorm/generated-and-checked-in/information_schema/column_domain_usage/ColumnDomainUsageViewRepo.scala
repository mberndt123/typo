/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_domain_usage

import java.sql.Connection
import typo.dsl.SelectBuilder

trait ColumnDomainUsageViewRepo {
  def select: SelectBuilder[ColumnDomainUsageViewFields, ColumnDomainUsageViewRow]
  def selectAll(implicit c: Connection): List[ColumnDomainUsageViewRow]
}
