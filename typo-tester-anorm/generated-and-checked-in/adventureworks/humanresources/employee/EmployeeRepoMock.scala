/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

import adventureworks.person.businessentity.BusinessentityId
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

class EmployeeRepoMock(toRow: Function1[EmployeeRowUnsaved, EmployeeRow],
                       map: scala.collection.mutable.Map[BusinessentityId, EmployeeRow] = scala.collection.mutable.Map.empty) extends EmployeeRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    map.remove(businessentityid).isDefined
  }
  override def delete: DeleteBuilder[EmployeeFields, EmployeeRow] = {
    DeleteBuilderMock(DeleteParams.empty, EmployeeFields, map)
  }
  override def insert(unsaved: EmployeeRow)(implicit c: Connection): EmployeeRow = {
    val _ = if (map.contains(unsaved.businessentityid))
      sys.error(s"id ${unsaved.businessentityid} already exists")
    else
      map.put(unsaved.businessentityid, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[EmployeeRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.businessentityid -> row)
    }
    unsaved.size.toLong
  }
  override def insert(unsaved: EmployeeRowUnsaved)(implicit c: Connection): EmployeeRow = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[EmployeeRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.businessentityid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[EmployeeFields, EmployeeRow] = {
    SelectBuilderMock(EmployeeFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[EmployeeRow] = {
    map.values.toList
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[EmployeeRow] = {
    map.get(businessentityid)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[EmployeeRow] = {
    businessentityids.flatMap(map.get).toList
  }
  override def update(row: EmployeeRow)(implicit c: Connection): Boolean = {
    map.get(row.businessentityid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.businessentityid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[EmployeeFields, EmployeeRow] = {
    UpdateBuilderMock(UpdateParams.empty, EmployeeFields, map)
  }
  override def upsert(unsaved: EmployeeRow)(implicit c: Connection): EmployeeRow = {
    map.put(unsaved.businessentityid, unsaved): @nowarn
    unsaved
  }
}
