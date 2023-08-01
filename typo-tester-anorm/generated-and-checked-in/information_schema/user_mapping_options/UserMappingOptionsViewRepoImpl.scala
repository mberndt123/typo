/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_mapping_options

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object UserMappingOptionsViewRepoImpl extends UserMappingOptionsViewRepo {
  override def select: SelectBuilder[UserMappingOptionsViewFields, UserMappingOptionsViewRow] = {
    SelectBuilderSql("information_schema.user_mapping_options", UserMappingOptionsViewFields, UserMappingOptionsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[UserMappingOptionsViewRow] = {
    SQL"""select authorization_identifier, foreign_server_catalog, foreign_server_name, option_name, option_value
          from information_schema.user_mapping_options
       """.as(UserMappingOptionsViewRow.rowParser(1).*)
  }
}
