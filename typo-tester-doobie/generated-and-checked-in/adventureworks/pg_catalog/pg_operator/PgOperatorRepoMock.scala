/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_operator

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

class PgOperatorRepoMock(map: scala.collection.mutable.Map[PgOperatorId, PgOperatorRow] = scala.collection.mutable.Map.empty) extends PgOperatorRepo {
  override def delete(oid: PgOperatorId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgOperatorFields, PgOperatorRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgOperatorFields, map)
  }
  override def insert(unsaved: PgOperatorRow): ConnectionIO[PgOperatorRow] = {
    delay {
      val _ = if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgOperatorFields, PgOperatorRow] = {
    SelectBuilderMock(PgOperatorFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgOperatorRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgOperatorId): ConnectionIO[Option[PgOperatorRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgOperatorId]): Stream[ConnectionIO, PgOperatorRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def selectByUnique(oprname: String, oprleft: /* oid */ Long, oprright: /* oid */ Long, oprnamespace: /* oid */ Long): ConnectionIO[Option[PgOperatorRow]] = {
    delay(map.values.find(v => oprname == v.oprname && oprleft == v.oprleft && oprright == v.oprright && oprnamespace == v.oprnamespace))
  }
  override def update(row: PgOperatorRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgOperatorFields, PgOperatorRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgOperatorFields, map)
  }
  override def upsert(unsaved: PgOperatorRow): ConnectionIO[PgOperatorRow] = {
    delay {
      map.put(unsaved.oid, unsaved): @nowarn
      unsaved
    }
  }
}
