/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_origin

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

class PgReplicationOriginRepoMock(map: scala.collection.mutable.Map[PgReplicationOriginId, PgReplicationOriginRow] = scala.collection.mutable.Map.empty) extends PgReplicationOriginRepo {
  override def delete(roident: PgReplicationOriginId): ConnectionIO[Boolean] = {
    delay(map.remove(roident).isDefined)
  }
  override def delete: DeleteBuilder[PgReplicationOriginFields, PgReplicationOriginRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgReplicationOriginFields, map)
  }
  override def insert(unsaved: PgReplicationOriginRow): ConnectionIO[PgReplicationOriginRow] = {
    delay {
      val _ = if (map.contains(unsaved.roident))
        sys.error(s"id ${unsaved.roident} already exists")
      else
        map.put(unsaved.roident, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgReplicationOriginFields, PgReplicationOriginRow] = {
    SelectBuilderMock(PgReplicationOriginFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgReplicationOriginRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(roident: PgReplicationOriginId): ConnectionIO[Option[PgReplicationOriginRow]] = {
    delay(map.get(roident))
  }
  override def selectByIds(roidents: Array[PgReplicationOriginId]): Stream[ConnectionIO, PgReplicationOriginRow] = {
    Stream.emits(roidents.flatMap(map.get).toList)
  }
  override def selectByUnique(roname: String): ConnectionIO[Option[PgReplicationOriginRow]] = {
    delay(map.values.find(v => roname == v.roname))
  }
  override def update(row: PgReplicationOriginRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.roident) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.roident, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgReplicationOriginFields, PgReplicationOriginRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgReplicationOriginFields, map)
  }
  override def upsert(unsaved: PgReplicationOriginRow): ConnectionIO[PgReplicationOriginRow] = {
    delay {
      map.put(unsaved.roident, unsaved): @nowarn
      unsaved
    }
  }
}
