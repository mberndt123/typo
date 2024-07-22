/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.pa;

import anorm.SqlStringInterpolation;
import java.sql.Connection;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class PaViewRepoImpl extends PaViewRepo {
  def select: SelectBuilder[PaViewFields, PaViewRow] = SelectBuilderSql("pe.pa", PaViewFields.structure, PaViewRow.rowParser)
  def selectAll(implicit c: Connection): List[PaViewRow] = {
    SQL"""select "id", "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text
          from pe.pa
       """.as(PaViewRow.rowParser(1).*)
  }
}