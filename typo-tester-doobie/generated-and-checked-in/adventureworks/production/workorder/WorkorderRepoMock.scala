/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

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

class WorkorderRepoMock(toRow: Function1[WorkorderRowUnsaved, WorkorderRow],
                        map: scala.collection.mutable.Map[WorkorderId, WorkorderRow] = scala.collection.mutable.Map.empty) extends WorkorderRepo {
  override def delete(workorderid: WorkorderId): ConnectionIO[Boolean] = {
    delay(map.remove(workorderid).isDefined)
  }
  override def delete: DeleteBuilder[WorkorderFields, WorkorderRow] = {
    DeleteBuilderMock(DeleteParams.empty, WorkorderFields, map)
  }
  override def insert(unsaved: WorkorderRow): ConnectionIO[WorkorderRow] = {
    delay {
      val _ = if (map.contains(unsaved.workorderid))
        sys.error(s"id ${unsaved.workorderid} already exists")
      else
        map.put(unsaved.workorderid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: WorkorderRowUnsaved): ConnectionIO[WorkorderRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[WorkorderFields, WorkorderRow] = {
    SelectBuilderMock(WorkorderFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, WorkorderRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(workorderid: WorkorderId): ConnectionIO[Option[WorkorderRow]] = {
    delay(map.get(workorderid))
  }
  override def selectByIds(workorderids: Array[WorkorderId]): Stream[ConnectionIO, WorkorderRow] = {
    Stream.emits(workorderids.flatMap(map.get).toList)
  }
  override def update(row: WorkorderRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.workorderid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.workorderid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[WorkorderFields, WorkorderRow] = {
    UpdateBuilderMock(UpdateParams.empty, WorkorderFields, map)
  }
  override def upsert(unsaved: WorkorderRow): ConnectionIO[WorkorderRow] = {
    delay {
      map.put(unsaved.workorderid, unsaved): @nowarn
      unsaved
    }
  }
}
