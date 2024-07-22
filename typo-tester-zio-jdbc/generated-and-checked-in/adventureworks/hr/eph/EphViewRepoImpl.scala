/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.eph;

import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import zio.jdbc.ZConnection;
import zio.jdbc.sqlInterpolator;
import zio.stream.ZStream;

class EphViewRepoImpl extends EphViewRepo {
  def select: SelectBuilder[EphViewFields, EphViewRow] = SelectBuilderSql("hr.eph", EphViewFields.structure, EphViewRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, EphViewRow] = sql"""select "id", "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text from hr.eph""".query(using EphViewRow.jdbcDecoder).selectStream()
}