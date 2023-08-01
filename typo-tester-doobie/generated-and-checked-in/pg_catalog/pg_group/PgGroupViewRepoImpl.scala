/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_group

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgGroupViewRepoImpl extends PgGroupViewRepo {
  override def select: SelectBuilder[PgGroupViewFields, PgGroupViewRow] = {
    SelectBuilderSql("pg_catalog.pg_group", PgGroupViewFields, PgGroupViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgGroupViewRow] = {
    sql"select groname, grosysid, grolist from pg_catalog.pg_group".query(PgGroupViewRow.read).stream
  }
}
