/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_language

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgLanguageRepo {
  def delete(oid: PgLanguageId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgLanguageFields, PgLanguageRow]
  def insert(unsaved: PgLanguageRow): ConnectionIO[PgLanguageRow]
  def select: SelectBuilder[PgLanguageFields, PgLanguageRow]
  def selectAll: Stream[ConnectionIO, PgLanguageRow]
  def selectById(oid: PgLanguageId): ConnectionIO[Option[PgLanguageRow]]
  def selectByIds(oids: Array[PgLanguageId]): Stream[ConnectionIO, PgLanguageRow]
  def update(row: PgLanguageRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgLanguageFields, PgLanguageRow]
  def upsert(unsaved: PgLanguageRow): ConnectionIO[PgLanguageRow]
}
