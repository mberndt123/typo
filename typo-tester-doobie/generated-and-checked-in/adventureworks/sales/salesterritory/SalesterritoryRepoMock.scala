/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

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

class SalesterritoryRepoMock(toRow: Function1[SalesterritoryRowUnsaved, SalesterritoryRow],
                             map: scala.collection.mutable.Map[SalesterritoryId, SalesterritoryRow] = scala.collection.mutable.Map.empty) extends SalesterritoryRepo {
  override def delete(territoryid: SalesterritoryId): ConnectionIO[Boolean] = {
    delay(map.remove(territoryid).isDefined)
  }
  override def delete: DeleteBuilder[SalesterritoryFields, SalesterritoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesterritoryFields, map)
  }
  override def insert(unsaved: SalesterritoryRow): ConnectionIO[SalesterritoryRow] = {
    delay {
      val _ = if (map.contains(unsaved.territoryid))
        sys.error(s"id ${unsaved.territoryid} already exists")
      else
        map.put(unsaved.territoryid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SalesterritoryRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.territoryid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: SalesterritoryRowUnsaved): ConnectionIO[SalesterritoryRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesterritoryRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.territoryid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[SalesterritoryFields, SalesterritoryRow] = {
    SelectBuilderMock(SalesterritoryFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, SalesterritoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(territoryid: SalesterritoryId): ConnectionIO[Option[SalesterritoryRow]] = {
    delay(map.get(territoryid))
  }
  override def selectByIds(territoryids: Array[SalesterritoryId]): Stream[ConnectionIO, SalesterritoryRow] = {
    Stream.emits(territoryids.flatMap(map.get).toList)
  }
  override def update(row: SalesterritoryRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.territoryid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.territoryid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[SalesterritoryFields, SalesterritoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesterritoryFields, map)
  }
  override def upsert(unsaved: SalesterritoryRow): ConnectionIO[SalesterritoryRow] = {
    delay {
      map.put(unsaved.territoryid, unsaved): @nowarn
      unsaved
    }
  }
}
