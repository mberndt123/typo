/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

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

class ProductdescriptionRepoMock(toRow: Function1[ProductdescriptionRowUnsaved, ProductdescriptionRow],
                                 map: scala.collection.mutable.Map[ProductdescriptionId, ProductdescriptionRow] = scala.collection.mutable.Map.empty) extends ProductdescriptionRepo {
  override def delete(productdescriptionid: ProductdescriptionId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(productdescriptionid).isDefined)
  }
  override def delete: DeleteBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductdescriptionFields, map)
  }
  override def insert(unsaved: ProductdescriptionRow): ZIO[ZConnection, Throwable, ProductdescriptionRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.productdescriptionid))
          sys.error(s"id ${unsaved.productdescriptionid} already exists")
        else
          map.put(unsaved.productdescriptionid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductdescriptionRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.productdescriptionid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: ProductdescriptionRowUnsaved): ZIO[ZConnection, Throwable, ProductdescriptionRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductdescriptionRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.productdescriptionid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    SelectBuilderMock(ProductdescriptionFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductdescriptionRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(productdescriptionid: ProductdescriptionId): ZIO[ZConnection, Throwable, Option[ProductdescriptionRow]] = {
    ZIO.succeed(map.get(productdescriptionid))
  }
  override def selectByIds(productdescriptionids: Array[ProductdescriptionId]): ZStream[ZConnection, Throwable, ProductdescriptionRow] = {
    ZStream.fromIterable(productdescriptionids.flatMap(map.get))
  }
  override def update(row: ProductdescriptionRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.productdescriptionid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productdescriptionid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductdescriptionFields, map)
  }
  override def upsert(unsaved: ProductdescriptionRow): ZIO[ZConnection, Throwable, UpdateResult[ProductdescriptionRow]] = {
    ZIO.succeed {
      map.put(unsaved.productdescriptionid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
