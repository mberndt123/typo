/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_indexes

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgIndexesViewRepoImpl extends PgIndexesViewRepo {
  override def select: SelectBuilder[PgIndexesViewFields, PgIndexesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_indexes", PgIndexesViewFields, PgIndexesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgIndexesViewRow] = {
    sql"""select "schemaname", "tablename", "indexname", "tablespace", "indexdef" from pg_catalog.pg_indexes""".query(PgIndexesViewRow.read).stream
  }
}
