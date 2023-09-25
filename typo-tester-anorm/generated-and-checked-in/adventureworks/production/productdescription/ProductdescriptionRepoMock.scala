/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

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
  override def delete(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Boolean = {
    map.remove(productdescriptionid).isDefined
  }
  override def delete: DeleteBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductdescriptionFields, map)
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
  override def select: SelectBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    SelectBuilderMock(ProductdescriptionFields, () => map.values.toList, SelectParams.empty)
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
  override def update(row: ProductdescriptionRow)(implicit c: Connection): Boolean = {
    map.get(row.productdescriptionid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.productdescriptionid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductdescriptionFields, map)
  }
  override def upsert(unsaved: ProductdescriptionRow)(implicit c: Connection): ProductdescriptionRow = {
    map.put(unsaved.productdescriptionid, unsaved): @nowarn
    unsaved
  }
}
