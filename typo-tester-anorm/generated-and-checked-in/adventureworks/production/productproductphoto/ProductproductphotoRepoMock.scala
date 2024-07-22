/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productproductphoto;

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

class ProductproductphotoRepoMock(val toRow: Function1[ProductproductphotoRowUnsaved, ProductproductphotoRow], val map: scala.collection.mutable.Map[ProductproductphotoId, ProductproductphotoRow] = scala.collection.mutable.Map.empty) extends ProductproductphotoRepo {
  def delete: DeleteBuilder[ProductproductphotoFields, ProductproductphotoRow] = DeleteBuilderMock(DeleteParams.empty, ProductproductphotoFields.structure, map)
  def deleteById(compositeId: ProductproductphotoId)(implicit c: Connection): Boolean = map.remove(compositeId).isDefined
  def deleteByIds(compositeIds: Array[ProductproductphotoId])(implicit c: Connection): Int = compositeIds.map(id => map.remove(id)).count(_.isDefined)
  def insert(unsaved: ProductproductphotoRow)(implicit c: Connection): ProductproductphotoRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  def insert(unsaved: ProductproductphotoRowUnsaved)(implicit c: Connection): ProductproductphotoRow = insert(toRow(unsaved))
  def insertStreaming(unsaved: Iterator[ProductproductphotoRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductproductphotoRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  def select: SelectBuilder[ProductproductphotoFields, ProductproductphotoRow] = SelectBuilderMock(ProductproductphotoFields.structure, () => map.values.toList, SelectParams.empty)
  def selectAll(implicit c: Connection): List[ProductproductphotoRow] = map.values.toList
  def selectById(compositeId: ProductproductphotoId)(implicit c: Connection): Option[ProductproductphotoRow] = map.get(compositeId)
  def selectByIds(compositeIds: Array[ProductproductphotoId])(implicit c: Connection): List[ProductproductphotoRow] = compositeIds.flatMap(map.get).toList
  def selectByIdsTracked(compositeIds: Array[ProductproductphotoId])(implicit c: Connection): Map[ProductproductphotoId, ProductproductphotoRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  def update: UpdateBuilder[ProductproductphotoFields, ProductproductphotoRow] = UpdateBuilderMock(UpdateParams.empty, ProductproductphotoFields.structure, map)
  def update(row: ProductproductphotoRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  def upsert(unsaved: ProductproductphotoRow)(implicit c: Connection): ProductproductphotoRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
  def upsertBatch(unsaved: Iterable[ProductproductphotoRow])(implicit c: Connection): List[ProductproductphotoRow] = {
    unsaved.map { row =>
      map += (row.compositeId -> row)
      row
    }.toList
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ProductproductphotoRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size
  }
}