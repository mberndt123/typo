/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.e;

import doobie.free.connection.ConnectionIO;
import doobie.syntax.string.toSqlInterpolator;
import fs2.Stream;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class EViewRepoImpl extends EViewRepo {
  def select: SelectBuilder[EViewFields, EViewRow] = SelectBuilderSql("pe.e", EViewFields.structure, EViewRow.read)
  def selectAll: Stream[ConnectionIO, EViewRow] = sql"""select "id", "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text from pe.e""".query(using EViewRow.read).stream
}