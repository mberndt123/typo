/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject_metadata

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

class PgLargeobjectMetadataRepoMock(map: scala.collection.mutable.Map[PgLargeobjectMetadataId, PgLargeobjectMetadataRow] = scala.collection.mutable.Map.empty) extends PgLargeobjectMetadataRepo {
  override def delete(oid: PgLargeobjectMetadataId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgLargeobjectMetadataFields, PgLargeobjectMetadataRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgLargeobjectMetadataFields, map)
  }
  override def insert(unsaved: PgLargeobjectMetadataRow): ConnectionIO[PgLargeobjectMetadataRow] = {
    delay {
      val _ = if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgLargeobjectMetadataFields, PgLargeobjectMetadataRow] = {
    SelectBuilderMock(PgLargeobjectMetadataFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgLargeobjectMetadataRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgLargeobjectMetadataId): ConnectionIO[Option[PgLargeobjectMetadataRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgLargeobjectMetadataId]): Stream[ConnectionIO, PgLargeobjectMetadataRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgLargeobjectMetadataRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgLargeobjectMetadataFields, PgLargeobjectMetadataRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgLargeobjectMetadataFields, map)
  }
  override def upsert(unsaved: PgLargeobjectMetadataRow): ConnectionIO[PgLargeobjectMetadataRow] = {
    delay {
      map.put(unsaved.oid, unsaved): @nowarn
      unsaved
    }
  }
}
