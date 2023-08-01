/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_backend_memory_contexts

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgBackendMemoryContextsViewRepoImpl extends PgBackendMemoryContextsViewRepo {
  override def select: SelectBuilder[PgBackendMemoryContextsViewFields, PgBackendMemoryContextsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_backend_memory_contexts", PgBackendMemoryContextsViewFields, PgBackendMemoryContextsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgBackendMemoryContextsViewRow] = {
    SQL"""select "name", ident, parent, "level", total_bytes, total_nblocks, free_bytes, free_chunks, used_bytes
          from pg_catalog.pg_backend_memory_contexts
       """.as(PgBackendMemoryContextsViewRow.rowParser(1).*)
  }
}
