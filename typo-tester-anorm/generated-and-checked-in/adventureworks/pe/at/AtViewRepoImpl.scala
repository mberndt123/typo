/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.at

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class AtViewRepoImpl extends AtViewRepo {
  override def select: SelectBuilder[AtViewFields, AtViewRow] = {
    SelectBuilderSql("pe.at", AtViewFields.structure, AtViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[AtViewRow] = {
    SQL"""select "id", "addresstypeid", "name", "rowguid", "modifieddate"::text
          from pe.at
       """.as(AtViewRow.rowParser(1).*)
  }
}
