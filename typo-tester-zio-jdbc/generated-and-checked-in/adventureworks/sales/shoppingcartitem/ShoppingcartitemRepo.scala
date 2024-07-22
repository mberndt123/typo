/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.shoppingcartitem;

import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

/** upsertBatch: Not implementable for zio-jdbc */
trait ShoppingcartitemRepo {
  def delete: DeleteBuilder[ShoppingcartitemFields, ShoppingcartitemRow]
  def deleteById(shoppingcartitemid: ShoppingcartitemId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(shoppingcartitemids: Array[ShoppingcartitemId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ShoppingcartitemRow): ZIO[ZConnection, Throwable, ShoppingcartitemRow]
  def insert(unsaved: ShoppingcartitemRowUnsaved): ZIO[ZConnection, Throwable, ShoppingcartitemRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ShoppingcartitemRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ShoppingcartitemRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ShoppingcartitemFields, ShoppingcartitemRow]
  def selectAll: ZStream[ZConnection, Throwable, ShoppingcartitemRow]
  def selectById(shoppingcartitemid: ShoppingcartitemId): ZIO[ZConnection, Throwable, Option[ShoppingcartitemRow]]
  def selectByIds(shoppingcartitemids: Array[ShoppingcartitemId]): ZStream[ZConnection, Throwable, ShoppingcartitemRow]
  def selectByIdsTracked(shoppingcartitemids: Array[ShoppingcartitemId]): ZIO[ZConnection, Throwable, Map[ShoppingcartitemId, ShoppingcartitemRow]]
  def update: UpdateBuilder[ShoppingcartitemFields, ShoppingcartitemRow]
  def update(row: ShoppingcartitemRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: ShoppingcartitemRow): ZIO[ZConnection, Throwable, UpdateResult[ShoppingcartitemRow]]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ShoppingcartitemRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}