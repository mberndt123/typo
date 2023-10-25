/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

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

class SpecialofferproductRepoMock(toRow: Function1[SpecialofferproductRowUnsaved, SpecialofferproductRow],
                                  map: scala.collection.mutable.Map[SpecialofferproductId, SpecialofferproductRow] = scala.collection.mutable.Map.empty) extends SpecialofferproductRepo {
  override def delete(compositeId: SpecialofferproductId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    DeleteBuilderMock(DeleteParams.empty, SpecialofferproductFields, map)
  }
  override def insert(unsaved: SpecialofferproductRow): ZIO[ZConnection, Throwable, SpecialofferproductRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SpecialofferproductRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: SpecialofferproductRowUnsaved): ZIO[ZConnection, Throwable, SpecialofferproductRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SpecialofferproductRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    SelectBuilderMock(SpecialofferproductFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SpecialofferproductRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: SpecialofferproductId): ZIO[ZConnection, Throwable, Option[SpecialofferproductRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def update(row: SpecialofferproductRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    UpdateBuilderMock(UpdateParams.empty, SpecialofferproductFields, map)
  }
  override def upsert(unsaved: SpecialofferproductRow): ZIO[ZConnection, Throwable, UpdateResult[SpecialofferproductRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
