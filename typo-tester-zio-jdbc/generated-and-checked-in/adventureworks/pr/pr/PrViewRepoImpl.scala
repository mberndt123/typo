/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pr;

import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import zio.jdbc.ZConnection;
import zio.jdbc.sqlInterpolator;
import zio.stream.ZStream;

class PrViewRepoImpl extends PrViewRepo {
  def select: SelectBuilder[PrViewFields, PrViewRow] = SelectBuilderSql("pr.pr", PrViewFields.structure, PrViewRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, PrViewRow] = sql"""select "id", "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text from pr.pr""".query(using PrViewRow.jdbcDecoder).selectStream()
}