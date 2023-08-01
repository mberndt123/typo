/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_user_sequences

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatioUserSequencesViewRepoImpl extends PgStatioUserSequencesViewRepo {
  override def select: SelectBuilder[PgStatioUserSequencesViewFields, PgStatioUserSequencesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_statio_user_sequences", PgStatioUserSequencesViewFields, PgStatioUserSequencesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatioUserSequencesViewRow] = {
    sql"select relid, schemaname, relname, blks_read, blks_hit from pg_catalog.pg_statio_user_sequences".query(PgStatioUserSequencesViewRow.read).stream
  }
}
