/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.illustration;

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

class IllustrationRepoMock(val toRow: Function1[IllustrationRowUnsaved, IllustrationRow], val map: scala.collection.mutable.Map[IllustrationId, IllustrationRow] = scala.collection.mutable.Map.empty) extends IllustrationRepo {
  def delete: DeleteBuilder[IllustrationFields, IllustrationRow] = DeleteBuilderMock(DeleteParams.empty, IllustrationFields.structure, map)
  def deleteById(illustrationid: IllustrationId): ZIO[ZConnection, Throwable, Boolean] = ZIO.succeed(map.remove(illustrationid).isDefined)
  def deleteByIds(illustrationids: Array[IllustrationId]): ZIO[ZConnection, Throwable, Long] = ZIO.succeed(illustrationids.map(id => map.remove(id)).count(_.isDefined).toLong)
  def insert(unsaved: IllustrationRow): ZIO[ZConnection, Throwable, IllustrationRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.illustrationid))
          sys.error(s"id ${unsaved.illustrationid} already exists")
        else
          map.put(unsaved.illustrationid, unsaved)
    
      unsaved
    }
  }
  def insert(unsaved: IllustrationRowUnsaved): ZIO[ZConnection, Throwable, IllustrationRow] = insert(toRow(unsaved))
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, IllustrationRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.illustrationid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, IllustrationRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.illustrationid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  def select: SelectBuilder[IllustrationFields, IllustrationRow] = SelectBuilderMock(IllustrationFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  def selectAll: ZStream[ZConnection, Throwable, IllustrationRow] = ZStream.fromIterable(map.values)
  def selectById(illustrationid: IllustrationId): ZIO[ZConnection, Throwable, Option[IllustrationRow]] = ZIO.succeed(map.get(illustrationid))
  def selectByIds(illustrationids: Array[IllustrationId]): ZStream[ZConnection, Throwable, IllustrationRow] = ZStream.fromIterable(illustrationids.flatMap(map.get))
  def selectByIdsTracked(illustrationids: Array[IllustrationId]): ZIO[ZConnection, Throwable, Map[IllustrationId, IllustrationRow]] = {
    selectByIds(illustrationids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.illustrationid, x)).toMap
      illustrationids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[IllustrationFields, IllustrationRow] = UpdateBuilderMock(UpdateParams.empty, IllustrationFields.structure, map)
  def update(row: IllustrationRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.illustrationid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.illustrationid, row): @nowarn
          true
        case None => false
      }
    }
  }
  def upsert(unsaved: IllustrationRow): ZIO[ZConnection, Throwable, UpdateResult[IllustrationRow]] = {
    ZIO.succeed {
      map.put(unsaved.illustrationid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, IllustrationRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.illustrationid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}