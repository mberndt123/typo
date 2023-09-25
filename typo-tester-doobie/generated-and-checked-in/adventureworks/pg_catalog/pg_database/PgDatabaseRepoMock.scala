/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_database

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

class PgDatabaseRepoMock(map: scala.collection.mutable.Map[PgDatabaseId, PgDatabaseRow] = scala.collection.mutable.Map.empty) extends PgDatabaseRepo {
  override def delete(oid: PgDatabaseId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgDatabaseFields, PgDatabaseRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgDatabaseFields, map)
  }
  override def insert(unsaved: PgDatabaseRow): ConnectionIO[PgDatabaseRow] = {
    delay {
      val _ = if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgDatabaseFields, PgDatabaseRow] = {
    SelectBuilderMock(PgDatabaseFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgDatabaseRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgDatabaseId): ConnectionIO[Option[PgDatabaseRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgDatabaseId]): Stream[ConnectionIO, PgDatabaseRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def selectByUnique(datname: String): ConnectionIO[Option[PgDatabaseRow]] = {
    delay(map.values.find(v => datname == v.datname))
  }
  override def update(row: PgDatabaseRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.oid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.oid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgDatabaseFields, PgDatabaseRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgDatabaseFields, map)
  }
  override def upsert(unsaved: PgDatabaseRow): ConnectionIO[PgDatabaseRow] = {
    delay {
      map.put(unsaved.oid, unsaved): @nowarn
      unsaved
    }
  }
}
