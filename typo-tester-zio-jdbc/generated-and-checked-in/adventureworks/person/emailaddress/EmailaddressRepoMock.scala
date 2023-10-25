/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

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

class EmailaddressRepoMock(toRow: Function1[EmailaddressRowUnsaved, EmailaddressRow],
                           map: scala.collection.mutable.Map[EmailaddressId, EmailaddressRow] = scala.collection.mutable.Map.empty) extends EmailaddressRepo {
  override def delete(compositeId: EmailaddressId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow] = {
    DeleteBuilderMock(DeleteParams.empty, EmailaddressFields, map)
  }
  override def insert(unsaved: EmailaddressRow): ZIO[ZConnection, Throwable, EmailaddressRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmailaddressRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: EmailaddressRowUnsaved): ZIO[ZConnection, Throwable, EmailaddressRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmailaddressRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[EmailaddressFields, EmailaddressRow] = {
    SelectBuilderMock(EmailaddressFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, EmailaddressRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: EmailaddressId): ZIO[ZConnection, Throwable, Option[EmailaddressRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def update(row: EmailaddressRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[EmailaddressFields, EmailaddressRow] = {
    UpdateBuilderMock(UpdateParams.empty, EmailaddressFields, map)
  }
  override def upsert(unsaved: EmailaddressRow): ZIO[ZConnection, Throwable, UpdateResult[EmailaddressRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
