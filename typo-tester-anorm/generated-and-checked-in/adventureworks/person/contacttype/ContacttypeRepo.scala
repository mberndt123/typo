/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.contacttype

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ContacttypeRepo {
  def delete: DeleteBuilder[ContacttypeFields, ContacttypeRow]
  def deleteById(contacttypeid: ContacttypeId)(implicit c: Connection): Boolean
  def deleteByIds(contacttypeids: Array[ContacttypeId])(implicit c: Connection): Int
  def insert(unsaved: ContacttypeRow)(implicit c: Connection): ContacttypeRow
  def insert(unsaved: ContacttypeRowUnsaved)(implicit c: Connection): ContacttypeRow
  def insertStreaming(unsaved: Iterator[ContacttypeRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ContacttypeRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[ContacttypeFields, ContacttypeRow]
  def selectAll(implicit c: Connection): List[ContacttypeRow]
  def selectById(contacttypeid: ContacttypeId)(implicit c: Connection): Option[ContacttypeRow]
  def selectByIds(contacttypeids: Array[ContacttypeId])(implicit c: Connection): List[ContacttypeRow]
  def selectByIdsTracked(contacttypeids: Array[ContacttypeId])(implicit c: Connection): Map[ContacttypeId, ContacttypeRow]
  def update: UpdateBuilder[ContacttypeFields, ContacttypeRow]
  def update(row: ContacttypeRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ContacttypeRow)(implicit c: Connection): ContacttypeRow
  def upsertBatch(unsaved: Iterable[ContacttypeRow])(implicit c: Connection): List[ContacttypeRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ContacttypeRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
