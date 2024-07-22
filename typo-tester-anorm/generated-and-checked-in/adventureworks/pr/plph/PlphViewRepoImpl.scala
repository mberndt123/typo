/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.plph;

import anorm.SqlStringInterpolation;
import java.sql.Connection;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class PlphViewRepoImpl extends PlphViewRepo {
  def select: SelectBuilder[PlphViewFields, PlphViewRow] = SelectBuilderSql("pr.plph", PlphViewFields.structure, PlphViewRow.rowParser)
  def selectAll(implicit c: Connection): List[PlphViewRow] = {
    SQL"""select "id", "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
          from pr.plph
       """.as(PlphViewRow.rowParser(1).*)
  }
}