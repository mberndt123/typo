/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

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

class ShiftRepoMock(toRow: Function1[ShiftRowUnsaved, ShiftRow],
                    map: scala.collection.mutable.Map[ShiftId, ShiftRow] = scala.collection.mutable.Map.empty) extends ShiftRepo {
  override def delete(shiftid: ShiftId): ConnectionIO[Boolean] = {
    delay(map.remove(shiftid).isDefined)
  }
  override def delete: DeleteBuilder[ShiftFields, ShiftRow] = {
    DeleteBuilderMock(DeleteParams.empty, ShiftFields, map)
  }
  override def insert(unsaved: ShiftRow): ConnectionIO[ShiftRow] = {
    delay {
      val _ = if (map.contains(unsaved.shiftid))
        sys.error(s"id ${unsaved.shiftid} already exists")
      else
        map.put(unsaved.shiftid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ShiftRowUnsaved): ConnectionIO[ShiftRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[ShiftFields, ShiftRow] = {
    SelectBuilderMock(ShiftFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ShiftRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(shiftid: ShiftId): ConnectionIO[Option[ShiftRow]] = {
    delay(map.get(shiftid))
  }
  override def selectByIds(shiftids: Array[ShiftId]): Stream[ConnectionIO, ShiftRow] = {
    Stream.emits(shiftids.flatMap(map.get).toList)
  }
  override def update(row: ShiftRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.shiftid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.shiftid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ShiftFields, ShiftRow] = {
    UpdateBuilderMock(UpdateParams.empty, ShiftFields, map)
  }
  override def upsert(unsaved: ShiftRow): ConnectionIO[ShiftRow] = {
    delay {
      map.put(unsaved.shiftid, unsaved): @nowarn
      unsaved
    }
  }
}
