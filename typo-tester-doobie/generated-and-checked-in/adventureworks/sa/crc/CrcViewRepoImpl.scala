/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.crc;

import doobie.free.connection.ConnectionIO;
import doobie.syntax.string.toSqlInterpolator;
import fs2.Stream;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;

class CrcViewRepoImpl extends CrcViewRepo {
  def select: SelectBuilder[CrcViewFields, CrcViewRow] = SelectBuilderSql("sa.crc", CrcViewFields.structure, CrcViewRow.read)
  def selectAll: Stream[ConnectionIO, CrcViewRow] = sql"""select "countryregioncode", "currencycode", "modifieddate"::text from sa.crc""".query(using CrcViewRow.read).stream
}