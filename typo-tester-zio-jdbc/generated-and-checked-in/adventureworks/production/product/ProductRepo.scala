/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductRepo {
  def delete(productid: ProductId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[ProductFields, ProductRow]
  def insert(unsaved: ProductRow): ZIO[ZConnection, Throwable, ProductRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ProductRowUnsaved): ZIO[ZConnection, Throwable, ProductRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ProductFields, ProductRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductRow]
  def selectById(productid: ProductId): ZIO[ZConnection, Throwable, Option[ProductRow]]
  def selectByIds(productids: Array[ProductId]): ZStream[ZConnection, Throwable, ProductRow]
  def update(row: ProductRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[ProductFields, ProductRow]
  def upsert(unsaved: ProductRow): ZIO[ZConnection, Throwable, UpdateResult[ProductRow]]
}
