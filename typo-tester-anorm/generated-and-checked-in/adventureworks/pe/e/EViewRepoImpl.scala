/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.e;

import anorm.SqlStringInterpolation;
import java.sql.Connection;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class EViewRepoImpl extends EViewRepo {
  def select: SelectBuilder[EViewFields, EViewRow] = SelectBuilderSql("pe.e", EViewFields.structure, EViewRow.rowParser)
  def selectAll(implicit c: Connection): List[EViewRow] = {
    SQL"""select "id", "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text
          from pe.e
       """.as(EViewRow.rowParser(1).*)
  }
}