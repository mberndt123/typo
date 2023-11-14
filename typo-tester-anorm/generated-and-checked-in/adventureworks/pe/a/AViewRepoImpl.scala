/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package a

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class AViewRepoImpl extends AViewRepo {
  override def select: SelectBuilder[AViewFields, AViewRow] = {
    SelectBuilderSql("pe.a", AViewFields, AViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[AViewRow] = {
    SQL"""select "id", "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text
          from pe.a
       """.as(AViewRow.rowParser(1).*)
  }
}
