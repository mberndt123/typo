/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

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

class CultureRepoMock(toRow: Function1[CultureRowUnsaved, CultureRow],
                      map: scala.collection.mutable.Map[CultureId, CultureRow] = scala.collection.mutable.Map.empty) extends CultureRepo {
  override def delete(cultureid: CultureId): ConnectionIO[Boolean] = {
    delay(map.remove(cultureid).isDefined)
  }
  override def delete: DeleteBuilder[CultureFields, CultureRow] = {
    DeleteBuilderMock(DeleteParams.empty, CultureFields, map)
  }
  override def insert(unsaved: CultureRow): ConnectionIO[CultureRow] = {
    delay {
      val _ = if (map.contains(unsaved.cultureid))
        sys.error(s"id ${unsaved.cultureid} already exists")
      else
        map.put(unsaved.cultureid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CultureRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.cultureid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: CultureRowUnsaved): ConnectionIO[CultureRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CultureRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.cultureid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[CultureFields, CultureRow] = {
    SelectBuilderMock(CultureFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, CultureRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(cultureid: CultureId): ConnectionIO[Option[CultureRow]] = {
    delay(map.get(cultureid))
  }
  override def selectByIds(cultureids: Array[CultureId]): Stream[ConnectionIO, CultureRow] = {
    Stream.emits(cultureids.flatMap(map.get).toList)
  }
  override def update(row: CultureRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.cultureid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.cultureid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[CultureFields, CultureRow] = {
    UpdateBuilderMock(UpdateParams.empty, CultureFields, map)
  }
  override def upsert(unsaved: CultureRow): ConnectionIO[CultureRow] = {
    delay {
      map.put(unsaved.cultureid, unsaved): @nowarn
      unsaved
    }
  }
}
