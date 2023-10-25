/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

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

class ProductphotoRepoMock(toRow: Function1[ProductphotoRowUnsaved, ProductphotoRow],
                           map: scala.collection.mutable.Map[ProductphotoId, ProductphotoRow] = scala.collection.mutable.Map.empty) extends ProductphotoRepo {
  override def delete(productphotoid: ProductphotoId): ConnectionIO[Boolean] = {
    delay(map.remove(productphotoid).isDefined)
  }
  override def delete: DeleteBuilder[ProductphotoFields, ProductphotoRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductphotoFields, map)
  }
  override def insert(unsaved: ProductphotoRow): ConnectionIO[ProductphotoRow] = {
    delay {
      val _ = if (map.contains(unsaved.productphotoid))
        sys.error(s"id ${unsaved.productphotoid} already exists")
      else
        map.put(unsaved.productphotoid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductphotoRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.productphotoid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: ProductphotoRowUnsaved): ConnectionIO[ProductphotoRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductphotoRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.productphotoid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[ProductphotoFields, ProductphotoRow] = {
    SelectBuilderMock(ProductphotoFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductphotoRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(productphotoid: ProductphotoId): ConnectionIO[Option[ProductphotoRow]] = {
    delay(map.get(productphotoid))
  }
  override def selectByIds(productphotoids: Array[ProductphotoId]): Stream[ConnectionIO, ProductphotoRow] = {
    Stream.emits(productphotoids.flatMap(map.get).toList)
  }
  override def update(row: ProductphotoRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.productphotoid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productphotoid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ProductphotoFields, ProductphotoRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductphotoFields, map)
  }
  override def upsert(unsaved: ProductphotoRow): ConnectionIO[ProductphotoRow] = {
    delay {
      map.put(unsaved.productphotoid, unsaved): @nowarn
      unsaved
    }
  }
}
