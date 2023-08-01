/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object SpViewRepoImpl extends SpViewRepo {
  override def select: SelectBuilder[SpViewFields, SpViewRow] = {
    SelectBuilderSql("pe.sp", SpViewFields, SpViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SpViewRow] = {
    SQL"""select "id", stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate::text
          from pe.sp
       """.as(SpViewRow.rowParser(1).*)
  }
}
