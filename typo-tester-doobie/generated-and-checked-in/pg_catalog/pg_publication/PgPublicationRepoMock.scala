/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

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

class PgPublicationRepoMock(map: scala.collection.mutable.Map[PgPublicationId, PgPublicationRow] = scala.collection.mutable.Map.empty) extends PgPublicationRepo {
  override def delete(oid: PgPublicationId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgPublicationFields, PgPublicationRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgPublicationFields, map)
  }
  override def insert(unsaved: PgPublicationRow): ConnectionIO[PgPublicationRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgPublicationFields, PgPublicationRow] = {
    SelectBuilderMock(PgPublicationFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgPublicationRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgPublicationId): ConnectionIO[Option[PgPublicationRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgPublicationId]): Stream[ConnectionIO, PgPublicationRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgPublicationRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgPublicationFields, PgPublicationRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgPublicationFields, map)
  }
  override def upsert(unsaved: PgPublicationRow): ConnectionIO[PgPublicationRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
