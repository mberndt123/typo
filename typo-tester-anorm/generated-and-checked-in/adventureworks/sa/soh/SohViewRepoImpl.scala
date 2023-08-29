/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package soh

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object SohViewRepoImpl extends SohViewRepo {
  override def select: SelectBuilder[SohViewFields, SohViewRow] = {
    SelectBuilderSql("sa.soh", SohViewFields, SohViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SohViewRow] = {
    SQL"""select "id", "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
          from sa.soh
       """.as(SohViewRow.rowParser(1).*)
  }
}
