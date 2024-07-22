/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.employee;

import adventureworks.person.businessentity.BusinessentityId;
import scala.annotation.nowarn;
import typo.dsl.DeleteBuilder;
import typo.dsl.DeleteBuilder.DeleteBuilderMock;
import typo.dsl.DeleteParams;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderMock;
import typo.dsl.SelectParams;
import typo.dsl.UpdateBuilder;
import typo.dsl.UpdateBuilder.UpdateBuilderMock;
import typo.dsl.UpdateParams;
import zio.Chunk;
import zio.ZIO;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

class EmployeeRepoMock(val toRow: Function1[EmployeeRowUnsaved, EmployeeRow], val map: scala.collection.mutable.Map[BusinessentityId, EmployeeRow] = scala.collection.mutable.Map.empty) extends EmployeeRepo {
  def delete: DeleteBuilder[EmployeeFields, EmployeeRow] = DeleteBuilderMock(DeleteParams.empty, EmployeeFields.structure, map)
  def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = ZIO.succeed(map.remove(businessentityid).isDefined)
  def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long] = ZIO.succeed(businessentityids.map(id => map.remove(id)).count(_.isDefined).toLong)
  def insert(unsaved: EmployeeRow): ZIO[ZConnection, Throwable, EmployeeRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.businessentityid))
          sys.error(s"id ${unsaved.businessentityid} already exists")
        else
          map.put(unsaved.businessentityid, unsaved)
    
      unsaved
    }
  }
  def insert(unsaved: EmployeeRowUnsaved): ZIO[ZConnection, Throwable, EmployeeRow] = insert(toRow(unsaved))
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeeRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeeRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  def select: SelectBuilder[EmployeeFields, EmployeeRow] = SelectBuilderMock(EmployeeFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  def selectAll: ZStream[ZConnection, Throwable, EmployeeRow] = ZStream.fromIterable(map.values)
  def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[EmployeeRow]] = ZIO.succeed(map.get(businessentityid))
  def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, EmployeeRow] = ZStream.fromIterable(businessentityids.flatMap(map.get))
  def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Map[BusinessentityId, EmployeeRow]] = {
    selectByIds(businessentityids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[EmployeeFields, EmployeeRow] = UpdateBuilderMock(UpdateParams.empty, EmployeeFields.structure, map)
  def update(row: EmployeeRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.businessentityid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.businessentityid, row): @nowarn
          true
        case None => false
      }
    }
  }
  def upsert(unsaved: EmployeeRow): ZIO[ZConnection, Throwable, UpdateResult[EmployeeRow]] = {
    ZIO.succeed {
      map.put(unsaved.businessentityid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeeRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}