/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productlistpricehistory;

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

class ProductlistpricehistoryRepoMock(val toRow: Function1[ProductlistpricehistoryRowUnsaved, ProductlistpricehistoryRow], val map: scala.collection.mutable.Map[ProductlistpricehistoryId, ProductlistpricehistoryRow] = scala.collection.mutable.Map.empty) extends ProductlistpricehistoryRepo {
  def delete: DeleteBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = DeleteBuilderMock(DeleteParams.empty, ProductlistpricehistoryFields.structure, map)
  def deleteById(compositeId: ProductlistpricehistoryId)(implicit c: Connection): Boolean = map.remove(compositeId).isDefined
  def deleteByIds(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): Int = compositeIds.map(id => map.remove(id)).count(_.isDefined)
  def insert(unsaved: ProductlistpricehistoryRow)(implicit c: Connection): ProductlistpricehistoryRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  def insert(unsaved: ProductlistpricehistoryRowUnsaved)(implicit c: Connection): ProductlistpricehistoryRow = insert(toRow(unsaved))
  def insertStreaming(unsaved: Iterator[ProductlistpricehistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductlistpricehistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  def select: SelectBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = SelectBuilderMock(ProductlistpricehistoryFields.structure, () => map.values.toList, SelectParams.empty)
  def selectAll(implicit c: Connection): List[ProductlistpricehistoryRow] = map.values.toList
  def selectById(compositeId: ProductlistpricehistoryId)(implicit c: Connection): Option[ProductlistpricehistoryRow] = map.get(compositeId)
  def selectByIds(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): List[ProductlistpricehistoryRow] = compositeIds.flatMap(map.get).toList
  def selectByIdsTracked(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): Map[ProductlistpricehistoryId, ProductlistpricehistoryRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  def update: UpdateBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = UpdateBuilderMock(UpdateParams.empty, ProductlistpricehistoryFields.structure, map)
  def update(row: ProductlistpricehistoryRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  def upsert(unsaved: ProductlistpricehistoryRow)(implicit c: Connection): ProductlistpricehistoryRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
  def upsertBatch(unsaved: Iterable[ProductlistpricehistoryRow])(implicit c: Connection): List[ProductlistpricehistoryRow] = {
    unsaved.map { row =>
      map += (row.compositeId -> row)
      row
    }.toList
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ProductlistpricehistoryRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size
  }
}