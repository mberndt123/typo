/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

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

class EmployeepayhistoryRepoMock(toRow: Function1[EmployeepayhistoryRowUnsaved, EmployeepayhistoryRow],
                                 map: scala.collection.mutable.Map[EmployeepayhistoryId, EmployeepayhistoryRow] = scala.collection.mutable.Map.empty) extends EmployeepayhistoryRepo {
  override def delete(compositeId: EmployeepayhistoryId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, EmployeepayhistoryFields, map)
  }
  override def insert(unsaved: EmployeepayhistoryRow): ConnectionIO[EmployeepayhistoryRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: EmployeepayhistoryRowUnsaved): ConnectionIO[EmployeepayhistoryRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    SelectBuilderMock(EmployeepayhistoryFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, EmployeepayhistoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: EmployeepayhistoryId): ConnectionIO[Option[EmployeepayhistoryRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: EmployeepayhistoryRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, EmployeepayhistoryFields, map)
  }
  override def upsert(unsaved: EmployeepayhistoryRow): ConnectionIO[EmployeepayhistoryRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
