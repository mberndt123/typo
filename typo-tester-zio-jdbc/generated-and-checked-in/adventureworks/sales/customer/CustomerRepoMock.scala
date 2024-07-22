/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.customer

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

class CustomerRepoMock(toRow: Function1[CustomerRowUnsaved, CustomerRow],
                       map: scala.collection.mutable.Map[CustomerId, CustomerRow] = scala.collection.mutable.Map.empty) extends CustomerRepo {
  override def delete: DeleteBuilder[CustomerFields, CustomerRow] = {
    DeleteBuilderMock(DeleteParams.empty, CustomerFields.structure, map)
  }
  override def deleteById(customerid: CustomerId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(customerid).isDefined)
  }
  override def deleteByIds(customerids: Array[CustomerId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(customerids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: CustomerRow): ZIO[ZConnection, Throwable, CustomerRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.customerid))
          sys.error(s"id ${unsaved.customerid} already exists")
        else
          map.put(unsaved.customerid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: CustomerRowUnsaved): ZIO[ZConnection, Throwable, CustomerRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CustomerRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.customerid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CustomerRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.customerid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[CustomerFields, CustomerRow] = {
    SelectBuilderMock(CustomerFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CustomerRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(customerid: CustomerId): ZIO[ZConnection, Throwable, Option[CustomerRow]] = {
    ZIO.succeed(map.get(customerid))
  }
  override def selectByIds(customerids: Array[CustomerId]): ZStream[ZConnection, Throwable, CustomerRow] = {
    ZStream.fromIterable(customerids.flatMap(map.get))
  }
  override def selectByIdsTracked(customerids: Array[CustomerId]): ZIO[ZConnection, Throwable, Map[CustomerId, CustomerRow]] = {
    selectByIds(customerids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.customerid, x)).toMap
      customerids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[CustomerFields, CustomerRow] = {
    UpdateBuilderMock(UpdateParams.empty, CustomerFields.structure, map)
  }
  override def update(row: CustomerRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.customerid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.customerid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: CustomerRow): ZIO[ZConnection, Throwable, UpdateResult[CustomerRow]] = {
    ZIO.succeed {
      map.put(unsaved.customerid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, CustomerRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.customerid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}
