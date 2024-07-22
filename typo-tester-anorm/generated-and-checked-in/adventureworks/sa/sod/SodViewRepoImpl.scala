/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sod

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SodViewRepoImpl extends SodViewRepo {
  override def select: SelectBuilder[SodViewFields, SodViewRow] = {
    SelectBuilderSql("sa.sod", SodViewFields.structure, SodViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SodViewRow] = {
    SQL"""select "id", "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text
          from sa.sod
       """.as(SodViewRow.rowParser(1).*)
  }
}
