/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sp

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SpViewRepoImpl extends SpViewRepo {
  override def select: SelectBuilder[SpViewFields, SpViewRow] = {
    SelectBuilderSql("sa.sp", SpViewFields.structure, SpViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SpViewRow] = {
    SQL"""select "id", "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
          from sa.sp
       """.as(SpViewRow.rowParser(1).*)
  }
}
