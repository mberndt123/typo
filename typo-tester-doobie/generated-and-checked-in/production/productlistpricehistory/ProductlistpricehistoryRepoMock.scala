/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

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

class ProductlistpricehistoryRepoMock(toRow: Function1[ProductlistpricehistoryRowUnsaved, ProductlistpricehistoryRow],
                                      map: scala.collection.mutable.Map[ProductlistpricehistoryId, ProductlistpricehistoryRow] = scala.collection.mutable.Map.empty) extends ProductlistpricehistoryRepo {
  override def delete(compositeId: ProductlistpricehistoryId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductlistpricehistoryFields, map)
  }
  override def insert(unsaved: ProductlistpricehistoryRow): ConnectionIO[ProductlistpricehistoryRow] = {
    delay {
      if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: ProductlistpricehistoryRowUnsaved): ConnectionIO[ProductlistpricehistoryRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = {
    SelectBuilderMock(ProductlistpricehistoryFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductlistpricehistoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: ProductlistpricehistoryId): ConnectionIO[Option[ProductlistpricehistoryRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: ProductlistpricehistoryRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row)
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductlistpricehistoryFields, map)
  }
  override def upsert(unsaved: ProductlistpricehistoryRow): ConnectionIO[ProductlistpricehistoryRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
}
