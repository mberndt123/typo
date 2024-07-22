/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.unitmeasure;

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

class UnitmeasureRepoMock(val toRow: Function1[UnitmeasureRowUnsaved, UnitmeasureRow], val map: scala.collection.mutable.Map[UnitmeasureId, UnitmeasureRow] = scala.collection.mutable.Map.empty) extends UnitmeasureRepo {
  def delete: DeleteBuilder[UnitmeasureFields, UnitmeasureRow] = DeleteBuilderMock(DeleteParams.empty, UnitmeasureFields.structure, map)
  def deleteById(unitmeasurecode: UnitmeasureId)(implicit c: Connection): Boolean = map.remove(unitmeasurecode).isDefined
  def deleteByIds(unitmeasurecodes: Array[UnitmeasureId])(implicit c: Connection): Int = unitmeasurecodes.map(id => map.remove(id)).count(_.isDefined)
  def insert(unsaved: UnitmeasureRow)(implicit c: Connection): UnitmeasureRow = {
    val _ = if (map.contains(unsaved.unitmeasurecode))
      sys.error(s"id ${unsaved.unitmeasurecode} already exists")
    else
      map.put(unsaved.unitmeasurecode, unsaved)
    
    unsaved
  }
  def insert(unsaved: UnitmeasureRowUnsaved)(implicit c: Connection): UnitmeasureRow = insert(toRow(unsaved))
  def insertStreaming(unsaved: Iterator[UnitmeasureRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.unitmeasurecode -> row)
    }
    unsaved.size.toLong
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[UnitmeasureRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.unitmeasurecode -> row)
    }
    unsaved.size.toLong
  }
  def select: SelectBuilder[UnitmeasureFields, UnitmeasureRow] = SelectBuilderMock(UnitmeasureFields.structure, () => map.values.toList, SelectParams.empty)
  def selectAll(implicit c: Connection): List[UnitmeasureRow] = map.values.toList
  def selectById(unitmeasurecode: UnitmeasureId)(implicit c: Connection): Option[UnitmeasureRow] = map.get(unitmeasurecode)
  def selectByIds(unitmeasurecodes: Array[UnitmeasureId])(implicit c: Connection): List[UnitmeasureRow] = unitmeasurecodes.flatMap(map.get).toList
  def selectByIdsTracked(unitmeasurecodes: Array[UnitmeasureId])(implicit c: Connection): Map[UnitmeasureId, UnitmeasureRow] = {
    val byId = selectByIds(unitmeasurecodes).view.map(x => (x.unitmeasurecode, x)).toMap
    unitmeasurecodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  def update: UpdateBuilder[UnitmeasureFields, UnitmeasureRow] = UpdateBuilderMock(UpdateParams.empty, UnitmeasureFields.structure, map)
  def update(row: UnitmeasureRow)(implicit c: Connection): Boolean = {
    map.get(row.unitmeasurecode) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.unitmeasurecode, row): @nowarn
        true
      case None => false
    }
  }
  def upsert(unsaved: UnitmeasureRow)(implicit c: Connection): UnitmeasureRow = {
    map.put(unsaved.unitmeasurecode, unsaved): @nowarn
    unsaved
  }
  def upsertBatch(unsaved: Iterable[UnitmeasureRow])(implicit c: Connection): List[UnitmeasureRow] = {
    unsaved.map { row =>
      map += (row.unitmeasurecode -> row)
      row
    }.toList
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[UnitmeasureRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.unitmeasurecode -> row)
    }
    unsaved.size
  }
}