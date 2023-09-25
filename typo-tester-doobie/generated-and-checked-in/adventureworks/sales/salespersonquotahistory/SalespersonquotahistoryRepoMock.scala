/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

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

class SalespersonquotahistoryRepoMock(toRow: Function1[SalespersonquotahistoryRowUnsaved, SalespersonquotahistoryRow],
                                      map: scala.collection.mutable.Map[SalespersonquotahistoryId, SalespersonquotahistoryRow] = scala.collection.mutable.Map.empty) extends SalespersonquotahistoryRepo {
  override def delete(compositeId: SalespersonquotahistoryId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalespersonquotahistoryFields, map)
  }
  override def insert(unsaved: SalespersonquotahistoryRow): ConnectionIO[SalespersonquotahistoryRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: SalespersonquotahistoryRowUnsaved): ConnectionIO[SalespersonquotahistoryRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    SelectBuilderMock(SalespersonquotahistoryFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, SalespersonquotahistoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: SalespersonquotahistoryId): ConnectionIO[Option[SalespersonquotahistoryRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: SalespersonquotahistoryRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalespersonquotahistoryFields, map)
  }
  override def upsert(unsaved: SalespersonquotahistoryRow): ConnectionIO[SalespersonquotahistoryRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
