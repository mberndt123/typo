/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.store;

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

class StoreRepoMock(val toRow: Function1[StoreRowUnsaved, StoreRow], val map: scala.collection.mutable.Map[BusinessentityId, StoreRow] = scala.collection.mutable.Map.empty) extends StoreRepo {
  def delete: DeleteBuilder[StoreFields, StoreRow] = DeleteBuilderMock(DeleteParams.empty, StoreFields.structure, map)
  def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = ZIO.succeed(map.remove(businessentityid).isDefined)
  def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long] = ZIO.succeed(businessentityids.map(id => map.remove(id)).count(_.isDefined).toLong)
  def insert(unsaved: StoreRow): ZIO[ZConnection, Throwable, StoreRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.businessentityid))
          sys.error(s"id ${unsaved.businessentityid} already exists")
        else
          map.put(unsaved.businessentityid, unsaved)
    
      unsaved
    }
  }
  def insert(unsaved: StoreRowUnsaved): ZIO[ZConnection, Throwable, StoreRow] = insert(toRow(unsaved))
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, StoreRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, StoreRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  def select: SelectBuilder[StoreFields, StoreRow] = SelectBuilderMock(StoreFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  def selectAll: ZStream[ZConnection, Throwable, StoreRow] = ZStream.fromIterable(map.values)
  def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[StoreRow]] = ZIO.succeed(map.get(businessentityid))
  def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, StoreRow] = ZStream.fromIterable(businessentityids.flatMap(map.get))
  def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Map[BusinessentityId, StoreRow]] = {
    selectByIds(businessentityids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[StoreFields, StoreRow] = UpdateBuilderMock(UpdateParams.empty, StoreFields.structure, map)
  def update(row: StoreRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  def upsert(unsaved: StoreRow): ZIO[ZConnection, Throwable, UpdateResult[StoreRow]] = {
    ZIO.succeed {
      map.put(unsaved.businessentityid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, StoreRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}