/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class ProductRepoMock(toRow: Function1[ProductRowUnsaved, ProductRow],
                      map: scala.collection.mutable.Map[ProductId, ProductRow] = scala.collection.mutable.Map.empty) extends ProductRepo {
  override def delete(productid: ProductId): ConnectionIO[Boolean] = {
    delay(map.remove(productid).isDefined)
  }
  override def delete: DeleteBuilder[ProductFields, ProductRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductFields, map)
  }
  override def insert(unsaved: ProductRow): ConnectionIO[ProductRow] = {
    delay {
      if (map.contains(unsaved.productid))
        sys.error(s"id ${unsaved.productid} already exists")
      else
        map.put(unsaved.productid, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: ProductRowUnsaved): ConnectionIO[ProductRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[ProductFields, ProductRow] = {
    SelectBuilderMock(ProductFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(productid: ProductId): ConnectionIO[Option[ProductRow]] = {
    delay(map.get(productid))
  }
  override def selectByIds(productids: Array[ProductId]): Stream[ConnectionIO, ProductRow] = {
    Stream.emits(productids.flatMap(map.get).toList)
  }
  override def update(row: ProductRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.productid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productid, row)
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ProductFields, ProductRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductFields, map)
  }
  override def upsert(unsaved: ProductRow): ConnectionIO[ProductRow] = {
    delay {
      map.put(unsaved.productid, unsaved)
      unsaved
    }
  }
}
