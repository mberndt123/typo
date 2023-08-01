/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_extension

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

class PgExtensionRepoMock(map: scala.collection.mutable.Map[PgExtensionId, PgExtensionRow] = scala.collection.mutable.Map.empty) extends PgExtensionRepo {
  override def delete(oid: PgExtensionId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgExtensionFields, PgExtensionRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgExtensionFields, map)
  }
  override def insert(unsaved: PgExtensionRow): ConnectionIO[PgExtensionRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgExtensionFields, PgExtensionRow] = {
    SelectBuilderMock(PgExtensionFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgExtensionRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgExtensionId): ConnectionIO[Option[PgExtensionRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgExtensionId]): Stream[ConnectionIO, PgExtensionRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgExtensionRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.oid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.oid, row)
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgExtensionFields, PgExtensionRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgExtensionFields, map)
  }
  override def upsert(unsaved: PgExtensionRow): ConnectionIO[PgExtensionRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
