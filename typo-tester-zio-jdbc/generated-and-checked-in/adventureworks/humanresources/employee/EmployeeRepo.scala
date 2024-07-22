/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.employee;

import adventureworks.person.businessentity.BusinessentityId;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

/** upsertBatch: Not implementable for zio-jdbc */
trait EmployeeRepo {
  def delete: DeleteBuilder[EmployeeFields, EmployeeRow]
  def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: EmployeeRow): ZIO[ZConnection, Throwable, EmployeeRow]
  def insert(unsaved: EmployeeRowUnsaved): ZIO[ZConnection, Throwable, EmployeeRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeeRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeeRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[EmployeeFields, EmployeeRow]
  def selectAll: ZStream[ZConnection, Throwable, EmployeeRow]
  def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[EmployeeRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, EmployeeRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Map[BusinessentityId, EmployeeRow]]
  def update: UpdateBuilder[EmployeeFields, EmployeeRow]
  def update(row: EmployeeRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: EmployeeRow): ZIO[ZConnection, Throwable, UpdateResult[EmployeeRow]]
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeeRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}