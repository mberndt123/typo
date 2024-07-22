/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentitycontact;

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

class BusinessentitycontactRepoMock(val toRow: Function1[BusinessentitycontactRowUnsaved, BusinessentitycontactRow], val map: scala.collection.mutable.Map[BusinessentitycontactId, BusinessentitycontactRow] = scala.collection.mutable.Map.empty) extends BusinessentitycontactRepo {
  def delete: DeleteBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = DeleteBuilderMock(DeleteParams.empty, BusinessentitycontactFields.structure, map)
  def deleteById(compositeId: BusinessentitycontactId): ConnectionIO[Boolean] = delay(map.remove(compositeId).isDefined)
  def deleteByIds(compositeIds: Array[BusinessentitycontactId]): ConnectionIO[Int] = delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  def insert(unsaved: BusinessentitycontactRow): ConnectionIO[BusinessentitycontactRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  def insert(unsaved: BusinessentitycontactRowUnsaved): ConnectionIO[BusinessentitycontactRow] = insert(toRow(unsaved))
  def insertStreaming(unsaved: Stream[ConnectionIO, BusinessentitycontactRow], batchSize: Int = 10000): ConnectionIO[Long] = {
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
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, BusinessentitycontactRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
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
  def select: SelectBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = SelectBuilderMock(BusinessentitycontactFields.structure, delay(map.values.toList), SelectParams.empty)
  def selectAll: Stream[ConnectionIO, BusinessentitycontactRow] = Stream.emits(map.values.toList)
  def selectById(compositeId: BusinessentitycontactId): ConnectionIO[Option[BusinessentitycontactRow]] = delay(map.get(compositeId))
  def selectByIds(compositeIds: Array[BusinessentitycontactId]): Stream[ConnectionIO, BusinessentitycontactRow] = Stream.emits(compositeIds.flatMap(map.get).toList)
  def selectByIdsTracked(compositeIds: Array[BusinessentitycontactId]): ConnectionIO[Map[BusinessentitycontactId, BusinessentitycontactRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = UpdateBuilderMock(UpdateParams.empty, BusinessentitycontactFields.structure, map)
  def update(row: BusinessentitycontactRow): ConnectionIO[Boolean] = {
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
  def upsert(unsaved: BusinessentitycontactRow): ConnectionIO[BusinessentitycontactRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
  def upsertBatch(unsaved: List[BusinessentitycontactRow]): Stream[ConnectionIO, BusinessentitycontactRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.compositeId -> row)
        row
      }
    }
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, BusinessentitycontactRow], batchSize: Int = 10000): ConnectionIO[Int] = {
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