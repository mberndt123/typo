/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SpViewRepoImpl extends SpViewRepo {
  override def select: SelectBuilder[SpViewFields, SpViewRow] = {
    SelectBuilderSql("pe.sp", SpViewFields, SpViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SpViewRow] = {
    sql"""select "id", "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate"::text from pe.sp""".query(SpViewRow.read).stream
  }
}
