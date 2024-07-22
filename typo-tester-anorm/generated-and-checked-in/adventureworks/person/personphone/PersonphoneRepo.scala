/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.personphone

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PersonphoneRepo {
  def delete: DeleteBuilder[PersonphoneFields, PersonphoneRow]
  def deleteById(compositeId: PersonphoneId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[PersonphoneId])(implicit c: Connection): Int
  def insert(unsaved: PersonphoneRow)(implicit c: Connection): PersonphoneRow
  def insert(unsaved: PersonphoneRowUnsaved)(implicit c: Connection): PersonphoneRow
  def insertStreaming(unsaved: Iterator[PersonphoneRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[PersonphoneRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[PersonphoneFields, PersonphoneRow]
  def selectAll(implicit c: Connection): List[PersonphoneRow]
  def selectById(compositeId: PersonphoneId)(implicit c: Connection): Option[PersonphoneRow]
  def selectByIds(compositeIds: Array[PersonphoneId])(implicit c: Connection): List[PersonphoneRow]
  def selectByIdsTracked(compositeIds: Array[PersonphoneId])(implicit c: Connection): Map[PersonphoneId, PersonphoneRow]
  def update: UpdateBuilder[PersonphoneFields, PersonphoneRow]
  def update(row: PersonphoneRow)(implicit c: Connection): Boolean
  def upsert(unsaved: PersonphoneRow)(implicit c: Connection): PersonphoneRow
  def upsertBatch(unsaved: Iterable[PersonphoneRow])(implicit c: Connection): List[PersonphoneRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[PersonphoneRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
