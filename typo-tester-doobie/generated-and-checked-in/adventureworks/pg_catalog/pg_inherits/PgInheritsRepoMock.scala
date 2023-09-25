/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_inherits

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

class PgInheritsRepoMock(map: scala.collection.mutable.Map[PgInheritsId, PgInheritsRow] = scala.collection.mutable.Map.empty) extends PgInheritsRepo {
  override def delete(compositeId: PgInheritsId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[PgInheritsFields, PgInheritsRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgInheritsFields, map)
  }
  override def insert(unsaved: PgInheritsRow): ConnectionIO[PgInheritsRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgInheritsFields, PgInheritsRow] = {
    SelectBuilderMock(PgInheritsFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgInheritsRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: PgInheritsId): ConnectionIO[Option[PgInheritsRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: PgInheritsRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgInheritsFields, PgInheritsRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgInheritsFields, map)
  }
  override def upsert(unsaved: PgInheritsRow): ConnectionIO[PgInheritsRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
