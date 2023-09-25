/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

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

class ProductdescriptionRepoMock(toRow: Function1[ProductdescriptionRowUnsaved, ProductdescriptionRow],
                                 map: scala.collection.mutable.Map[ProductdescriptionId, ProductdescriptionRow] = scala.collection.mutable.Map.empty) extends ProductdescriptionRepo {
  override def delete(productdescriptionid: ProductdescriptionId): ConnectionIO[Boolean] = {
    delay(map.remove(productdescriptionid).isDefined)
  }
  override def delete: DeleteBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductdescriptionFields, map)
  }
  override def insert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow] = {
    delay {
      val _ = if (map.contains(unsaved.productdescriptionid))
        sys.error(s"id ${unsaved.productdescriptionid} already exists")
      else
        map.put(unsaved.productdescriptionid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ProductdescriptionRowUnsaved): ConnectionIO[ProductdescriptionRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    SelectBuilderMock(ProductdescriptionFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductdescriptionRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(productdescriptionid: ProductdescriptionId): ConnectionIO[Option[ProductdescriptionRow]] = {
    delay(map.get(productdescriptionid))
  }
  override def selectByIds(productdescriptionids: Array[ProductdescriptionId]): Stream[ConnectionIO, ProductdescriptionRow] = {
    Stream.emits(productdescriptionids.flatMap(map.get).toList)
  }
  override def update(row: ProductdescriptionRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.productdescriptionid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productdescriptionid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductdescriptionFields, map)
  }
  override def upsert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow] = {
    delay {
      map.put(unsaved.productdescriptionid, unsaved): @nowarn
      unsaved
    }
  }
}
