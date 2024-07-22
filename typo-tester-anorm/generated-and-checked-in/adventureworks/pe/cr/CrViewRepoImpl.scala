/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.cr

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class CrViewRepoImpl extends CrViewRepo {
  override def select: SelectBuilder[CrViewFields, CrViewRow] = {
    SelectBuilderSql("pe.cr", CrViewFields.structure, CrViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CrViewRow] = {
    SQL"""select "countryregioncode", "name", "modifieddate"::text
          from pe.cr
       """.as(CrViewRow.rowParser(1).*)
  }
}
