/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package wr

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class WrViewRepoImpl extends WrViewRepo {
  override def select: SelectBuilder[WrViewFields, WrViewRow] = {
    SelectBuilderSql("pr.wr", WrViewFields, WrViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[WrViewRow] = {
    SQL"""select "id", "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text
          from pr.wr
       """.as(WrViewRow.rowParser(1).*)
  }
}
