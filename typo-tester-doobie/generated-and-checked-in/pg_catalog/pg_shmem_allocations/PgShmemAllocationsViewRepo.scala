/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shmem_allocations

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgShmemAllocationsViewRepo {
  def select: SelectBuilder[PgShmemAllocationsViewFields, PgShmemAllocationsViewRow]
  def selectAll: Stream[ConnectionIO, PgShmemAllocationsViewRow]
}
