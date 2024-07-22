/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.creditcard;

import adventureworks.userdefined.CustomCreditcardId;
import java.sql.Connection;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;

trait CreditcardRepo {
  def delete: DeleteBuilder[CreditcardFields, CreditcardRow]
  def deleteById(creditcardid: /* user-picked */ CustomCreditcardId)(implicit c: Connection): Boolean
  def deleteByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit c: Connection): Int
  def insert(unsaved: CreditcardRow)(implicit c: Connection): CreditcardRow
  def insert(unsaved: CreditcardRowUnsaved)(implicit c: Connection): CreditcardRow
  def insertStreaming(unsaved: Iterator[CreditcardRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[CreditcardRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[CreditcardFields, CreditcardRow]
  def selectAll(implicit c: Connection): List[CreditcardRow]
  def selectById(creditcardid: /* user-picked */ CustomCreditcardId)(implicit c: Connection): Option[CreditcardRow]
  def selectByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit c: Connection): List[CreditcardRow]
  def selectByIdsTracked(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit c: Connection): Map[/* user-picked */ CustomCreditcardId, CreditcardRow]
  def update: UpdateBuilder[CreditcardFields, CreditcardRow]
  def update(row: CreditcardRow)(implicit c: Connection): Boolean
  def upsert(unsaved: CreditcardRow)(implicit c: Connection): CreditcardRow
  def upsertBatch(unsaved: Iterable[CreditcardRow])(implicit c: Connection): List[CreditcardRow]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[CreditcardRow], batchSize: Int = 10000)(implicit c: Connection): Int
}