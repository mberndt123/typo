/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import java.sql.Connection
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

class LocationRepoMock(toRow: Function1[LocationRowUnsaved, LocationRow],
                       map: scala.collection.mutable.Map[LocationId, LocationRow] = scala.collection.mutable.Map.empty) extends LocationRepo {
  override def delete(locationid: LocationId)(implicit c: Connection): Boolean = {
    map.remove(locationid).isDefined
  }
  override def delete: DeleteBuilder[LocationFields, LocationRow] = {
    DeleteBuilderMock(DeleteParams.empty, LocationFields, map)
  }
  override def insert(unsaved: LocationRow)(implicit c: Connection): LocationRow = {
    val _ = if (map.contains(unsaved.locationid))
      sys.error(s"id ${unsaved.locationid} already exists")
    else
      map.put(unsaved.locationid, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[LocationRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.locationid -> row)
    }
    unsaved.size.toLong
  }
  override def insert(unsaved: LocationRowUnsaved)(implicit c: Connection): LocationRow = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[LocationRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.locationid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[LocationFields, LocationRow] = {
    SelectBuilderMock(LocationFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[LocationRow] = {
    map.values.toList
  }
  override def selectById(locationid: LocationId)(implicit c: Connection): Option[LocationRow] = {
    map.get(locationid)
  }
  override def selectByIds(locationids: Array[LocationId])(implicit c: Connection): List[LocationRow] = {
    locationids.flatMap(map.get).toList
  }
  override def update(row: LocationRow)(implicit c: Connection): Boolean = {
    map.get(row.locationid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.locationid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[LocationFields, LocationRow] = {
    UpdateBuilderMock(UpdateParams.empty, LocationFields, map)
  }
  override def upsert(unsaved: LocationRow)(implicit c: Connection): LocationRow = {
    map.put(unsaved.locationid, unsaved): @nowarn
    unsaved
  }
}
