/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.purchaseorderheader

import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams
import zio.Chunk
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

class PurchaseorderheaderRepoMock(toRow: Function1[PurchaseorderheaderRowUnsaved, PurchaseorderheaderRow],
                                  map: scala.collection.mutable.Map[PurchaseorderheaderId, PurchaseorderheaderRow] = scala.collection.mutable.Map.empty) extends PurchaseorderheaderRepo {
  override def delete: DeleteBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    DeleteBuilderMock(DeleteParams.empty, PurchaseorderheaderFields.structure, map)
  }
  override def deleteById(purchaseorderid: PurchaseorderheaderId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(purchaseorderid).isDefined)
  }
  override def deleteByIds(purchaseorderids: Array[PurchaseorderheaderId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(purchaseorderids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: PurchaseorderheaderRow): ZIO[ZConnection, Throwable, PurchaseorderheaderRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.purchaseorderid))
          sys.error(s"id ${unsaved.purchaseorderid} already exists")
        else
          map.put(unsaved.purchaseorderid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: PurchaseorderheaderRowUnsaved): ZIO[ZConnection, Throwable, PurchaseorderheaderRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PurchaseorderheaderRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.purchaseorderid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PurchaseorderheaderRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.purchaseorderid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    SelectBuilderMock(PurchaseorderheaderFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PurchaseorderheaderRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(purchaseorderid: PurchaseorderheaderId): ZIO[ZConnection, Throwable, Option[PurchaseorderheaderRow]] = {
    ZIO.succeed(map.get(purchaseorderid))
  }
  override def selectByIds(purchaseorderids: Array[PurchaseorderheaderId]): ZStream[ZConnection, Throwable, PurchaseorderheaderRow] = {
    ZStream.fromIterable(purchaseorderids.flatMap(map.get))
  }
  override def selectByIdsTracked(purchaseorderids: Array[PurchaseorderheaderId]): ZIO[ZConnection, Throwable, Map[PurchaseorderheaderId, PurchaseorderheaderRow]] = {
    selectByIds(purchaseorderids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.purchaseorderid, x)).toMap
      purchaseorderids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    UpdateBuilderMock(UpdateParams.empty, PurchaseorderheaderFields.structure, map)
  }
  override def update(row: PurchaseorderheaderRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.purchaseorderid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.purchaseorderid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: PurchaseorderheaderRow): ZIO[ZConnection, Throwable, UpdateResult[PurchaseorderheaderRow]] = {
    ZIO.succeed {
      map.put(unsaved.purchaseorderid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, PurchaseorderheaderRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.purchaseorderid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}
