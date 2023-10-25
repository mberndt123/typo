/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

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

class ProductsubcategoryRepoMock(toRow: Function1[ProductsubcategoryRowUnsaved, ProductsubcategoryRow],
                                 map: scala.collection.mutable.Map[ProductsubcategoryId, ProductsubcategoryRow] = scala.collection.mutable.Map.empty) extends ProductsubcategoryRepo {
  override def delete(productsubcategoryid: ProductsubcategoryId): ConnectionIO[Boolean] = {
    delay(map.remove(productsubcategoryid).isDefined)
  }
  override def delete: DeleteBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductsubcategoryFields, map)
  }
  override def insert(unsaved: ProductsubcategoryRow): ConnectionIO[ProductsubcategoryRow] = {
    delay {
      val _ = if (map.contains(unsaved.productsubcategoryid))
        sys.error(s"id ${unsaved.productsubcategoryid} already exists")
      else
        map.put(unsaved.productsubcategoryid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductsubcategoryRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.productsubcategoryid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: ProductsubcategoryRowUnsaved): ConnectionIO[ProductsubcategoryRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductsubcategoryRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.productsubcategoryid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    SelectBuilderMock(ProductsubcategoryFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductsubcategoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(productsubcategoryid: ProductsubcategoryId): ConnectionIO[Option[ProductsubcategoryRow]] = {
    delay(map.get(productsubcategoryid))
  }
  override def selectByIds(productsubcategoryids: Array[ProductsubcategoryId]): Stream[ConnectionIO, ProductsubcategoryRow] = {
    Stream.emits(productsubcategoryids.flatMap(map.get).toList)
  }
  override def update(row: ProductsubcategoryRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.productsubcategoryid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productsubcategoryid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductsubcategoryFields, map)
  }
  override def upsert(unsaved: ProductsubcategoryRow): ConnectionIO[ProductsubcategoryRow] = {
    delay {
      map.put(unsaved.productsubcategoryid, unsaved): @nowarn
      unsaved
    }
  }
}
