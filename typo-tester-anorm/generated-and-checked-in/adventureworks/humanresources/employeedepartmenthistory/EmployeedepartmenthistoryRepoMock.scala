/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.employeedepartmenthistory;

import java.sql.Connection;
import scala.annotation.nowarn;
import typo.dsl.DeleteBuilder;
import typo.dsl.DeleteBuilder.DeleteBuilderMock;
import typo.dsl.DeleteParams;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderMock;
import typo.dsl.SelectParams;
import typo.dsl.UpdateBuilder;
import typo.dsl.UpdateBuilder.UpdateBuilderMock;
import typo.dsl.UpdateParams;

class EmployeedepartmenthistoryRepoMock(val toRow: Function1[EmployeedepartmenthistoryRowUnsaved, EmployeedepartmenthistoryRow], val map: scala.collection.mutable.Map[EmployeedepartmenthistoryId, EmployeedepartmenthistoryRow] = scala.collection.mutable.Map.empty) extends EmployeedepartmenthistoryRepo {
  def delete: DeleteBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = DeleteBuilderMock(DeleteParams.empty, EmployeedepartmenthistoryFields.structure, map)
  def deleteById(compositeId: EmployeedepartmenthistoryId)(implicit c: Connection): Boolean = map.remove(compositeId).isDefined
  def deleteByIds(compositeIds: Array[EmployeedepartmenthistoryId])(implicit c: Connection): Int = compositeIds.map(id => map.remove(id)).count(_.isDefined)
  def insert(unsaved: EmployeedepartmenthistoryRow)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  def insert(unsaved: EmployeedepartmenthistoryRowUnsaved)(implicit c: Connection): EmployeedepartmenthistoryRow = insert(toRow(unsaved))
  def insertStreaming(unsaved: Iterator[EmployeedepartmenthistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[EmployeedepartmenthistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  def select: SelectBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = SelectBuilderMock(EmployeedepartmenthistoryFields.structure, () => map.values.toList, SelectParams.empty)
  def selectAll(implicit c: Connection): List[EmployeedepartmenthistoryRow] = map.values.toList
  def selectById(compositeId: EmployeedepartmenthistoryId)(implicit c: Connection): Option[EmployeedepartmenthistoryRow] = map.get(compositeId)
  def selectByIds(compositeIds: Array[EmployeedepartmenthistoryId])(implicit c: Connection): List[EmployeedepartmenthistoryRow] = compositeIds.flatMap(map.get).toList
  def selectByIdsTracked(compositeIds: Array[EmployeedepartmenthistoryId])(implicit c: Connection): Map[EmployeedepartmenthistoryId, EmployeedepartmenthistoryRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  def update: UpdateBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = UpdateBuilderMock(UpdateParams.empty, EmployeedepartmenthistoryFields.structure, map)
  def update(row: EmployeedepartmenthistoryRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  def upsert(unsaved: EmployeedepartmenthistoryRow)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
  def upsertBatch(unsaved: Iterable[EmployeedepartmenthistoryRow])(implicit c: Connection): List[EmployeedepartmenthistoryRow] = {
    unsaved.map { row =>
      map += (row.compositeId -> row)
      row
    }.toList
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[EmployeedepartmenthistoryRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size
  }
}