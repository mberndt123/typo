/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.p

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PViewRepoImpl extends PViewRepo {
  override def select: SelectBuilder[PViewFields, PViewRow] = {
    SelectBuilderSql("pr.p", PViewFields.structure, PViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PViewRow] = {
    SQL"""select "id", "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
          from pr.p
       """.as(PViewRow.rowParser(1).*)
  }
}
