/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_data_wrappers

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object ForeignDataWrappersViewRepoImpl extends ForeignDataWrappersViewRepo {
  override def select: SelectBuilder[ForeignDataWrappersViewFields, ForeignDataWrappersViewRow] = {
    SelectBuilderSql("information_schema.foreign_data_wrappers", ForeignDataWrappersViewFields, ForeignDataWrappersViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ForeignDataWrappersViewRow] = {
    SQL"""select foreign_data_wrapper_catalog, foreign_data_wrapper_name, authorization_identifier, library_name, foreign_data_wrapper_language
          from information_schema.foreign_data_wrappers
       """.as(ForeignDataWrappersViewRow.rowParser(1).*)
  }
}
