/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package ppp

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PppViewRepoImpl extends PppViewRepo {
  override def select: SelectBuilder[PppViewFields, PppViewRow] = {
    SelectBuilderSql("pr.ppp", PppViewFields, PppViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PppViewRow] = {
    SQL"""select "productid", "productphotoid", "primary", "modifieddate"::text
          from pr.ppp
       """.as(PppViewRow.rowParser(1).*)
  }
}
