/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_options

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object ColumnOptionsViewRepoImpl extends ColumnOptionsViewRepo {
  override def select: SelectBuilder[ColumnOptionsViewFields, ColumnOptionsViewRow] = {
    SelectBuilderSql("information_schema.column_options", ColumnOptionsViewFields, ColumnOptionsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ColumnOptionsViewRow] = {
    SQL"""select "table_catalog", "table_schema", "table_name", "column_name", "option_name", "option_value"
          from information_schema.column_options
       """.as(ColumnOptionsViewRow.rowParser(1).*)
  }
}
