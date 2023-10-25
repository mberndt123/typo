/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

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

class DepartmentRepoMock(toRow: Function1[DepartmentRowUnsaved, DepartmentRow],
                         map: scala.collection.mutable.Map[DepartmentId, DepartmentRow] = scala.collection.mutable.Map.empty) extends DepartmentRepo {
  override def delete(departmentid: DepartmentId): ConnectionIO[Boolean] = {
    delay(map.remove(departmentid).isDefined)
  }
  override def delete: DeleteBuilder[DepartmentFields, DepartmentRow] = {
    DeleteBuilderMock(DeleteParams.empty, DepartmentFields, map)
  }
  override def insert(unsaved: DepartmentRow): ConnectionIO[DepartmentRow] = {
    delay {
      val _ = if (map.contains(unsaved.departmentid))
        sys.error(s"id ${unsaved.departmentid} already exists")
      else
        map.put(unsaved.departmentid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, DepartmentRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.departmentid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: DepartmentRowUnsaved): ConnectionIO[DepartmentRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, DepartmentRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.departmentid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[DepartmentFields, DepartmentRow] = {
    SelectBuilderMock(DepartmentFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, DepartmentRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(departmentid: DepartmentId): ConnectionIO[Option[DepartmentRow]] = {
    delay(map.get(departmentid))
  }
  override def selectByIds(departmentids: Array[DepartmentId]): Stream[ConnectionIO, DepartmentRow] = {
    Stream.emits(departmentids.flatMap(map.get).toList)
  }
  override def update(row: DepartmentRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.departmentid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.departmentid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[DepartmentFields, DepartmentRow] = {
    UpdateBuilderMock(UpdateParams.empty, DepartmentFields, map)
  }
  override def upsert(unsaved: DepartmentRow): ConnectionIO[DepartmentRow] = {
    delay {
      map.put(unsaved.departmentid, unsaved): @nowarn
      unsaved
    }
  }
}
