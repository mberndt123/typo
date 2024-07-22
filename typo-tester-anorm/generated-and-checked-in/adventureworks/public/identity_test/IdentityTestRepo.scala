/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public.identity_test;

import java.sql.Connection;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;

trait IdentityTestRepo {
  def delete: DeleteBuilder[IdentityTestFields, IdentityTestRow]
  def deleteById(name: IdentityTestId)(implicit c: Connection): Boolean
  def deleteByIds(names: Array[IdentityTestId])(implicit c: Connection): Int
  def insert(unsaved: IdentityTestRow)(implicit c: Connection): IdentityTestRow
  def insert(unsaved: IdentityTestRowUnsaved)(implicit c: Connection): IdentityTestRow
  def insertStreaming(unsaved: Iterator[IdentityTestRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[IdentityTestRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[IdentityTestFields, IdentityTestRow]
  def selectAll(implicit c: Connection): List[IdentityTestRow]
  def selectById(name: IdentityTestId)(implicit c: Connection): Option[IdentityTestRow]
  def selectByIds(names: Array[IdentityTestId])(implicit c: Connection): List[IdentityTestRow]
  def selectByIdsTracked(names: Array[IdentityTestId])(implicit c: Connection): Map[IdentityTestId, IdentityTestRow]
  def update: UpdateBuilder[IdentityTestFields, IdentityTestRow]
  def update(row: IdentityTestRow)(implicit c: Connection): Boolean
  def upsert(unsaved: IdentityTestRow)(implicit c: Connection): IdentityTestRow
  def upsertBatch(unsaved: Iterable[IdentityTestRow])(implicit c: Connection): List[IdentityTestRow]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[IdentityTestRow], batchSize: Int = 10000)(implicit c: Connection): Int
}