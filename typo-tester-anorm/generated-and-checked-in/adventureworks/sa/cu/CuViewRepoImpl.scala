/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.cu;

import anorm.SqlStringInterpolation;
import java.sql.Connection;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class CuViewRepoImpl extends CuViewRepo {
  def select: SelectBuilder[CuViewFields, CuViewRow] = SelectBuilderSql("sa.cu", CuViewFields.structure, CuViewRow.rowParser)
  def selectAll(implicit c: Connection): List[CuViewRow] = {
    SQL"""select "id", "currencycode", "name", "modifieddate"::text
          from sa.cu
       """.as(CuViewRow.rowParser(1).*)
  }
}