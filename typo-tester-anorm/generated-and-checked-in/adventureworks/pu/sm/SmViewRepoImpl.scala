/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package sm

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object SmViewRepoImpl extends SmViewRepo {
  override def select: SelectBuilder[SmViewFields, SmViewRow] = {
    SelectBuilderSql("pu.sm", SmViewFields, SmViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SmViewRow] = {
    SQL"""select "id", "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text
          from pu.sm
       """.as(SmViewRow.rowParser(1).*)
  }
}
