/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.countryregioncurrency

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
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

class CountryregioncurrencyRepoMock(toRow: Function1[CountryregioncurrencyRowUnsaved, CountryregioncurrencyRow],
                                    map: scala.collection.mutable.Map[CountryregioncurrencyId, CountryregioncurrencyRow] = scala.collection.mutable.Map.empty) extends CountryregioncurrencyRepo {
  override def delete: DeleteBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    DeleteBuilderMock(DeleteParams.empty, CountryregioncurrencyFields.structure, map)
  }
  override def deleteById(compositeId: CountryregioncurrencyId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[CountryregioncurrencyId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: CountryregioncurrencyRow): ConnectionIO[CountryregioncurrencyRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: CountryregioncurrencyRowUnsaved): ConnectionIO[CountryregioncurrencyRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CountryregioncurrencyRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CountryregioncurrencyRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    SelectBuilderMock(CountryregioncurrencyFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, CountryregioncurrencyRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: CountryregioncurrencyId): ConnectionIO[Option[CountryregioncurrencyRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[CountryregioncurrencyId]): Stream[ConnectionIO, CountryregioncurrencyRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(compositeIds: Array[CountryregioncurrencyId]): ConnectionIO[Map[CountryregioncurrencyId, CountryregioncurrencyRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    UpdateBuilderMock(UpdateParams.empty, CountryregioncurrencyFields.structure, map)
  }
  override def update(row: CountryregioncurrencyRow): ConnectionIO[Boolean] = {
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
  override def upsert(unsaved: CountryregioncurrencyRow): ConnectionIO[CountryregioncurrencyRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
  override def upsertBatch(unsaved: List[CountryregioncurrencyRow]): Stream[ConnectionIO, CountryregioncurrencyRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.compositeId -> row)
        row
      }
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, CountryregioncurrencyRow], batchSize: Int = 10000): ConnectionIO[Int] = {
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
