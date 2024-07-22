/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productinventory;

import doobie.free.connection.ConnectionIO;
import doobie.free.connection.delay;
import fs2.Stream;
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

class ProductinventoryRepoMock(val toRow: Function1[ProductinventoryRowUnsaved, ProductinventoryRow], val map: scala.collection.mutable.Map[ProductinventoryId, ProductinventoryRow] = scala.collection.mutable.Map.empty) extends ProductinventoryRepo {
  def delete: DeleteBuilder[ProductinventoryFields, ProductinventoryRow] = DeleteBuilderMock(DeleteParams.empty, ProductinventoryFields.structure, map)
  def deleteById(compositeId: ProductinventoryId): ConnectionIO[Boolean] = delay(map.remove(compositeId).isDefined)
  def deleteByIds(compositeIds: Array[ProductinventoryId]): ConnectionIO[Int] = delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  def insert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  def insert(unsaved: ProductinventoryRowUnsaved): ConnectionIO[ProductinventoryRow] = insert(toRow(unsaved))
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductinventoryRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductinventoryRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  def select: SelectBuilder[ProductinventoryFields, ProductinventoryRow] = SelectBuilderMock(ProductinventoryFields.structure, delay(map.values.toList), SelectParams.empty)
  def selectAll: Stream[ConnectionIO, ProductinventoryRow] = Stream.emits(map.values.toList)
  def selectById(compositeId: ProductinventoryId): ConnectionIO[Option[ProductinventoryRow]] = delay(map.get(compositeId))
  def selectByIds(compositeIds: Array[ProductinventoryId]): Stream[ConnectionIO, ProductinventoryRow] = Stream.emits(compositeIds.flatMap(map.get).toList)
  def selectByIdsTracked(compositeIds: Array[ProductinventoryId]): ConnectionIO[Map[ProductinventoryId, ProductinventoryRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[ProductinventoryFields, ProductinventoryRow] = UpdateBuilderMock(UpdateParams.empty, ProductinventoryFields.structure, map)
  def update(row: ProductinventoryRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row): @nowarn
          true
        case None => false
      }
    }
  }
  def upsert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
  def upsertBatch(unsaved: List[ProductinventoryRow]): Stream[ConnectionIO, ProductinventoryRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.compositeId -> row)
        row
      }
    }
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, ProductinventoryRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    unsaved.compile.toList.map { rows =>
      var num = 0
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
}