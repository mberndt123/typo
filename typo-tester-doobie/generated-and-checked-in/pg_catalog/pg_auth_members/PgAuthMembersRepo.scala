/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_auth_members

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgAuthMembersRepo {
  def delete(compositeId: PgAuthMembersId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgAuthMembersFields, PgAuthMembersRow]
  def insert(unsaved: PgAuthMembersRow): ConnectionIO[PgAuthMembersRow]
  def select: SelectBuilder[PgAuthMembersFields, PgAuthMembersRow]
  def selectAll: Stream[ConnectionIO, PgAuthMembersRow]
  def selectById(compositeId: PgAuthMembersId): ConnectionIO[Option[PgAuthMembersRow]]
  def update(row: PgAuthMembersRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgAuthMembersFields, PgAuthMembersRow]
  def upsert(unsaved: PgAuthMembersRow): ConnectionIO[PgAuthMembersRow]
}
