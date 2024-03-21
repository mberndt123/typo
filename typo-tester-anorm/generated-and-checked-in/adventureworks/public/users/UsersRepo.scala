/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package users

import adventureworks.customtypes.TypoUnknownCitext
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait UsersRepo {
  def delete(userId: UsersId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[UsersFields, UsersRow]
  def insert(unsaved: UsersRow)(implicit c: Connection): UsersRow
  def insertStreaming(unsaved: Iterator[UsersRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: UsersRowUnsaved)(implicit c: Connection): UsersRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[UsersRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[UsersFields, UsersRow]
  def selectAll(implicit c: Connection): List[UsersRow]
  def selectById(userId: UsersId)(implicit c: Connection): Option[UsersRow]
  def selectByIds(userIds: Array[UsersId])(implicit c: Connection): List[UsersRow]
  def selectByUniqueEmail(email: TypoUnknownCitext)(implicit c: Connection): Option[UsersRow]
  def update(row: UsersRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[UsersFields, UsersRow]
  def upsert(unsaved: UsersRow)(implicit c: Connection): UsersRow
}
