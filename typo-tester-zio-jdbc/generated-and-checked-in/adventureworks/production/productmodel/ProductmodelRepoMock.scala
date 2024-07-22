/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodel;

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

class ProductmodelRepoMock(val toRow: Function1[ProductmodelRowUnsaved, ProductmodelRow], val map: scala.collection.mutable.Map[ProductmodelId, ProductmodelRow] = scala.collection.mutable.Map.empty) extends ProductmodelRepo {
  def delete: DeleteBuilder[ProductmodelFields, ProductmodelRow] = DeleteBuilderMock(DeleteParams.empty, ProductmodelFields.structure, map)
  def deleteById(productmodelid: ProductmodelId): ZIO[ZConnection, Throwable, Boolean] = ZIO.succeed(map.remove(productmodelid).isDefined)
  def deleteByIds(productmodelids: Array[ProductmodelId]): ZIO[ZConnection, Throwable, Long] = ZIO.succeed(productmodelids.map(id => map.remove(id)).count(_.isDefined).toLong)
  def insert(unsaved: ProductmodelRow): ZIO[ZConnection, Throwable, ProductmodelRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.productmodelid))
          sys.error(s"id ${unsaved.productmodelid} already exists")
        else
          map.put(unsaved.productmodelid, unsaved)
    
      unsaved
    }
  }
  def insert(unsaved: ProductmodelRowUnsaved): ZIO[ZConnection, Throwable, ProductmodelRow] = insert(toRow(unsaved))
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.productmodelid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.productmodelid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  def select: SelectBuilder[ProductmodelFields, ProductmodelRow] = SelectBuilderMock(ProductmodelFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  def selectAll: ZStream[ZConnection, Throwable, ProductmodelRow] = ZStream.fromIterable(map.values)
  def selectById(productmodelid: ProductmodelId): ZIO[ZConnection, Throwable, Option[ProductmodelRow]] = ZIO.succeed(map.get(productmodelid))
  def selectByIds(productmodelids: Array[ProductmodelId]): ZStream[ZConnection, Throwable, ProductmodelRow] = ZStream.fromIterable(productmodelids.flatMap(map.get))
  def selectByIdsTracked(productmodelids: Array[ProductmodelId]): ZIO[ZConnection, Throwable, Map[ProductmodelId, ProductmodelRow]] = {
    selectByIds(productmodelids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.productmodelid, x)).toMap
      productmodelids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[ProductmodelFields, ProductmodelRow] = UpdateBuilderMock(UpdateParams.empty, ProductmodelFields.structure, map)
  def update(row: ProductmodelRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.productmodelid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productmodelid, row): @nowarn
          true
        case None => false
      }
    }
  }
  def upsert(unsaved: ProductmodelRow): ZIO[ZConnection, Throwable, UpdateResult[ProductmodelRow]] = {
    ZIO.succeed {
      map.put(unsaved.productmodelid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.productmodelid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}