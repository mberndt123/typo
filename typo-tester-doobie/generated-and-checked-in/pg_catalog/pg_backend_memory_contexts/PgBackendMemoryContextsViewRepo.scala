/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_backend_memory_contexts

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgBackendMemoryContextsViewRepo {
  def select: SelectBuilder[PgBackendMemoryContextsViewFields, PgBackendMemoryContextsViewRow]
  def selectAll: Stream[ConnectionIO, PgBackendMemoryContextsViewRow]
}
