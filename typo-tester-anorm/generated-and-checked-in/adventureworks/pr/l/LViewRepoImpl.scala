/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.l

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class LViewRepoImpl extends LViewRepo {
  override def select: SelectBuilder[LViewFields, LViewRow] = {
    SelectBuilderSql("pr.l", LViewFields.structure, LViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[LViewRow] = {
    SQL"""select "id", "locationid", "name", "costrate", "availability", "modifieddate"::text
          from pr.l
       """.as(LViewRow.rowParser(1).*)
  }
}
