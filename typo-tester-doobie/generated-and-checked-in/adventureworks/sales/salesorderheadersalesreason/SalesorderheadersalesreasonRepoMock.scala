/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

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

class SalesorderheadersalesreasonRepoMock(toRow: Function1[SalesorderheadersalesreasonRowUnsaved, SalesorderheadersalesreasonRow],
                                          map: scala.collection.mutable.Map[SalesorderheadersalesreasonId, SalesorderheadersalesreasonRow] = scala.collection.mutable.Map.empty) extends SalesorderheadersalesreasonRepo {
  override def delete(compositeId: SalesorderheadersalesreasonId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesorderheadersalesreasonFields, map)
  }
  override def insert(unsaved: SalesorderheadersalesreasonRow): ConnectionIO[SalesorderheadersalesreasonRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: SalesorderheadersalesreasonRowUnsaved): ConnectionIO[SalesorderheadersalesreasonRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    SelectBuilderMock(SalesorderheadersalesreasonFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, SalesorderheadersalesreasonRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: SalesorderheadersalesreasonId): ConnectionIO[Option[SalesorderheadersalesreasonRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: SalesorderheadersalesreasonRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesorderheadersalesreasonFields, map)
  }
  override def upsert(unsaved: SalesorderheadersalesreasonRow): ConnectionIO[SalesorderheadersalesreasonRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
