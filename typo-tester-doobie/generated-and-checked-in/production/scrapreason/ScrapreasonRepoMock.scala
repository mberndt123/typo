/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class ScrapreasonRepoMock(toRow: Function1[ScrapreasonRowUnsaved, ScrapreasonRow],
                          map: scala.collection.mutable.Map[ScrapreasonId, ScrapreasonRow] = scala.collection.mutable.Map.empty) extends ScrapreasonRepo {
  override def delete(scrapreasonid: ScrapreasonId): ConnectionIO[Boolean] = {
    delay(map.remove(scrapreasonid).isDefined)
  }
  override def delete: DeleteBuilder[ScrapreasonFields, ScrapreasonRow] = {
    DeleteBuilderMock(DeleteParams.empty, ScrapreasonFields, map)
  }
  override def insert(unsaved: ScrapreasonRow): ConnectionIO[ScrapreasonRow] = {
    delay {
      if (map.contains(unsaved.scrapreasonid))
        sys.error(s"id ${unsaved.scrapreasonid} already exists")
      else
        map.put(unsaved.scrapreasonid, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: ScrapreasonRowUnsaved): ConnectionIO[ScrapreasonRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[ScrapreasonFields, ScrapreasonRow] = {
    SelectBuilderMock(ScrapreasonFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ScrapreasonRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(scrapreasonid: ScrapreasonId): ConnectionIO[Option[ScrapreasonRow]] = {
    delay(map.get(scrapreasonid))
  }
  override def selectByIds(scrapreasonids: Array[ScrapreasonId]): Stream[ConnectionIO, ScrapreasonRow] = {
    Stream.emits(scrapreasonids.flatMap(map.get).toList)
  }
  override def update(row: ScrapreasonRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.scrapreasonid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.scrapreasonid, row)
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ScrapreasonFields, ScrapreasonRow] = {
    UpdateBuilderMock(UpdateParams.empty, ScrapreasonFields, map)
  }
  override def upsert(unsaved: ScrapreasonRow): ConnectionIO[ScrapreasonRow] = {
    delay {
      map.put(unsaved.scrapreasonid, unsaved)
      unsaved
    }
  }
}
