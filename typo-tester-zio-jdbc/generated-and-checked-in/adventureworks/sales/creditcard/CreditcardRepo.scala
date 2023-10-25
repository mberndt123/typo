/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.userdefined.CustomCreditcardId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.JdbcEncoder
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait CreditcardRepo {
  def delete(creditcardid: /* user-picked */ CustomCreditcardId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[CreditcardFields, CreditcardRow]
  def insert(unsaved: CreditcardRow): ZIO[ZConnection, Throwable, CreditcardRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CreditcardRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: CreditcardRowUnsaved): ZIO[ZConnection, Throwable, CreditcardRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CreditcardRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[CreditcardFields, CreditcardRow]
  def selectAll: ZStream[ZConnection, Throwable, CreditcardRow]
  def selectById(creditcardid: /* user-picked */ CustomCreditcardId): ZIO[ZConnection, Throwable, Option[CreditcardRow]]
  def selectByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit encoder: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZStream[ZConnection, Throwable, CreditcardRow]
  def update(row: CreditcardRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[CreditcardFields, CreditcardRow]
  def upsert(unsaved: CreditcardRow): ZIO[ZConnection, Throwable, UpdateResult[CreditcardRow]]
}
