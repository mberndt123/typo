/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productdescription

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

class ProductdescriptionRepoMock(toRow: Function1[ProductdescriptionRowUnsaved, ProductdescriptionRow],
                                 map: scala.collection.mutable.Map[ProductdescriptionId, ProductdescriptionRow] = scala.collection.mutable.Map.empty) extends ProductdescriptionRepo {
  override def delete: DeleteBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductdescriptionFields.structure, map)
  }
  override def deleteById(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Boolean = {
    map.remove(productdescriptionid).isDefined
  }
  override def deleteByIds(productdescriptionids: Array[ProductdescriptionId])(implicit c: Connection): Int = {
    productdescriptionids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ProductdescriptionRow)(implicit c: Connection): ProductdescriptionRow = {
    val _ = if (map.contains(unsaved.productdescriptionid))
      sys.error(s"id ${unsaved.productdescriptionid} already exists")
    else
      map.put(unsaved.productdescriptionid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ProductdescriptionRowUnsaved)(implicit c: Connection): ProductdescriptionRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ProductdescriptionRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.productdescriptionid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductdescriptionRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.productdescriptionid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    SelectBuilderMock(ProductdescriptionFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductdescriptionRow] = {
    map.values.toList
  }
  override def selectById(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Option[ProductdescriptionRow] = {
    map.get(productdescriptionid)
  }
  override def selectByIds(productdescriptionids: Array[ProductdescriptionId])(implicit c: Connection): List[ProductdescriptionRow] = {
    productdescriptionids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(productdescriptionids: Array[ProductdescriptionId])(implicit c: Connection): Map[ProductdescriptionId, ProductdescriptionRow] = {
    val byId = selectByIds(productdescriptionids).view.map(x => (x.productdescriptionid, x)).toMap
    productdescriptionids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductdescriptionFields.structure, map)
  }
  override def update(row: ProductdescriptionRow)(implicit c: Connection): Boolean = {
    map.get(row.productdescriptionid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.productdescriptionid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ProductdescriptionRow)(implicit c: Connection): ProductdescriptionRow = {
    map.put(unsaved.productdescriptionid, unsaved): @nowarn
    unsaved
  }
  override def upsertBatch(unsaved: Iterable[ProductdescriptionRow])(implicit c: Connection): List[ProductdescriptionRow] = {
    unsaved.map { row =>
      map += (row.productdescriptionid -> row)
      row
    }.toList
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[ProductdescriptionRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.productdescriptionid -> row)
    }
    unsaved.size
  }
}
