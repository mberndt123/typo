/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_file_settings

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgFileSettingsViewRepo {
  def select: SelectBuilder[PgFileSettingsViewFields, PgFileSettingsViewRow]
  def selectAll(implicit c: Connection): List[PgFileSettingsViewRow]
}
