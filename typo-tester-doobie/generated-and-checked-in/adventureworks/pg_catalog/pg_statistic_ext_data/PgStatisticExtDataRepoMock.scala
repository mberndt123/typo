/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext_data

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

class PgStatisticExtDataRepoMock(map: scala.collection.mutable.Map[PgStatisticExtDataId, PgStatisticExtDataRow] = scala.collection.mutable.Map.empty) extends PgStatisticExtDataRepo {
  override def delete(stxoid: PgStatisticExtDataId): ConnectionIO[Boolean] = {
    delay(map.remove(stxoid).isDefined)
  }
  override def delete: DeleteBuilder[PgStatisticExtDataFields, PgStatisticExtDataRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgStatisticExtDataFields, map)
  }
  override def insert(unsaved: PgStatisticExtDataRow): ConnectionIO[PgStatisticExtDataRow] = {
    delay {
      val _ = if (map.contains(unsaved.stxoid))
        sys.error(s"id ${unsaved.stxoid} already exists")
      else
        map.put(unsaved.stxoid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgStatisticExtDataFields, PgStatisticExtDataRow] = {
    SelectBuilderMock(PgStatisticExtDataFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgStatisticExtDataRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(stxoid: PgStatisticExtDataId): ConnectionIO[Option[PgStatisticExtDataRow]] = {
    delay(map.get(stxoid))
  }
  override def selectByIds(stxoids: Array[PgStatisticExtDataId]): Stream[ConnectionIO, PgStatisticExtDataRow] = {
    Stream.emits(stxoids.flatMap(map.get).toList)
  }
  override def update(row: PgStatisticExtDataRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.stxoid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.stxoid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgStatisticExtDataFields, PgStatisticExtDataRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgStatisticExtDataFields, map)
  }
  override def upsert(unsaved: PgStatisticExtDataRow): ConnectionIO[PgStatisticExtDataRow] = {
    delay {
      map.put(unsaved.stxoid, unsaved): @nowarn
      unsaved
    }
  }
}
