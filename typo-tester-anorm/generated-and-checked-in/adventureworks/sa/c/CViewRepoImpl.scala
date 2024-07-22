/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.c;

import anorm.SqlStringInterpolation;
import java.sql.Connection;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class CViewRepoImpl extends CViewRepo {
  def select: SelectBuilder[CViewFields, CViewRow] = SelectBuilderSql("sa.c", CViewFields.structure, CViewRow.rowParser)
  def selectAll(implicit c: Connection): List[CViewRow] = {
    SQL"""select "id", "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text
          from sa.c
       """.as(CViewRow.rowParser(1).*)
  }
}