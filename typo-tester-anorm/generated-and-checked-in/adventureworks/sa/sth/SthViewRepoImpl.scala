/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sth

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SthViewRepoImpl extends SthViewRepo {
  override def select: SelectBuilder[SthViewFields, SthViewRow] = {
    SelectBuilderSql("sa.sth", SthViewFields, SthViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SthViewRow] = {
    SQL"""select "id", "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
          from sa.sth
       """.as(SthViewRow.rowParser(1).*)
  }
}
