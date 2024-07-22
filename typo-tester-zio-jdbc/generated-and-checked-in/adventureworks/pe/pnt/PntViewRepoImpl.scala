/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.pnt;

import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import zio.jdbc.ZConnection;
import zio.jdbc.sqlInterpolator;
import zio.stream.ZStream;

class PntViewRepoImpl extends PntViewRepo {
  def select: SelectBuilder[PntViewFields, PntViewRow] = SelectBuilderSql("pe.pnt", PntViewFields.structure, PntViewRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, PntViewRow] = sql"""select "id", "phonenumbertypeid", "name", "modifieddate"::text from pe.pnt""".query(using PntViewRow.jdbcDecoder).selectStream()
}