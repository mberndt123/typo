/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sp;

import doobie.free.connection.ConnectionIO;
import doobie.syntax.string.toSqlInterpolator;
import fs2.Stream;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class SpViewRepoImpl extends SpViewRepo {
  def select: SelectBuilder[SpViewFields, SpViewRow] = SelectBuilderSql("sa.sp", SpViewFields.structure, SpViewRow.read)
  def selectAll: Stream[ConnectionIO, SpViewRow] = sql"""select "id", "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text from sa.sp""".query(using SpViewRow.read).stream
}