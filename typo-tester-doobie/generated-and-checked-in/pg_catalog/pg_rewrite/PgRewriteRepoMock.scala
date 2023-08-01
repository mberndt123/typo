/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_rewrite

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

class PgRewriteRepoMock(map: scala.collection.mutable.Map[PgRewriteId, PgRewriteRow] = scala.collection.mutable.Map.empty) extends PgRewriteRepo {
  override def delete(oid: PgRewriteId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgRewriteFields, PgRewriteRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgRewriteFields, map)
  }
  override def insert(unsaved: PgRewriteRow): ConnectionIO[PgRewriteRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgRewriteFields, PgRewriteRow] = {
    SelectBuilderMock(PgRewriteFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgRewriteRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgRewriteId): ConnectionIO[Option[PgRewriteRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgRewriteId]): Stream[ConnectionIO, PgRewriteRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgRewriteRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgRewriteFields, PgRewriteRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgRewriteFields, map)
  }
  override def upsert(unsaved: PgRewriteRow): ConnectionIO[PgRewriteRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
